package ac.za.service.impl.academicResultsServiceImpl;

import ac.za.domain.academicResults.Assignments;
import ac.za.repository.repoInterface.academicResults.AssignmentsRepository;
import ac.za.repository.Impl.academicResultsRepositoryImpl.AssignmentsRepositoryImpl;
import ac.za.service.serviceInterface.academicResults.AssignmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("assignmentsServiceImpl")
public class AssignmentsServiceImpl implements AssignmentsService {
    @Autowired
    @Qualifier("assignmentsRepository")
    private static AssignmentsServiceImpl service = null;
    private AssignmentsRepository repository;

    private AssignmentsServiceImpl(){
        this.repository = AssignmentsRepositoryImpl.getRepository();
    }

    public static AssignmentsService getService(){
        if (service == null) service = new AssignmentsServiceImpl();
        return service;
    }


    @Override
    public Assignments create(Assignments educator) {
        return this.repository.create(educator);
    }

    @Override
    public Assignments update(Assignments educator) {
        return this.repository.update(educator);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Assignments read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Assignments> getAllA() {
        Set<Assignments> assignments = getAll();

        return null;
    }

    @Override
    public Set<Assignments> getAll() {
        return this.repository.getAll();
    }
}
