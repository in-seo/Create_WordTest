package word.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import word.spring.domain.Group;
import word.spring.domain.Student;
import word.spring.domain.Word;
import word.spring.dto.QuestionForm;
import word.spring.dto.WordForm;
import word.spring.service.testService;
import word.spring.service.wordService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WordController {

    private final wordService wordService;
    private final testService testService;

    @GetMapping("/words/new")
    public String WordForm(){
        return "words/createWordForm";
    }

    @PostMapping("/words/new")
    public String createWord(@Valid WordForm form, BindingResult result){
        if(result.hasErrors()){
            return "words/createWordForm";
        }
        Long wordBookId = wordService.isValidWordBook(form.getWordBook()); //중복 검증 완료
        wordService.MakeWord(form.getKor(),form.getEng(),wordBookId);
        return "redirect:/";
    }

    @GetMapping("/wordlist")
    public String wordList(Model model){
        List<Word> wordList = wordService.findAll();
        model.addAttribute("words",wordList);
        return "words/wordList";
    }

    @GetMapping("/words/question")
    public String questionForm(Model model){
        model.addAttribute("QForm",new QuestionForm());
        return "words/questionForm";
    }

    @PostMapping("/words/question")
    public String question(@Valid QuestionForm form, BindingResult result){
        if(result.hasErrors()){
            return "words/questionForm";
        }
        System.out.println(form.toString());
        Long validWordBook = wordService.isValidWordBook(form.getWordBook()); //유효한 단어장인지
        Long testId = testService.test(validWordBook,form.getTestName(),form.getStart_range(),form.getEnd_range(),form.getCutLine(),form.getTestTime()); //테스트 생성(단어장,범위,컽,시험시간)
        Group group = testService.findGroup(form.getGroup());
        List<Student> studentList = group.getStudentList(); //그룹별로 배포하기
        testService.distribute(testId,studentList);
        return "redirect:/";
    }

//    @GetMapping("/wordBook")
//    public String showWordBook(Model model) {
//        wordService.
//        return "words/wordBook";
//    }

}
