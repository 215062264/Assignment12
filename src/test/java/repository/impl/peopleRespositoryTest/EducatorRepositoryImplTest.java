package repository.impl.peopleRespositoryTest;

import ac.za.domain.people.Educator;
import ac.za.factory.peopleFactory.EducatorFactory;
import ac.za.repository.repoInterface.people.EducatorRepository;
import ac.za.repository.Impl.peopleRepositoryImpl.EducatorRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EducatorRepositoryImplTest {

    private EducatorRepository repository;
    private Educator educator;

    private Educator getSavedCourse() {
        Set<Educator> savedCourses = this.repository.getAll();
        return savedCourses.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EducatorRepositoryImpl.getRepository();
        this.educator = EducatorFactory.getEducator("Professor","Moriarty","2134",55);
    }

    @Test
    public void a_create() {
        Educator created = this.repository.create(this.educator);
        System.out.println("In create, created = " + created);
        getAll();
        Assert.assertSame(created, this.educator);
    }

    @Test
    public void b_read() {
        Educator savedCourse = getSavedCourse();
        System.out.println("In read, courseId = "+ savedCourse.getEducatorId());
        Educator read = this.repository.read(savedCourse.getEducatorId());
        System.out.println("In read, read = " + read);
        getAll();
        Assert.assertEquals(savedCourse, read);
    }

    @Test
    public void e_delete() {
        Educator savedCourse = getSavedCourse();
        this.repository.delete(savedCourse.getEducatorId());
        getAll();
    }

    @Test
    public void c_update() {
        String newfname = "John";
        String newlname = "Doe";
        int newage = 26;
        Educator course = new Educator.Builder().copy(getSavedCourse()).educatorFirstName(newfname)
                .educatorLastName(newlname)
                .age(newage)
                .build();
        System.out.println("In update, about_to_updated = " + course);
        Educator updated = this.repository.update(course);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newfname, updated.getEducatorFirstName());
        getAll();
    }

    @Test
    public void getAll() {
        Set<Educator> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }

}
