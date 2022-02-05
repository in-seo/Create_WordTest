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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            student.setGroup(groupRepository.findById(((long) i)%10+1));
            studentRepository.save(student);
        }
    }
    @Test
    @Transactional
    @Rollback(false)
    public void 단어생성() {
        WordBook wordBook = new WordBook();
        wordBook.setName("수능2000");
        for (int i = 0; i < 100; i++) {
            Word word = new Word("kor"+i,"eng"+i);
            Long savedWord = wordRepository.save(word);
            Word words = wordRepository.findById(savedWord);
            wordBook.getMap().put(Integer.toString(i),words); //단어장에 셋팅완료
        }
        wordBookRepository.save(wordBook);  //단어장에 추가 완료
    }

    @Test
    @Transactional
    @Rollback(false)
    public void 테스트추가() {
        word.spring.domain.Test test = new word.spring.domain.Test();
        test.setName("시험1");
        test.setTeststatus(TestStatus.YET);
//        test.get;
    }


}
