package word.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.*;
import word.spring.repository.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    WordRepository wordRepository;
    @Autowired
    WordBookRepository wordBookRepository;
    @Autowired
    TestRepository testRepository;
    @Autowired
    DistributeRepository distributeRepository;
    @PersistenceContext
    EntityManager em;


    @Test
    @Transactional
    @Rollback(false)
    public void 그룹생성() {
        for (int i = 0; i < 10; i++) {
            Group group = new Group();
            group.setName("그룹"+i);
            groupRepository.save(group);
        }
        for (int i = 0; i < 100; i++) {
            Student student = new Student();
            student.setName("학생:"+i);
            student.setGroup(groupRepository.findByName("그룹"+(i%10)).get(0));
            studentRepository.save(student);
        }
    }
    @Test
    @Transactional
    @Rollback(false)
    public void 단어생성() {
        WordBook wordBook = new WordBook();
        wordBook.setName("수능2000");
            word.spring.domain.Test test = new word.spring.domain.Test();
            test.setName("시험");test.setTeststatus(TestStatus.YET);
            test.setLimit(10L); test.setCutLine(50L); //시험 대충 세팅

        for (int i = 0; i < 100; i++) { //단어 대충 생성
            Word word = new Word("kor"+i,"eng"+i);
            word.setWordBook(wordBook,Integer.toString(i));
            wordRepository.save(word);
            test.getWordList().add(word);
        }
            Long save = testRepository.save(test);
        wordBookRepository.save(wordBook);  //단어장에 추가 완료
        for (int j = 0; j < test.getWordList().size(); j++) { //결과확인
            System.out.print(testRepository.findById(save).getWordList().get(j).getKorean());
            System.out.println(testRepository.findById(save).getWordList().get(j).getEnglish());
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    public void 학생_단어출제() {





    }


}
