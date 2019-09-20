package ac.za.service.serviceInterface.academicResults;

import ac.za.domain.academicResults.Exam;
import ac.za.service.IService;

import java.util.Set;

public interface ExamService extends IService<Exam, String> {

    //Set<Exam> getAllA();
    Set<Exam> getAll();
}
