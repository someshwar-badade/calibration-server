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
import com.examserver.model.InstrumentMaster;
import com.examserver.model.SearchCriteria;

@Repository
public class InstrumentMasterCriteriaRepo {

	private final EntityManager em;
	private final CriteriaBuilder cb;
	
	public InstrumentMasterCriteriaRepo(EntityManager em) {
		
		this.em = em;
		this.cb = em.getCriteriaBuilder();
	}
	
	public Page<InstrumentMaster> findAllWithFilter(CommonPage commonPage,SearchCriteria searchCrieteria){
		
		CriteriaQuery<InstrumentMaster> criteriaQuery = cb.createQuery(InstrumentMaster.class);
		Root<InstrumentMaster> root = criteriaQuery.from(InstrumentMaster.class);
		Predicate predicate = getPredicate(searchCrieteria,root);
		criteriaQuery.where(predicate);
		setOrder(commonPage,criteriaQuery,root);
		
		TypedQuery<InstrumentMaster> typedQuery = em.createQuery(criteriaQuery);
		
		
		typedQuery.setFirstResult(commonPage.getPageNumber()*commonPage.getPageSize());
		typedQuery.setMaxResults(commonPage.getPageSize());
		
		
		Pageable pageable = getPageable(commonPage);
		
		long totalCount = getTotalCount(predicate);
		
		return new PageImpl<InstrumentMaster>(typedQuery.getResultList(),pageable,totalCount);
	}



	private Predicate getPredicate(SearchCriteria searchCrieteria, Root<InstrumentMaster> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(Objects.nonNull(searchCrieteria.getSearchKeyWord())) {
			predicates.add(
					cb.like(root.get("code"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("description"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("make"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("purchaseDate"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("calibrationFrequency").as(String.class), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("nextCalibrationDate"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("lastCalibrationDate"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("whereUsed"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("calibrationRange"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("accuracy"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("accuracyUom"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("masterStd"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("leastCount").as(String.class), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
		}
		
//		if(Objects.nonNull(instrumentTypeMasterSearchCrieteria.getDescription())) {
//			predicates.add(
//					cb.like(instrumentTypeRoot.get("description"), "%"+instrumentTypeMasterSearchCrieteria.getDescription()+"%")
//					);
//		}
		
		return cb.or(predicates.toArray(new Predicate[0]));
		
	}
	
	private void setOrder(CommonPage commonPage,
			CriteriaQuery<InstrumentMaster> criteriaQuery, Root<InstrumentMaster> root) {
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
		Root<InstrumentMaster> cr = cq.from(InstrumentMaster.class);
		cq.select(cb.count(cr)).where(predicate);
		return em.createQuery(cq).getSingleResult();
	}
}
