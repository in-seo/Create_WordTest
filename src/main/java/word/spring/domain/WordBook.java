package word.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class WordBook {

    @Id @GeneratedValue
    @Column(name = "wordbook_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "wordBook")
    private List<Word> list = new ArrayList<>();
}
