package ac.za.service.serviceInterface.people;

import ac.za.domain.people.Tutorial;
import ac.za.service.IService;

import java.util.Set;

public interface TutorialService extends IService<Tutorial, String> {

    Set<Tutorial> getAll();
}
