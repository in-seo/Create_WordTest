package word.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Test {
    @Id
    @GeneratedValue
    @Column(name = "test_id")
    private Long id;

    @Column(name = "test_name")
    private String name;

    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "cut_line")
    private Long cutLine;
    @Column(name = "li_mit")
    private Long limit;

    @Column(name = "test_time")
    private Long testTime;

    @OneToMany(mappedBy = "test")
    private List<Distribute> list = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Test_Status test_status;

    @OneToMany(mappedBy = "test")
    private List<Word> wordList = new ArrayList<>();

}

