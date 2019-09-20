package ac.za.service.impl.peopleServiceImpl;

import ac.za.domain.people.Student;
import ac.za.repository.Impl.peopleRepositoryImpl.StudentRepositoryImpl;
import ac.za.repository.repoInterface.people.StudentRepository;
import ac.za.service.serviceInterface.people.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    @Qualifier("studentRepository")
    private static StudentServiceImpl service = null;
    private StudentRepository repository;

    private StudentServiceImpl(){
        this.repository = StudentRepositoryImpl.getRepository();
    }

    public static StudentService getService(){
        if (service == null) service = new StudentServiceImpl();
        return service;
    }

    @Override
    public Student create(Student student) {
        return repository.create(student);
    }

    @Override
    public Student update(Student student) {
        return repository.update(student);
    }

    @Override
    public void delete(String s) { repository.delete(s); }

    @Override
    public Student read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<Student> getAll() {
        return repository.getAll();
    }

}
