package word.spring.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.Distribute;
import word.spring.domain.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DistributeRepository{
    @PersistenceContext
    EntityManager em;

    public Long save(Distribute distribute) {
        em.persist(distribute);
        return distribute.getId();
    }

    public List<Distribute> findAll(){
        return em.createQuery("select d from Distribute d",Distribute.class)
                .getResultList();
    }
    public Distribute findById(Long id) {
        return em.find(Distribute.class, id);
    }


}
