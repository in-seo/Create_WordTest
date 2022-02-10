package word.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import word.spring.domain.Student;
import word.spring.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Long join(Student student){  //로그인 구현 해보기
        return studentRepository.save(student);
    }

    public List<Student> findStudents(){
        return studentRepository.findAll();
    }

}
