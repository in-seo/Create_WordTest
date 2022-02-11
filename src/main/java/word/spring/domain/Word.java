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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    public void setWordBook(WordBook wordBook,Long key) {
        this.wordBook = wordBook;
        wordBook.getMap().put(key,this);
    }
    //한글,영어, 단어장셋팅
    public static Word createWord(String kor, String Eng, WordBook wordBook) { //단어장에 단어 추가
        Word word = new Word(kor,Eng);
        wordBook.setKey(wordBook.getKey()+1); //단어 번호 하나 올려주기
        word.setWordBook(wordBook,wordBook.getKey());
        return word;
    }
}
