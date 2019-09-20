package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.Course;
import ac.za.repository.repoInterface.schoolSubjects.CourseRepository;

import java.util.HashSet;
import java.util.Set;

public class CourseRepositoryImpl implements CourseRepository {

    private static CourseRepositoryImpl repository = null;
    private Set<Course> courses;

    private CourseRepositoryImpl(){
        this.courses = new HashSet<>();
    }


    private Course findCourse(String courseId) {
        return this.courses.stream()
                .filter(courses -> courses.getCourseId().trim().equals(courseId))
                .findAny()
                .orElse(null);
    }


    public static CourseRepositoryImpl getRepository(){
        if (repository == null) repository = new CourseRepositoryImpl();
        return repository;
    }

    public Course create(Course course){
        this.courses.add(course);
        return course;
    }

    public Course read(final String courseId){
        Course courses = findCourse(courseId);
        return courses;
    }

    public void delete(String courseId) {
        Course courses = findCourse(courseId);
        if (courses != null) this.courses.remove(courses);
    }

    public Course update(Course course){
        Course toDelete = findCourse(course.getCourseId());
        if(toDelete != null) {
            this.courses.remove(toDelete);
            return create(course);
        }
        return null;
    }


    public Set<Course> getAll(){
        return this.courses;
    }
}
