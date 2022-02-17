package word.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.*;
import word.spring.repository.*;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class testService {

    private final TestRepository testRepository;
    private final WordBookRepository wordBookRepository;
    private final GroupRepository groupRepository;
    private final DistributeRepository distributeRepository;
    @Transactional
    public Long test(Long wordBookId,String testName, Long start_range,Long end_range, Long cutLine, Long testTime){
        WordBook wordbook = wordBookRepository.findById(wordBookId);
        List<Word> words = new ArrayList<>();
        for (Long i = start_range; i <= end_range; i++) {
            words.add(wordbook.getMap().get(i));
        }
        Test test = Test.createTest(testName,cutLine,testTime,words); //form 사용할예정
        return testRepository.save(test);
    }
    @Transactional
    public void distribute(Long testId, List<Student> studentList){
        Test test = testRepository.findById(testId);
        for (Student student : studentList) {
            Distribute distribute = Distribute.createDistribute(test,student);
            distributeRepository.save(distribute);
            System.out.println(student.getName());
        }
    }

    public List<Distribute> findDistributeList(){
        return distributeRepository.findAll();
    }

    public Group findGroup(String groupName){
        return groupRepository.findByName(groupName).get(0);
    }
}
