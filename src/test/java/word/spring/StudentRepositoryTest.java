package word.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.Group;
import word.spring.domain.Student;
import word.spring.repository.GroupRepository;
import word.spring.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;


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
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void 멤버생성() {
//
//    }


}
