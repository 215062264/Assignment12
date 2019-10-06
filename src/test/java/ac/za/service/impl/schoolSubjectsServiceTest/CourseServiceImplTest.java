package ac.za.service.impl.schoolSubjectsServiceTest;

import ac.za.domain.schoolSubjects.Course;
import ac.za.factory.schoolSubjectsFactory.CourseFactory;
import ac.za.repository.Impl.schoolSubjectsRepositoryImpl.CourseRepositoryImpl;
import ac.za.service.impl.schoolSubjectsServiceImpl.CourseServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseServiceImplTest {

    private CourseServiceImpl service;
    private Course course;

    private Course getSaved(){
        Set<Course> savedCourses = this.service.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (CourseServiceImpl) CourseServiceImpl.getService();
        this.course = CourseFactory.getCourse("Application Development Practice 3","ADP3");
    }

    @Test
    public void a_create() {
        Course created = this.service.create(this.course);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.course);
    }

    @Test
    public void c_update() {
        String newCourseName = "Application Development Theory 3";
        Course updated = new Course.Builder().copy(getSaved()).courseName(newCourseName).build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getCourseName());
    }

    @Test
    public void e_delete() {
        Course saved = getSaved();
        this.service.delete(saved.getCourseId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Course saved = getSaved();
        Course read = this.service.read(saved.getCourseId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Course> courses = this.service.getAll();
        System.out.println("In getall, all = " + courses);
    }

}
