package ac.za.service.serviceInterface.schoolSubjects;


import ac.za.domain.schoolSubjects.Course;
import ac.za.service.IService;

import java.util.Set;

public interface CourseService extends IService<Course, String> {

    Set<Course> getAllAppDevCourses();
    Set<Course> getAll();
}
