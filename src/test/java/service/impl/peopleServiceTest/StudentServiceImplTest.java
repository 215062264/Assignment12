package service.impl.peopleServiceTest;

import ac.za.domain.people.Student;
import ac.za.factory.peopleFactory.StudentFactory;
import ac.za.service.impl.peopleServiceImpl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceImplTest {

    private StudentServiceImpl service;
    private Student student;

    private Student getSaved(){
        Set<Student> savedStudents = this.service.getAll();
        return savedStudents.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (StudentServiceImpl) StudentServiceImpl.getService();
        this.student = StudentFactory.getStudent("1","Kyle","Josias",25);
    }

    @Test
    public void a_create() {
        Student created = this.service.create(this.student);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.student);
    }

    @Test
    public void c_update() {
        String newCourseName = "John";
        String newlname = "Doe";
        int newage = 26;
        Student updated = new Student.Builder().copy(getSaved()).studentFirstName(newCourseName)
                .studentLastName(newlname)
                .age(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newCourseName, updated.getStudentFirstName());
    }

    @Test
    public void e_delete() {
        Student saved = getSaved();
        this.service.delete(saved.getStudentId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Student saved = getSaved();
        Student read = this.service.read(saved.getStudentId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Student> students = this.service.getAll();
        System.out.println("In getall, all = " + students);
    }
}
