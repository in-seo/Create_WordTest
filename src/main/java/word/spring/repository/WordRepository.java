package word.spring.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.Word;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class WordRepository{
    @PersistenceContext
    EntityManager em;

    @Transactional  //들어가야되나?
    public Long save(Word word) {
        em.persist(word);
        return word.getId();
    }
    public Word findById(Long id) {
        return em.find(Word.class, id);
    }

    public List findByName(String name){ //List<Word>아닌가
        return em.createQuery("select w from Word w where w.Korean=:name")
                .setParameter("name",name)
                .getResultList();
    }

}
