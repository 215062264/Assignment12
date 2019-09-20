package repository.impl.academicResultsRepositoryTest;

import ac.za.domain.academicResults.Exam;
import ac.za.factory.academicsResultsFactory.ExamFactory;
import ac.za.repository.repoInterface.academicResults.ExamRepository;
import ac.za.repository.Impl.academicResultsRepositoryImpl.ExamRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExamRepositoryImplTest {

    private ExamRepository repository;
    private Exam exam;

    private Exam getSavedCourse() {
        Set<Exam> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ExamRepositoryImpl.getRepository();
        this.exam = ExamFactory.getExam("777","215062264",100.0);

    }

    @Test
    public void a_create() {
        Exam created = this.repository.create(this.exam);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.exam);
    }

    @Test
    public void b_read() {
        Exam savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getStudentNum());
        Exam read = this.repository.read(savedCourse.getStudentNum());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Exam savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getStudentNum());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "77725";
        String newlname = "215062264";
        double newage = 100.0;
        Exam updated = new Exam.Builder().copy(getSavedCourse()).examNum(newCourseName)
                .studentNum(newlname)
                .mark(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getExamNum());
    }

    @Test
    public void getAll() {
        Set<Exam> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
