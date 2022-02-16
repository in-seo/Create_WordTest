package word.spring.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class WordForm {
    @NotEmpty
    private String kor;
    @NotEmpty
    private String eng;
    @NotEmpty
    private String wordBook;

    public WordForm(String kor, String eng, String wordBook) {
        this.kor = kor;
        this.eng = eng;
        this.wordBook = wordBook;
    }
}
