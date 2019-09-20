package service.impl.peopleServiceTest;

import ac.za.domain.people.Educator;
import ac.za.factory.peopleFactory.EducatorFactory;
import ac.za.repository.Impl.peopleRepositoryImpl.EducatorRepositoryImpl;
import ac.za.service.impl.peopleServiceImpl.EducatorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EducatorServiceImplTest {

    private EducatorServiceImpl service;
    private Educator educator;

    private Educator getSaved(){
        Set<Educator> savedEducators = this.service.getAll();
        return savedEducators.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.service = (EducatorServiceImpl) EducatorServiceImpl.getService();
        this.educator = EducatorFactory.getEducator("Kyle","Josias","2134",25);
    }

    @Test
    public void a_create() {
        Educator created = this.service.create(this.educator);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.educator);
    }

    @Test
    public void c_update() {
        String newFirstName = "John";
        String newlname = "Doe";
        int newage = 102;
        Educator updated = new Educator.Builder().copy(getSaved()).educatorFirstName(newFirstName)
                .educatorLastName(newlname)
                .age(newage)
                .build();
        System.out.println("In update, updated = " + updated);
        this.service.update(updated);
        Assert.assertSame(newFirstName, updated.getEducatorFirstName());
    }

    @Test
    public void e_delete() {
        Educator saved = getSaved();
        this.service.delete(saved.getEducatorId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Educator saved = getSaved();
        Educator read = this.service.read(saved.getEducatorId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Educator> students = this.service.getAll();
        System.out.println("In getall, all = " + students);
    }
}
