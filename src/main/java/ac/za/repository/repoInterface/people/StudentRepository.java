package ac.za.repository.repoInterface.people;

import ac.za.domain.people.Student;
import ac.za.repository.IRepository;

import java.util.Set;

public interface StudentRepository extends IRepository<Student, String> {
    Set<Student> getAll();

}
