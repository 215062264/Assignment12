package ac.za.service.serviceInterface.people;

import ac.za.domain.people.Student;
import ac.za.service.IService;

import java.util.Set;

public interface StudentService extends IService<Student, String> {
    Set<Student> getAll();
}
