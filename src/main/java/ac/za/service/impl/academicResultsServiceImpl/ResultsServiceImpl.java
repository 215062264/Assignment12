package ac.za.service.impl.academicResultsServiceImpl;

import ac.za.domain.academicResults.Results;
import ac.za.repository.repoInterface.academicResults.ResultRepository;
import ac.za.repository.Impl.academicResultsRepositoryImpl.ResultRepositoryImpl;
import ac.za.service.serviceInterface.academicResults.ResultsService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ResultsServiceImpl implements ResultsService {

    private static ResultsServiceImpl service = null;
    private ResultRepository repository;

    private ResultsServiceImpl(){
        this.repository = ResultRepositoryImpl.getRepository();
    }

    public static ResultsService getService(){
        if (service == null) service = new ResultsServiceImpl();
        return service;
    }


    @Override
    public Results create(Results educator) {
        return this.repository.create(educator);
    }

    @Override
    public Results update(Results educator) {
        return this.repository.update(educator);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Results read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Results> getAllP() {
        Set<Results> results = getAll();

        return null;
    }

    @Override
    public Set<Results> getAll() {
        return this.repository.getAll();
    }
}
