package ac.za.service.impl.peopleServiceImpl;

import ac.za.domain.people.Educator;
import ac.za.repository.repoInterface.people.EducatorRepository;
import ac.za.repository.Impl.peopleRepositoryImpl.EducatorRepositoryImpl;
import ac.za.service.serviceInterface.people.EducatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("educatorServiceImpl")
public class EducatorServiceImpl implements EducatorService {
    @Autowired
    @Qualifier("educatorRepository")
    private static EducatorServiceImpl service = null;
    private EducatorRepository repository;

    private EducatorServiceImpl(){
        this.repository = EducatorRepositoryImpl.getRepository();
    }

    public static EducatorService getService(){
        if (service == null) service = new EducatorServiceImpl();
        return service;
    }


    @Override
    public Educator create(Educator educator) {
        return this.repository.create(educator);
    }

    @Override
    public Educator update(Educator educator) {
        return this.repository.update(educator);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Educator read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Educator> getAll() {
        return this.repository.getAll();
    }
}
