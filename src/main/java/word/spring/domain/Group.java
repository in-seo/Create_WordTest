package word.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "Class")
public class Group {
    @Id @GeneratedValue
    @Column(name = "group_id")
    private Long id;

    private String groupName;

    @OneToMany(mappedBy = "group")
    private List<Student> list = new ArrayList<>();

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
