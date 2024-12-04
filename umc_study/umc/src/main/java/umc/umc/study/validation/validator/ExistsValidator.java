package umc.umc.study.validation.validator;

import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;


//public class ExistsValidator implements ConstraintValidator<Exists, Long> {
//    @Autowired
//    private EntityManager entityManager;
//
//    private Class<?> entityClass;
//
//    @Override
//    public void initialize(Exists constraintAnnotation) {
//        this.entityClass = constraintAnnotation.entity();
//    }
//
//    @Override
//    public boolean isValid(Long value, ConstraintValidatorContext context) {
//        if (value == null) {
//            return false;
//        }
//        String query = "Insert INTO Store " + entityClass.getSimpleName() + " (e.id = :id, e.name = : name)";
//        Long count = entityManager.createQuery(query, Long.class)
//                .setParameter("id", value)
//                .getSingleResult();
//        return count > 0;
//    }
//}
