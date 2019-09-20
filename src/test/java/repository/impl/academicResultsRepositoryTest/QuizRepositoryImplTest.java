package repository.impl.academicResultsRepositoryTest;

import ac.za.domain.academicResults.Quiz;
import ac.za.factory.academicsResultsFactory.QuizFactory;
import ac.za.repository.repoInterface.academicResults.QuizRepository;
import ac.za.repository.Impl.academicResultsRepositoryImpl.QuizRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuizRepositoryImplTest {

    private QuizRepository repository;
    private Quiz quiz;

    private Quiz getSavedCourse() {
        Set<Quiz> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = QuizRepositoryImpl.getRepository();
        this.quiz = QuizFactory.getQuiz("7 July 2019","215062264",100.0);
    }

    @Test
    public void a_create() {
        Quiz created = this.repository.create(this.quiz);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.quiz);
    }

    @Test
    public void b_read() {
        Quiz savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getStudentNum());
        Quiz read = this.repository.read(savedCourse.getStudentNum());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Quiz savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getStudentNum());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "1 July 2019";
        String newlname = "215062264";
        double newage = 100.0;
        Quiz updated = new Quiz.Builder().copy(getSavedCourse()).dueDate(newCourseName)
                .studentNum(newlname)
                .mark(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getDueDate());
    }

    @Test
    public void getAll() {
        Set<Quiz> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
