package ac.za.service.serviceInterface.people;

import ac.za.domain.people.Educator;
import ac.za.service.IService;

import java.util.Set;

public interface EducatorService extends IService<Educator,String> {
    Set<Educator> getAll();
}
