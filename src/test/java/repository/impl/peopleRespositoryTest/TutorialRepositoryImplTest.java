package repository.impl.peopleRespositoryTest;

import ac.za.domain.people.Tutorial;
import ac.za.factory.peopleFactory.TutorialFactory;
import ac.za.repository.repoInterface.people.TutorialRepository;
import ac.za.repository.Impl.peopleRepositoryImpl.TutorialRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorialRepositoryImplTest {

    private TutorialRepository repository;
    private Tutorial tutorial;

    private Tutorial getSavedCourse() {
        Set<Tutorial> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TutorialRepositoryImpl.getRepository();
        this.tutorial = TutorialFactory.getTutorial("7","Kyle","Josias");
    }

    @Test
    public void a_create() {
        Tutorial created = this.repository.create(this.tutorial);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.tutorial);
    }

    @Test
    public void b_read() {
        Tutorial savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getTutorId());
        Tutorial read = this.repository.read(savedCourse.getTutorId());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Tutorial savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getTutorId());
        getAll();
    }

    @Test
    public void c_update() {
        String newfname = "John";
        String newlname = "Doe";
        Tutorial course = new Tutorial.Builder().copy(getSavedCourse()).tutorFirstName(newfname)
                .tutorLastName(newlname)
                .build();
        System.out.println("In update, about_to_updated = " + course);
        Tutorial updated = this.repository.update(course);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newfname, updated.getTutorFirstName());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Tutorial> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

}
