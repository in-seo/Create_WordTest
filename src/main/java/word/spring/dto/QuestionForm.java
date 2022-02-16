package word.spring.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class QuestionForm {
    @NotEmpty
    private String wordBook;
    @NotEmpty
    private String group; //반 단위로 내기
    private String start_range; //단어 범위
    private String end_range;
    private String QuestionName;
    private String limit;
    private String cutLine;
    private String testTime;

}
