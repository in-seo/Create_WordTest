package word.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;


@Entity
@Getter @Setter
public class WordBook {

    @Id @GeneratedValue
    @Column(name = "wordbook_id")
    private Long id;

    private String name;

    private Long key;

    @OneToMany(mappedBy = "wordBook")
    private Map<Long,Word> map = new LinkedHashMap<>(); //나중에 조금 수정  단어들 리스트
//    private List<Word> list = new ArrayList<>();


    public static WordBook createWordBook(String name) { //단어장에 단어 추가
        WordBook wordBook = new WordBook();
        wordBook.setName(name); wordBook.setKey(0L);
        return wordBook;
    }
}
