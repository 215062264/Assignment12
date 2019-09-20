package service.impl.academicResultsServiceTest;

import ac.za.domain.academicResults.Quiz;
import ac.za.factory.academicsResultsFactory.QuizFactory;
import ac.za.repository.Impl.academicResultsRepositoryImpl.QuizRepositoryImpl;
import ac.za.service.impl.academicResultsServiceImpl.QuizServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuizServiceImplTest {

    private QuizServiceImpl service;
    private Quiz quiz;

    private Quiz getSaved(){
        Set<Quiz> savedQuiz = this.service.getAll();
        return savedQuiz.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (QuizServiceImpl)QuizServiceImpl.getService();
        this.quiz = QuizFactory.getQuiz("1 June 2019","215062264",100.0);
    }

    @Test
    public void a_create() {
        Quiz created = this.service.create(this.quiz);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.quiz);
    }

    @Test
    public void b_read() {
        Quiz saved = getSaved();
        Quiz read = this.service.read(saved.getStudentNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newDueDate = "09 September 2019";
        String newStudNum = "215062264";
        double newMark = 100.0;
        Quiz updated = new Quiz.Builder().copy(getSaved()).dueDate(newDueDate)
                .studentNum(newStudNum)
                .mark(newMark)
                .build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newDueDate, updated.getDueDate());
    }

    @Test
    public void e_delete() {
        Quiz saved = getSaved();
        this.service.delete(saved.getStudentNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Quiz> quizzes = this.service.getAll();
        System.out.println("In getall, all = " + quizzes);
    }
}
