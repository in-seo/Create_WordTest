package word.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.Distribute;
import word.spring.domain.Word;
import word.spring.domain.WordBook;
import word.spring.repository.GroupRepository;
import word.spring.repository.WordBookRepository;
import word.spring.repository.WordRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@RequiredArgsConstructor
public class wordService {

    private final WordRepository wordRepository;
    private final WordBookRepository wordBookRepository;
    @PersistenceContext
    EntityManager em;
    @Transactional
    public Long MakeWord(Long wordBookId, String Kor, String Eng){
        Word word = Word.createWord(Kor,Eng,wordBookRepository.findById(wordBookId));
        return wordRepository.save(word);
    }

    @Transactional
    public Long MakeWordBook(String name){
        WordBook wordBook = WordBook.createWordBook(name);
        return wordBookRepository.save(wordBook);
    }

    public List<Word> findAll(){
        return em.createQuery("select w from Word w",Word.class)
                .getResultList();
    }




}
