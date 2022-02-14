package word.spring.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.Distribute;
import word.spring.domain.Group;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GroupRepository{
    @PersistenceContext
    EntityManager em;

    public Long save(Group group) {
        em.persist(group);
        return group.getId();
    }
    public Group findById(Long id) {
        return em.find(Group.class, id);
    }


    public List<Group> findByName(String name){
        return em.createQuery("select g from Group g where g.groupName=:name",Group.class)
                .setParameter("name",name)
                .getResultList();
    }

}
