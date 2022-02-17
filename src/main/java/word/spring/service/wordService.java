package word.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.*;
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
    public Long MakeWordBook(String name){
        WordBook wordBook = WordBook.createWordBook(name);
        return wordBookRepository.save(wordBook);
    }
    @Transactional
    public Long MakeWord(String kor, String eng,Long wordBookId){
        Word word = Word.createWord(kor,eng,wordBookRepository.findById(wordBookId));
        return wordRepository.save(word);
    }

    public List<Word> findAll(){
        return em.createQuery("select w from Word w",Word.class)
                .getResultList();
    }

    public Long isValidWordBook(String wordBookName) {
        List<WordBook> wordBookList = wordBookRepository.findByName(wordBookName);
        if(wordBookList.isEmpty()){
            return MakeWordBook(wordBookName);
        }
        return wordBookList.get(0).getId();
    }

    public List<Word> WordBook_Word(Long id){
        return em.createQuery("select w from Word w left join WordBook b on b.id = w.wordBook.id order by w.id ")
                .getResultList();
    }
}
