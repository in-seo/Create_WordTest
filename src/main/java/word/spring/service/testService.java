package word.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.*;
import word.spring.repository.DistributeRepository;
import word.spring.repository.StudentRepository;
import word.spring.repository.TestRepository;
import word.spring.repository.WordBookRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class testService {

    private final TestRepository testRepository;
    private final WordBookRepository wordBookRepository;
    private final StudentRepository studentRepository;
    private final DistributeRepository distributeRepository;
    @Transactional
    public Long test(Long wordBookId,Long range, String testName, Long limit, Long cutLine, Long testTime){
        WordBook wordbook = wordBookRepository.findById(wordBookId);
        List<Word> words = new ArrayList<>();
        for (Long i = 1L; i <= range; i++) {
            words.add(wordbook.getMap().get(i));
        }
        Test test = Test.createTest(testName,limit,cutLine,testTime,words); //form 사용할예정
        return testRepository.save(test);
    }
    @Transactional
    public Long distribute(Long studentId,Long testId){
        Student student = studentRepository.findById(studentId);
        Test test = testRepository.findById(testId);
        Distribute distribute = Distribute.createDistribute(test,student);
        return distributeRepository.save(distribute);
    }
}
