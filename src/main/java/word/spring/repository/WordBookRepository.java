package word.spring.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.WordBook;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class WordBookRepository{
    @PersistenceContext
    EntityManager em;


    public Long save(WordBook wordBook) {
        em.persist(wordBook);
        return wordBook.getId();
    }
    public WordBook findById(Long id) {
        return em.find(WordBook.class, id);
    }

    public List<WordBook> findByName(String name){
        return em.createQuery("select b from WordBook b where b.name=:name",WordBook.class)
                .setParameter("name",name)
                .getResultList();
    }

}
