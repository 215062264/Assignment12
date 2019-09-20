package service.impl.academicResultsServiceTest;

import ac.za.domain.academicResults.Exam;
import ac.za.factory.academicsResultsFactory.ExamFactory;
import ac.za.service.impl.academicResultsServiceImpl.ExamServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExamServiceImplTest {

    private ExamServiceImpl service;
    private Exam exam;

    private Exam getSaved(){
        Set<Exam> savedExam = this.service.getAll();
        return savedExam.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (ExamServiceImpl) ExamServiceImpl.getService();
        this.exam = ExamFactory.getExam("123456","215062264",100.0);
    }

    @Test
    public void a_create() {
        Exam created = this.service.create(this.exam);
        System.out.println("In read, created=" + created);
        Assert.assertEquals(created, this.exam);
    }

    @Test
    public void b_read() {
        Exam saved = getSaved();
        System.out.println("In read, StudentNum = "+ saved.getStudentNum());
        Exam read = this.service.read(saved.getStudentNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String newExamNum = "7777";
        String newStudentNum = "215062264";
        double newMark = 100.0;
        Exam updated = new Exam.Builder().copy(getSaved()).examNum(newExamNum)
                .studentNum(newStudentNum)
                .mark(newMark)
                .build();
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newExamNum, updated.getExamNum());
    }

    @Test
    public void e_delete() {
        Exam saved = getSaved();
        this.service.delete(saved.getStudentNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Exam> exams = this.service.getAll();
        System.out.println("In getall, all = " + exams);
    }
}
