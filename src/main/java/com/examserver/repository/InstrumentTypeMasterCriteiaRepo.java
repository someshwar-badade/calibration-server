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

import com.examserver.model.InstrumentTypeMaster;
import com.examserver.model.CommonPage;
import com.examserver.model.SearchCriteria;

@Repository
public class InstrumentTypeMasterCriteiaRepo {

	private final EntityManager em;
	private final CriteriaBuilder cb;
	
	public InstrumentTypeMasterCriteiaRepo(EntityManager em) {
		
		this.em = em;
		this.cb = em.getCriteriaBuilder();
	}
	
	public Page<InstrumentTypeMaster> findAllWithFilter(CommonPage instrumentTypeMasterPage,
			SearchCriteria instrumentTypeMasterSearchCrieteria){
		
		CriteriaQuery<InstrumentTypeMaster> criteriaQuery = cb.createQuery(InstrumentTypeMaster.class);
		Root<InstrumentTypeMaster> instrumentTypeRoot = criteriaQuery.from(InstrumentTypeMaster.class);
		Predicate predicate = getPredicate(instrumentTypeMasterSearchCrieteria,instrumentTypeRoot);
		criteriaQuery.where(predicate);
		setOrder(instrumentTypeMasterPage,criteriaQuery,instrumentTypeRoot);
		
		TypedQuery<InstrumentTypeMaster> typedQuery = em.createQuery(criteriaQuery);
		
		
		typedQuery.setFirstResult(instrumentTypeMasterPage.getPageNumber()*instrumentTypeMasterPage.getPageSize());
		typedQuery.setMaxResults(instrumentTypeMasterPage.getPageSize());
		
		
		Pageable pageable = getPageable(instrumentTypeMasterPage);
		
		long totalCount = getTotalCount(predicate);
		
		return new PageImpl<InstrumentTypeMaster>(typedQuery.getResultList(),pageable,totalCount);
	}

	

	


	private Predicate getPredicate(SearchCriteria instrumentTypeMasterSearchCrieteria,
			Root<InstrumentTypeMaster> instrumentTypeRoot) {
		List<Predicate> predicates = new ArrayList<>();
		if(Objects.nonNull(instrumentTypeMasterSearchCrieteria.getSearchKeyWord())) {
			predicates.add(
					cb.like(instrumentTypeRoot.get("shortName"), "%"+instrumentTypeMasterSearchCrieteria.getSearchKeyWord()+"%")
					);
			predicates.add(
					cb.like(instrumentTypeRoot.get("description"), "%"+instrumentTypeMasterSearchCrieteria.getSearchKeyWord()+"%")
					);
		}
		
//		if(Objects.nonNull(instrumentTypeMasterSearchCrieteria.getDescription())) {
//			predicates.add(
//					cb.like(instrumentTypeRoot.get("description"), "%"+instrumentTypeMasterSearchCrieteria.getDescription()+"%")
//					);
//		}
		
		return cb.or(predicates.toArray(new Predicate[0]));
		
	}
	
	private void setOrder(CommonPage instrumentTypeMasterPage,
			CriteriaQuery<InstrumentTypeMaster> criteriaQuery, Root<InstrumentTypeMaster> instrumentTypeRoot) {
		if(instrumentTypeMasterPage.getSortDirection().equals(Sort.Direction.ASC)) {
			criteriaQuery.orderBy(cb.asc(instrumentTypeRoot.get(instrumentTypeMasterPage.getSortBy())));
		}else {
			criteriaQuery.orderBy(cb.desc(instrumentTypeRoot.get(instrumentTypeMasterPage.getSortBy())));
		}
		
	}
	
	private Pageable getPageable(CommonPage instrumentTypeMasterPage) {
		Sort sort = Sort.by(instrumentTypeMasterPage.getSortDirection(),instrumentTypeMasterPage.getSortBy());
		return PageRequest.of(instrumentTypeMasterPage.getPageNumber(), instrumentTypeMasterPage.getPageSize(), sort);
	}
	

	private long getTotalCount(Predicate predicate) {
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<InstrumentTypeMaster> cr = cq.from(InstrumentTypeMaster.class);
		cq.select(cb.count(cr)).where(predicate);
		return em.createQuery(cq).getSingleResult();
	}
	
}
