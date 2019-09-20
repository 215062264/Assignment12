package ac.za.service.serviceInterface.academicResults;

import ac.za.domain.academicResults.Assignments;
import ac.za.service.IService;

import java.util.Set;

public interface AssignmentsService extends IService<Assignments, String> {
    Set<Assignments> getAllA();
    Set<Assignments> getAll();
}
