package word.spring.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import word.spring.domain.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TestRepository{
    @PersistenceContext
    EntityManager em;


    public Long save(Test test) {
        em.persist(test);
        return test.getId();
    }
    public Test findById(Long id) {
        return em.find(Test.class, id);
    }

    public List<Test> findByName(String name){
        return em.createQuery("select t from Test t where t.name=:name",Test.class)
                .setParameter("name",name)
                .getResultList();
    }

}
