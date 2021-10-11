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

import com.examserver.model.CalibrationAgency;
import com.examserver.model.CommonPage;
import com.examserver.model.SearchCriteria;

@Repository
public class CalibrationAgencyCriteriaRepo {
	private final EntityManager em;
	private final CriteriaBuilder cb;
	
	public CalibrationAgencyCriteriaRepo(EntityManager em) {
			
			this.em = em;
			this.cb = em.getCriteriaBuilder();
		}
	
public Page<CalibrationAgency> findAllWithFilter(CommonPage commonPage,SearchCriteria searchCrieteria){
		
		CriteriaQuery<CalibrationAgency> criteriaQuery = cb.createQuery(CalibrationAgency.class);
		Root<CalibrationAgency> root = criteriaQuery.from(CalibrationAgency.class);
		Predicate predicate = getPredicate(searchCrieteria,root);
		
		criteriaQuery.where(predicate);
		setOrder(commonPage,criteriaQuery,root);
		
		TypedQuery<CalibrationAgency> typedQuery = em.createQuery(criteriaQuery);
		
		
		typedQuery.setFirstResult(commonPage.getPageNumber()*commonPage.getPageSize());
		typedQuery.setMaxResults(commonPage.getPageSize());
		
		
		Pageable pageable = getPageable(commonPage);
		
		long totalCount = getTotalCount(predicate);
		
		return new PageImpl<CalibrationAgency>(typedQuery.getResultList(),pageable,totalCount);
	}



	private Predicate getPredicate(SearchCriteria searchCrieteria, Root<CalibrationAgency> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(Objects.nonNull(searchCrieteria.getSearchKeyWord())) {
			predicates.add(
					cb.like(root.get("name"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			
			predicates.add(
					cb.like(root.get("address"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("email"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
			predicates.add(
					cb.like(root.get("mobile"), "%"+searchCrieteria.getSearchKeyWord()+"%")
					);
			
		}
		
		
		return cb.or(predicates.toArray(new Predicate[0]));
		
	}
	
	private void setOrder(CommonPage commonPage,
			CriteriaQuery<CalibrationAgency> criteriaQuery, Root<CalibrationAgency> root) {
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
		Root<CalibrationAgency> cr = cq.from(CalibrationAgency.class);
		cq.select(cb.count(cr)).where(predicate);
		return em.createQuery(cq).getSingleResult();
	}
	
}
