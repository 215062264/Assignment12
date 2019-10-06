package ac.za.repository.repoInterface.people;

import ac.za.domain.people.Lecture;
import ac.za.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository("lectureRepository")
public interface LectureRepository extends JpaRepository<Lecture, Integer> {

}