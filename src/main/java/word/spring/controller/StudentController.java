package word.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import word.spring.domain.Student;
import word.spring.dto.StudentForm;
import word.spring.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/student/new")
    public String createForm(Model model){
        return "student/createStudentForm";
    }

    @PostMapping(value = "/student/create")
    public String createStudent(@Valid StudentForm form, BindingResult result){

        if(result.hasErrors()){
            return "student/createStudentForm";
        }
        System.out.println(form.getStudentName()+"++"+form.getGroupName());
        studentService.join(form.getStudentName(),form.getGroupName());

        return "redirect:/";
    }

    @GetMapping(value = "/studentList")
    public String studentLists(Model model){
        List<Student> studentList = studentService.findAll();
        model.addAttribute("students",studentList);
        return "student/studentList";
    }


}
