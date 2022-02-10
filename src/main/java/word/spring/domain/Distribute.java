package word.spring.domain;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Distribute { //배포

    @Id @GeneratedValue
    @Column(name = "distribute_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    @Column(name = "distribute_time")
    private LocalDateTime time;

    public void setTest(Test test) {
        this.test = test;
        test.getDistributeList().add(this);
        test.setTeststatus((TestStatus.YET));
    }

    public void setStudent(Student student) {
        this.student = student;
        student.getDistributeList().add(this);
    }
}