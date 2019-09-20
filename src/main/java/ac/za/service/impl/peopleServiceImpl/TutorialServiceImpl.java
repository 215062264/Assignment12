package ac.za.service.impl.peopleServiceImpl;

import ac.za.domain.people.Tutorial;
import ac.za.repository.repoInterface.people.TutorialRepository;
import ac.za.repository.Impl.peopleRepositoryImpl.TutorialRepositoryImpl;
import ac.za.service.serviceInterface.people.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("tutorServiceImpl")
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    @Qualifier("tutorRepository")
    private static TutorialServiceImpl service = null;
    private TutorialRepository repository;

    private TutorialServiceImpl(){
        this.repository = TutorialRepositoryImpl.getRepository();
    }

    public static TutorialService getService(){
        if (service == null) service = new TutorialServiceImpl();
        return service;
    }


    @Override
    public Tutorial create(Tutorial tutorial) {
        return this.repository.create(tutorial);
    }

    @Override
    public Tutorial update(Tutorial tutorial) {
        return this.repository.update(tutorial);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Tutorial read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Tutorial> getAll() {
        return this.repository.getAll();
    }
}
