package ac.za.service.impl.peopleServiceImpl;

import ac.za.domain.people.Lecture;
import ac.za.repository.repoInterface.people.LectureRepository;
import ac.za.repository.Impl.peopleRepositoryImpl.LectureRepositoryImpl;
import ac.za.service.serviceInterface.people.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("lectureServiceImpl")
public class LectureServiceImpl implements LectureService {

    @Autowired
    @Qualifier("lectureRepository")
    private static LectureServiceImpl service = null;
    private LectureRepository repository;

    private LectureServiceImpl(){
        this.repository = LectureRepositoryImpl.getRepository();
    }

    public static LectureService getService(){
        if (service == null) service = new LectureServiceImpl();
        return service;
    }


    @Override
    public Lecture create(Lecture lecture) {
        return this.repository.create(lecture);
    }

    @Override
    public Lecture update(Lecture lecture) {
        return this.repository.update(lecture);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Lecture read(String s) {
        return this.repository.read(s);
    }


    @Override
    public Set<Lecture> getAll() {
        return this.repository.getAll();
    }
}
