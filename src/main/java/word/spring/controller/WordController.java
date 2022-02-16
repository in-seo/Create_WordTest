package word.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import word.spring.domain.Word;
import word.spring.dto.QuestionForm;
import word.spring.dto.WordForm;
import word.spring.service.wordService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WordController {

    private final wordService wordService;

    @GetMapping("/words/new")
    public String WordForm(){
        return "words/createWordForm";
    }

    @PostMapping("/words/new")
    public String createWord(@Valid WordForm wordForm, BindingResult result){
        if(result.hasErrors()){
            return "words/createWordForm";
        }
        Long wordBookId = wordService.isValidWordBook(wordForm.getWordBook()); //중복 검증 완료
        wordService.MakeWord(wordForm.getKor(),wordForm.getEng(),wordBookId);
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
    public String question(@Valid QuestionForm questionForm, BindingResult result){
        if(result.hasErrors()){
            return "words/questionForm";
        }


        return "redirect:/";
    }

}