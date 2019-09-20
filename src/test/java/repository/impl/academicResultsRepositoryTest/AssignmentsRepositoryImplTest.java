package repository.impl.academicResultsRepositoryTest;

import ac.za.domain.academicResults.Assignments;
import ac.za.factory.academicsResultsFactory.AssignmentsFactory;
import ac.za.repository.repoInterface.academicResults.AssignmentsRepository;
import ac.za.repository.Impl.academicResultsRepositoryImpl.AssignmentsRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssignmentsRepositoryImplTest {

    private AssignmentsRepository repository;
    private Assignments assignments;

    private Assignments getSavedCourse() {
        Set<Assignments> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AssignmentsRepositoryImpl.getRepository();
        this.assignments = AssignmentsFactory.getAssignments("1 June 2019","215062264",100.0);

    }

    @Test
    public void a_create() {
        Assignments created = this.repository.create(this.assignments);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.assignments);
    }

    @Test
    public void b_read() {
        Assignments savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getAssId());
        Assignments read = this.repository.read(savedCourse.getAssId());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Assignments savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getAssId());
        getAll();
    }

    @Test
    public void c_update() {
        String newCourseName = "2 June 2019";
        String newlname = "215062264";
        double newage = 100.0;
        Assignments updated = new Assignments.Builder().copy(getSavedCourse()).dueDate(newCourseName)
                .studentNum(newlname)
                .mark(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseName, updated.getDueDate());
    }

    @Test
    public void getAll() {
        Set<Assignments> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);

    }
}
