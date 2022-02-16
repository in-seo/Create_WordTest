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
//    @Column(name = "limit_num")
//    private Long limit; //재시험 횟수

    private Long testTime;

    @Enumerated(EnumType.STRING)
    private TestStatus teststatus;

    @OneToMany(mappedBy = "test",  cascade = CascadeType.ALL)
    private List<Distribute> distributeList = new ArrayList<>(); //배포된 시험에 누가 포함된지 알 수 있음.

    @OneToMany(mappedBy ="test")//wordbook 찾아오기  단어장까지만 생각!!  단어 꺼내오는건 논외
    private List<Word> WordList = new ArrayList<>();


    public static Test createTest(String name, Long cutLine, Long testTime, List<Word> words){
        Test test = new Test();
        test.setStartTime(LocalDateTime.now());
        test.setName(name); test.setCutLine(cutLine); test.setTestTime(testTime);
        for (Word word : words) { //wordbook에서 묶어서  list로 뺴오면 될 듯
            test.getWordList().add(word);
        }
        test.setTeststatus(TestStatus.YET);
        return test;
    }
}

