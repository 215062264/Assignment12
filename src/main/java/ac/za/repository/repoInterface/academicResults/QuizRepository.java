package ac.za.repository.repoInterface.academicResults;


import ac.za.domain.academicResults.Quiz;
import ac.za.repository.IRepository;

import java.util.Set;

public interface QuizRepository extends IRepository<Quiz, String> {
    Set<Quiz> getAll();

}