package ac.za.repository.repoInterface.academicResults;


import ac.za.domain.academicResults.Results;
import ac.za.repository.IRepository;

import java.util.Set;

public interface ResultRepository extends IRepository<Results, String> {
    Set<Results> getAll();

}