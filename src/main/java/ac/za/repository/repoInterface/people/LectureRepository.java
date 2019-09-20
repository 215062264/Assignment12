package ac.za.repository.repoInterface.people;

import ac.za.domain.people.Lecture;
import ac.za.repository.IRepository;

import java.util.Set;

public interface LectureRepository extends IRepository<Lecture, String> {
    Set<Lecture> getAll();

}