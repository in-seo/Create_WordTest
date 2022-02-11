package word.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.Distribute;
import word.spring.domain.Student;
import word.spring.domain.Word;
import word.spring.repository.DistributeRepository;
import word.spring.repository.StudentRepository;
import word.spring.service.StudentService;
import word.spring.service.testService;
import word.spring.service.wordService;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class testServiceTest {
    @Autowired
    private testService testservice;
    @Autowired
    private wordService wordservice;
    @Autowired
    private StudentService studentservice;

    @Autowired
    private DistributeRepository repo;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void 단어() {
        //given
        Long wordBookId = wordservice.MakeWordBook("호롤로");
        wordservice.MakeWord(wordBookId,"인서","inseo");
        wordservice.MakeWord(wordBookId,"현우","hyunwoo");
        wordservice.MakeWord(wordBookId,"민기","mingi");
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void 테스트() {
        Long groupId = studentservice.makeGroup("ERY");
        Long testId = testservice.test(1L, 3L, "1번테스트", 10L,50L, 20L);
        Long studentId = studentservice.join("랄랄루", groupId);
        Long distributeId = testservice.distribute(testId, studentId);

        Distribute dis = repo.findById(distributeId);
        List<Word> wordList = dis.getTest().getWordList();
        for (Word word : wordList) {
            System.out.println(word.getEnglish()+" "+word.getKorean());
        }
        Student student = studentRepository.findById(studentId);
        List<Distribute> distributeList = student.getDistributeList();
        for (Distribute distribute : distributeList) {
            System.out.println("N번쨰!!!!!!!!!!!!!!!!!!!!!!!!");
            for (int i = 0; i <distribute.getTest().getWordList().size() ; i++) {
                System.out.println(distribute.getTest().getWordList().get(i).getEnglish());
            }

        }


    }

}
