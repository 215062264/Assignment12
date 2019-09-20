package service.impl.academicResultsServiceTest;

import ac.za.domain.academicResults.Assignments;
import ac.za.factory.academicsResultsFactory.AssignmentsFactory;
import ac.za.service.impl.academicResultsServiceImpl.AssignmentsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssignmentsServiceImplTest {

    private AssignmentsServiceImpl service;
    private Assignments assignments;

    private Assignments getSaved(){
        Set<Assignments> savedAssignments = this.service.getAll();
        return savedAssignments.iterator().next();

    }

    @Before
    public void setUp() throws Exception {
        this.service = (AssignmentsServiceImpl) AssignmentsServiceImpl.getService();
        this.assignments = AssignmentsFactory.getAssignments("1 June 2019","215062264",100.0);
    }

    @Test
    public void a_create() {
        Assignments created = this.service.create(this.assignments);
        System.out.println("In read, created=" + created);
        Assert.assertEquals(created, this.assignments);
    }

    @Test
    public void b_read() {
        Assignments savedAssignment = getSaved();
        System.out.println("In read, StudentNum = "+ savedAssignment.getAssId());
        Assignments read = this.service.read(savedAssignment.getAssId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(savedAssignment, read);
    }

    @Test
    public void c_update() {
        String newDate = "09 September 2019";
        String newNum = "215062264";
        double newMark = 100.0;
        Assignments updated = new Assignments.Builder().copy(getSaved()).dueDate(newDate)
                .studentNum(newNum)
                .mark(newMark)
                .build();
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newDate, updated.getDueDate());
    }

    @Test
    public void e_delete() {
        Assignments saved = getSaved();
        this.service.delete(saved.getAssId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Assignments> assignments = this.service.getAll();
        System.out.println("In getall, all = " + assignments);
    }
}
