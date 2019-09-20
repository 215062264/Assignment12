package ac.za.service.serviceInterface.academicResults;

import ac.za.domain.academicResults.Results;
import ac.za.service.IService;

import java.util.Set;

public interface ResultsService extends IService<Results,String> {
    Set<Results> getAllP();
    Set<Results> getAll();
}
