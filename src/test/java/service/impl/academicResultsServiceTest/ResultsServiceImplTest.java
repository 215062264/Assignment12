package service.impl.academicResultsServiceTest;

import ac.za.domain.academicResults.Results;
import ac.za.factory.academicsResultsFactory.ResultsFactory;
import ac.za.repository.Impl.academicResultsRepositoryImpl.ResultRepositoryImpl;
import ac.za.service.impl.academicResultsServiceImpl.ResultsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResultsServiceImplTest {

    private ResultsServiceImpl service;
    private Results results;

    private Results getSaved()
    {   Set<Results> savedResults = this.service.getAll();
        return savedResults.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (ResultsServiceImpl) ResultsServiceImpl.getService();
        this.results = ResultsFactory.getResults("215062264",100.0);
    }

    @Test
    public void a_create() {
        Results created = this.service.create(this.results);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.results);
    }

    @Test
    public void c_update() {
        String newStdNum = "215062264";
        double newMark = 100.0;
        Results updated = new Results.Builder().copy(getSaved()).studentNum(newStdNum)
                .mark(newMark)
                .build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newStdNum, updated.getStudentNum());
    }

    @Test
    public void e_delete() {
        Results saved = getSaved();
        this.service.delete(saved.getStudentNum());
        d_getAll();
    }

    @Test
    public void b_read() {
        Results saved = getSaved();
        Results read = this.service.read(saved.getStudentNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Results> results = this.service.getAll();
        System.out.println("In getall, all = " + results);
    }
}
