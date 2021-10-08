package com.examserver.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.examserver.model.CommonPage;
import com.examserver.model.InstrumentCalibration;
import com.examserver.model.SearchCriteria;

@Repository
public class InstrumentCalibrationCriteriaRepo {
	private final EntityManager em;
	private final CriteriaBuilder cb;
	
	public InstrumentCalibrationCriteriaRepo(EntityManager em) {
			
			this.em = em;
			this.cb = em.getCriteriaBuilder();
		}
	
public Page<InstrumentCalibration> findAllWithFilter(CommonPage commonPage,SearchCriteria searchCrieteria){
		
		CriteriaQuery<InstrumentCalibration> criteriaQuery = cb.createQuery(InstrumentCalibration.class);
		Root<InstrumentCalibration> root = criteriaQuery.from(InstrumentCalibration.class);
		Predicate predicate = getPredicate(searchCrieteria,root);
		
		criteriaQuery.where(predicate);
		setOrder(commonPage,criteriaQuery,root);
		
		TypedQuery<InstrumentCalibration> typedQuery = em.createQuery(criteriaQuery);
		
		
		typedQuery.setFirstResult(commonPage.getPageNumber()*commonPage.getPageSize());
		typedQuery.setMaxResults(commonPage.getPageSize());
		
		
		Pageable pageable = getPageable(commonPage);
		
		long totalCount = getTotalCount(predicate);
		
		return new PageImpl<InstrumentCalibration>(typedQuery.getResultList(),pageable,totalCount);
	}



	private Predicate getPredicate(SearchCriteria searchCrieteria, Root<InstrumentCalibration> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(Objects.nonNull(searchCrieteria.getSearchKeyWord())) {
			predicates.add(
					cb.like(root.get("logno"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
//			predicates.add(
//					cb.like(root.get("dateOfCalibration"), "%"+searchCrieteria.getSearchKeyWord()+"%")
//					);
			
			predicates.add(
					cb.like(root.get("refNo"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("remark"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("doneBy"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
//			predicates.add(
//					cb.like(root.get("calibrationCompletedDate"), "%"+searchCrieteria.getSearchKeyWord()+"%")
//					);
			
			predicates.add(
					cb.like(root.get("certificateNo"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
		}
		
		
		return cb.or(predicates.toArray(new Predicate[0]));
		
	}
	
	private void setOrder(CommonPage commonPage,
			CriteriaQuery<InstrumentCalibration> criteriaQuery, Root<InstrumentCalibration> root) {
		if(commonPage.getSortDirection().equals(Sort.Direction.ASC)) {
			criteriaQuery.orderBy(cb.asc(root.get(commonPage.getSortBy())));
		}else {
			criteriaQuery.orderBy(cb.desc(root.get(commonPage.getSortBy())));
		}
		
	}
	
	private Pageable getPageable(CommonPage commonPage) {
		Sort sort = Sort.by(commonPage.getSortDirection(),commonPage.getSortBy());
		return PageRequest.of(commonPage.getPageNumber(), commonPage.getPageSize(), sort);
	}
	

	private long getTotalCount(Predicate predicate) {
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<InstrumentCalibration> cr = cq.from(InstrumentCalibration.class);
		cq.select(cb.count(cr)).where(predicate);
		return em.createQuery(cq).getSingleResult();
	}
	
}
