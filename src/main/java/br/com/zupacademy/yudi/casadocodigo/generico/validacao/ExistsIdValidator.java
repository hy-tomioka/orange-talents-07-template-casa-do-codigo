package br.com.zupacademy.yudi.casadocodigo.generico.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

    private Class<?> clazz;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(ExistsId params) {
        clazz = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = em.createQuery("select 1 from " + clazz.getName() + " c where c.id = :pid");
        query.setParameter("pid", value);
        List<?> resultList = query.getResultList();
        return !resultList.isEmpty();
    }
}
