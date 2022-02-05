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

    private String name;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Long cutLine;

    @Column(name = "limit_num")
    private Long limit;

    private Long testTime;

    @Enumerated(EnumType.STRING)
    private TestStatus teststatus;

    @OneToMany(mappedBy = "test")
    private List<Distribute> list = new ArrayList<>(); //배포된 시험에 누가 포함된지 알 수 있음.

    @OneToMany(mappedBy = "test")
    private List<WordBook> wordBookList = new ArrayList<>();

}

