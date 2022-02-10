package word.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Student {
    @Id @GeneratedValue
    @Column(name = "student_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Distribute> distributeList = new ArrayList<>();  //배포된 시험들

    public void setGroup(Group group){
        this.group=group;
        group.getList().add(this);
    }

}
