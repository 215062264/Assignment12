package ac.za.factory.academicsResultsFactory;

import ac.za.domain.academicResults.Assignments;
import ac.za.util.Misc;

public class AssignmentsFactory {

    public static Assignments getAssignments(String duedate, String studentNum, double mark) {
        return new Assignments.Builder()
                .assId(Misc.generateId())
                .dueDate(duedate)
                .studentNum(studentNum)
                .mark(mark)
                .build();
    }

}
