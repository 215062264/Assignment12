package ac.za.service.serviceInterface.people;

import ac.za.domain.people.Lecture;
import ac.za.service.IService;

import java.util.Set;

public interface LectureService extends IService<Lecture, String> {
    Set<Lecture> getAll();
}
