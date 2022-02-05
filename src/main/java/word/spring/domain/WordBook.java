package word.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Entity
@Getter @Setter
public class WordBook {

    @Id @GeneratedValue
    @Column(name = "wordbook_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "wordBook")
    private Map<String,Word> map = new HashMap<>(); //나중에 조금 수정
//    private List<Word> list = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "wordlist")
    private WordList wordList;

}
