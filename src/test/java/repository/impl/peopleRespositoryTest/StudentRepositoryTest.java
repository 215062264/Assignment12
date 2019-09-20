package repository.impl.peopleRespositoryTest;

import ac.za.domain.people.Student;
import ac.za.factory.peopleFactory.StudentFactory;
import ac.za.repository.repoInterface.people.StudentRepository;
import ac.za.repository.Impl.peopleRepositoryImpl.StudentRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentRepositoryTest {

    private StudentRepository repository;
    private Student student;

    private Student getSavedCourse() {
        Set<Student> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StudentRepositoryImpl.getRepository();
        this.student = StudentFactory.getStudent("1","Trevor","Belmont",26);
    }

    @Test
    public void a_create() {
        Student created = this.repository.create(this.student);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.student);
    }

    @Test
    public void b_read() {
        Student savedCourse = getSavedCourse();
        System.out.println("In read, studentId = "+ savedCourse.getStudentId());
        Student read = this.repository.read(savedCourse.getStudentId());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Student savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getStudentId());
        getAll();
    }

    @Test
    public void c_update() {
        String newFirstName = "John";
        String newLastName = "Doe";
        int newAge = 27;
        Student updated = new Student.Builder().copy(getSavedCourse()).studentFirstName(newFirstName)
                .studentLastName(newLastName)
                .age(newAge)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newFirstName, updated.getStudentFirstName());
    }

    @Test
    public void getAll() {
        Set<Student> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

}
