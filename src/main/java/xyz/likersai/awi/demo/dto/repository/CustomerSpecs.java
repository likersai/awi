package xyz.likersai.awi.demo.dto.repository;

import org.springframework.data.jpa.domain.Specification;
import xyz.likersai.awi.demo.dto.Person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * JPA基于准则的Criterial
 *
 * @author MSI PC
 * @since 2019-05-21 00:30
 */
public class CustomerSpecs {

    public static Specification<Person> personFromHeNan(){
        return new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("address"),"河南");
            }
        };
    }
}