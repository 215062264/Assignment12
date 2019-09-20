package ac.za.service.serviceInterface.academicResults;

import ac.za.domain.academicResults.Quiz;
import ac.za.service.IService;

import java.util.Set;

public interface QuizService extends IService<Quiz,String> {
    Set<Quiz> getAllP();
    Set<Quiz> getAll();
}
