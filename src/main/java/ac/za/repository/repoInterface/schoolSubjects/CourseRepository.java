package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Course;
import ac.za.repository.IRepository;

import java.util.Set;

public interface CourseRepository extends IRepository<Course, String> {
    Set<Course> getAll();
}
