package word.spring.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
public class Word {
    protected Word() {
    }
    public Word(String korean, String english) {
        Korean = korean;
        English = english;
    }

    @Id @GeneratedValue
    @Column(name = "word_id")
    private Long id;

    private String Korean;
    private String English;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wordbook_id")
    private WordBook wordBook;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public void setWordBook(WordBook wordBook,String key) {
        this.wordBook = wordBook;
        wordBook.getMap().put(key,this);
    }
}
