package service.impl.peopleServiceTest;

import ac.za.domain.people.Lecture;
import ac.za.factory.peopleFactory.LectureFactory;
import ac.za.service.impl.peopleServiceImpl.LectureServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LectureServiceImplTest {

    private LectureServiceImpl service;
    private Lecture lecture;

    private Lecture getSaved(){
        Set<Lecture> savedLectures = this.service.getAll();
        return savedLectures.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (LectureServiceImpl) LectureServiceImpl.getService();
        this.lecture = LectureFactory.getLecture("1","Kyle",2);
    }

    @Test
    public void a_create() {
        Lecture created = this.service.create(this.lecture);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lecture);
    }

    @Test
    public void c_update() {
        String newProfessor = "Tony Stark";
        int newHours = 4;
        Lecture updated = new Lecture.Builder().copy(getSaved()).professor(newProfessor)
                .hours(newHours)
                .build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newProfessor, updated.getProfessor());
    }

    @Test
    public void e_delete() {
        Lecture saved = getSaved();
        this.service.delete(saved.getLecturerId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Lecture saved = getSaved();
        Lecture read = this.service.read(saved.getLecturerId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Lecture> lectures = this.service.getAll();
        System.out.println("In getall, all = " + lectures);
    }
}
