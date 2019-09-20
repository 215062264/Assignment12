package ac.za.repository.repoInterface.people;


import ac.za.domain.people.Tutorial;
import ac.za.repository.IRepository;

import java.util.Set;

public interface TutorialRepository extends IRepository<Tutorial, String> {
    Set<Tutorial> getAll();

}