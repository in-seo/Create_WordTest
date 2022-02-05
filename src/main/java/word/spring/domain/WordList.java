package word.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class WordList { //출제
    @Id
    @GeneratedValue
    @Column(name = "exam_id")
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Test test;

    @OneToMany(mappedBy = "wordList")
    private List<WordBook> wordList;  //단어장에서 빼오기. 여러 단어장 선택가능. 어떤단어뽑는지는 service에서 수행.


}