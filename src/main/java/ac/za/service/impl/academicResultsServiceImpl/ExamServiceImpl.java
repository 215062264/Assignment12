package ac.za.service.impl.academicResultsServiceImpl;

import ac.za.domain.academicResults.Exam;
import ac.za.repository.repoInterface.academicResults.ExamRepository;
import ac.za.repository.Impl.academicResultsRepositoryImpl.ExamRepositoryImpl;
import ac.za.service.serviceInterface.academicResults.ExamService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ExamServiceImpl implements ExamService {

    private static ExamServiceImpl service = null;
    private ExamRepository repository;

    private ExamServiceImpl(){
        this.repository = ExamRepositoryImpl.getRepository();
    }

    public static ExamService getService(){
        if (service == null) service = new ExamServiceImpl();
        return service;
    }


    @Override
    public Exam create(Exam educator) {
        return this.repository.create(educator);
    }

    @Override
    public Exam update(Exam educator) {
        return this.repository.update(educator);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Exam read(String s) {
        return this.repository.read(s);
    }

//    @Override
//    public Set<Exam> getAllA() {
//        Set<Exam> exams = getAll();
//
//        return null;
//    }

    @Override
    public Set<Exam> getAll() {
        return this.repository.getAll();
    }
}
