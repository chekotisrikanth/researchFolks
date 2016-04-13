package com.marketing.tool.utility;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.ReportStatus;
import com.marketing.tool.vo.SearchCriteria;

/**
 * @author Anilkumar Ravula
 *
 */
public class ReportSearchFilter {

	 public static Specification<ReportForm> findByCriteriaForindustry(final SearchCriteria searchCriteria) {

	        return new Specification<ReportForm>() {

	            @Override
	            public Predicate toPredicate(Root<ReportForm> root,CriteriaQuery<?> query, CriteriaBuilder cb) {
	            	
	                List<Predicate> predicates = new ArrayList<Predicate>();
	                final Join<ReportForm,ReportStatus> status = root.join("reportStatuses");
	                //sysout
	                if (searchCriteria.getCatagryId() != null && searchCriteria.getCatagryId() !=0) {
	                    predicates.add(cb.equal(root.get("repTypeId"), searchCriteria.getCatagryId()));
	                }
	                if (!StringUtils.isEmpty(searchCriteria.getTittle())) {
	                	Expression<String> path =root.get("reportTitle");
	                    predicates.add(cb.like( cb.lower(path), "%" + searchCriteria.getTittle().toLowerCase() + "%"));
	                }
	                if (searchCriteria.getStatusId()!=null) {
	                	
	                    predicates.add(cb.equal( status.<Long> get("statusId"), searchCriteria.getStatusId()));
	                }
	                return cb.and(predicates.toArray(new Predicate[] {}));
	            }
	        };
	    
	}
}
