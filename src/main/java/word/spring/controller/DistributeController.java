package word.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import word.spring.domain.Distribute;
import word.spring.service.testService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DistributeController {

    private final testService testService;

    @GetMapping("/distributions")
    public String distributions(Model model){
        List<Distribute> distributeList = testService.findDistributeList();
        model.addAttribute("distributions",distributeList);
        return "distribute/distributionList";
    }
}
