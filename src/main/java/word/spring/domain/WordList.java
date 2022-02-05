//package word.spring.domain;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter @Setter
//public class WordList { //출제
//    @Id
//    @GeneratedValue
//    @Column(name = "wordlist_id")
//    private Long id;
//
//    private String name;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "test_id")
//    private Test test;
//
//    @OneToMany(mappedBy = )
//    private List<WordBook> list = new ArrayList<>();
//
//
//
//}