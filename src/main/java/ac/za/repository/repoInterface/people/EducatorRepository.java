package ac.za.repository.repoInterface.people;

import ac.za.domain.people.Educator;
import ac.za.repository.IRepository;

import java.util.Set;

public interface EducatorRepository extends IRepository<Educator, String> {
    Set<Educator> getAll();

}
