package word.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.Group;
import word.spring.domain.Student;
import word.spring.repository.GroupRepository;
import word.spring.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService { //반설정하는거 만들어야할듯

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    public Long makeGroup(String groupName){
        Group group = new Group();
        group.setName(groupName);
        return groupRepository.save(group);
    }
    @Transactional
    public Long join(String studentName, Long groupId){  //로그인 구현 해보기
        Group group = groupRepository.findById(groupId);
        Student student = Student.createStudent(studentName,group);
        return studentRepository.save(student);
    }

    public List<Student> findStudents(){
        return studentRepository.findAll();
    }

}
