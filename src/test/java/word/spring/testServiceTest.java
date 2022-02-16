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
//    @Autowired
//    private DistributeRepository repo;
//    @Autowired
//    private StudentRepository studentRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void 단어() {
        //given
        Long wordBookId = wordservice.MakeWordBook("호롤로");
        wordservice.MakeWord("인서","inseo",wordBookId);
        wordservice.MakeWord("현우","hyunwoo",wordBookId);
        wordservice.MakeWord("민기","mingi",wordBookId);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void 테스트() {
        Long studentId = studentservice.join("랄랄루", "ERY");
        studentservice.join("호롤로","ERS2");
        studentservice.join("호롤f","ERS2");
        Long testId = testservice.test(1L, 3L, "1번테스트", 10L,50L, 20L);
        Long distributeId = testservice.distribute(Id,testId);
    }

}
