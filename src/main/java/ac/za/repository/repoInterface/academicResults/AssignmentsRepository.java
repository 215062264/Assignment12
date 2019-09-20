package ac.za.repository.repoInterface.academicResults;

import ac.za.domain.academicResults.Assignments;
import ac.za.repository.IRepository;

import java.util.Set;

public interface AssignmentsRepository extends IRepository<Assignments, String> {
    Set<Assignments> getAll();

}