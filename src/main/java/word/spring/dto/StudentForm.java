package word.spring.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class StudentForm {
    @NotEmpty(message = "이름은 필수 입니다")
    private String studentName;
    @NotEmpty(message = "반은 필수 입니다")
    private String groupName;

    public StudentForm(String name, String groupName) {
        this.studentName = name;
        this.groupName = groupName;
    }

}
