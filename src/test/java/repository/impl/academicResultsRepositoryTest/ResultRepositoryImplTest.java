package repository.impl.academicResultsRepositoryTest;

import ac.za.domain.academicResults.Results;
import ac.za.factory.academicsResultsFactory.ResultsFactory;
import ac.za.repository.repoInterface.academicResults.ResultRepository;
import ac.za.repository.Impl.academicResultsRepositoryImpl.ResultRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResultRepositoryImplTest {

    private ResultRepository repository;
    private Results results;

    private Results getSavedCourse() {
        Set<Results> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ResultRepositoryImpl.getRepository();
        this.results = ResultsFactory.getResults("215062264",100.0);
    }

    @Test
    public void a_create() {
        Results created = this.repository.create(this.results);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.results);
    }

    @Test
    public void b_read() {
        Results savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getStudentNum());
        Results read = this.repository.read(savedCourse.getStudentNum());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Results savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getStudentNum());
        getAll();
    }

    @Test
    public void c_update() {
        String newlname = "215062264";
        double newage = 100.0;
        Results updated = new Results.Builder().copy(getSavedCourse()).studentNum(newlname)
                .mark(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newlname, updated.getStudentNum());
    }

    @Test
    public void getAll() {
        Set<Results> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
