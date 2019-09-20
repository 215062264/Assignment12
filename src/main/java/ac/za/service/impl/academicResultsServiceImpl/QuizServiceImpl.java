package ac.za.service.impl.academicResultsServiceImpl;

import ac.za.domain.academicResults.Quiz;
import ac.za.repository.repoInterface.academicResults.QuizRepository;
import ac.za.repository.Impl.academicResultsRepositoryImpl.QuizRepositoryImpl;
import ac.za.service.serviceInterface.academicResults.QuizService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService {

    private static QuizServiceImpl service = null;
    private QuizRepository repository;

    private QuizServiceImpl(){
        this.repository = QuizRepositoryImpl.getRepository();
    }

    public static QuizService getService(){
        if (service == null) service = new QuizServiceImpl();
        return service;
    }


    @Override
    public Quiz create(Quiz educator) {
        return this.repository.create(educator);
    }

    @Override
    public Quiz update(Quiz educator) {
        return this.repository.update(educator);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Quiz read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Quiz> getAllP() {
        Set<Quiz> quizzes = getAll();

        return null;
    }

    @Override
    public Set<Quiz> getAll() {
        return this.repository.getAll();
    }
}
