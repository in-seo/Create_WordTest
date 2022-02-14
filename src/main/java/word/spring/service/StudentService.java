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
    @Transactional
    public Group makeGroup(String groupName){
        Group group = new Group();
        group.setGroupName(groupName);
        System.out.println(group.getGroupName()+"!!!!!!!!!!!!");
        System.out.println(groupName+"!!!!!!!!!!!!");
        groupRepository.save(group);
        return group;
    }
    @Transactional
    public Long join(String studentName, String groupName){  //로그인 구현 해보기
        Group validGroup = isValidGroup(groupName);
        System.out.println("group = " + validGroup.getGroupName()+"!!!!!!!!!!!!!!!!!!");
        System.out.println("group = " + validGroup.getGroupName()+"!!!!!!!!!!!!!!!!!!");
        validateDuplicateStudent(studentName);
        Student student = Student.createStudent(studentName,validGroup);
        return studentRepository.save(student);
    }

    private Group isValidGroup(String groupName) {
        List<Group> groupList = groupRepository.findByName(groupName);
        if(groupList.isEmpty()){
            return makeGroup(groupName);
        }
        return groupList.get(0);
    }

    private void validateDuplicateStudent(String studentName) {
        List<Student> findMembers = studentRepository.findByName(studentName);
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

}
