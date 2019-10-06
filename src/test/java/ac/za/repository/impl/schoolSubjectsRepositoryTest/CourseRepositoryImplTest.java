package ac.za.repository.impl.schoolSubjectsRepositoryTest;

import ac.za.domain.schoolSubjects.Course;
import ac.za.factory.schoolSubjectsFactory.CourseFactory;
import ac.za.repository.repoInterface.schoolSubjects.CourseRepository;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.CourseRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseRepositoryImplTest {

    private CourseRepository repository;
    private Course course;

    private Course getSavedCourse() {
        Set<Course> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CourseRepositoryImpl.getRepository();
        this.course = CourseFactory.getCourse("Test Course","DIP ICT");
    }

    @Test
    public void a_create() {
        Course created = this.repository.create(this.course);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.course);
    }

    @Test
    public void b_read() {
        Course savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getCourseId());
        Course read = this.repository.read(savedCourse.getCourseId());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Course savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getCourseId());
        getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Course course = new Course.Builder().copy(getSavedCourse()).courseName(newname).build();
        System.out.println("In update, about_to_updated = " + course);
        Course updated = this.repository.update(course);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getCourseName());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Course> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
