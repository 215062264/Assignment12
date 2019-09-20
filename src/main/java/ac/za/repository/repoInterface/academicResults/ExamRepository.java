package ac.za.repository.repoInterface.academicResults;

import ac.za.domain.academicResults.Exam;
import ac.za.repository.IRepository;

import java.util.Set;

public interface ExamRepository extends IRepository<Exam, String> {
    Set<Exam> getAll();

}