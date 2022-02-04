package word.spring.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import word.spring.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentRepository{
    @PersistenceContext
    EntityManager em;

    @Transactional  //들어가야되나?
    public Long save(Student student) {
        em.persist(student);
        return student.getId();
    }
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public List<Student> findByName(String name){
        return em.createQuery("select s from Student s where s.name=:name")
                .setParameter("name",name)
                .getResultList();
    }

}
