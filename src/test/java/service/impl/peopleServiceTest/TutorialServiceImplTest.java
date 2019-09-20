package service.impl.peopleServiceTest;

import ac.za.domain.people.Tutorial;
import ac.za.factory.peopleFactory.TutorialFactory;
import ac.za.service.impl.peopleServiceImpl.TutorialServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TutorialServiceImplTest {

    private TutorialServiceImpl service;
    private Tutorial tutorial;

    private Tutorial getSaved(){
        Set<Tutorial> savedTut = this.service.getAll();
        return savedTut.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (TutorialServiceImpl) TutorialServiceImpl.getService();
        this.tutorial = TutorialFactory.getTutorial("7","Kyle","Josias");
    }

    @Test
    public void a_create() {
        Tutorial created = this.service.create(this.tutorial);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.tutorial);
    }

    @Test
    public void c_update() {
        String newCourseName = "John";
        String newlname = "Doe";
        Tutorial updated = new Tutorial.Builder().copy(getSaved()).tutorFirstName(newCourseName)
                .tutorLastName(newlname)
                .build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getTutorFirstName());
    }

    @Test
    public void e_delete() {
        Tutorial saved = getSaved();
        this.service.delete(saved.getTutorId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Tutorial saved = getSaved();
        Tutorial read = this.service.read(saved.getTutorId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Tutorial> tutorials = this.service.getAll();
        System.out.println("In getall, all = " + tutorials);
    }
}
