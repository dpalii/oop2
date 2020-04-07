package task1;

import java.util.ArrayList;

public class OffsetStrategy implements ConversationStrategy {
    private final int minMark = 60;

    @Override
    public ArrayList<String> convert(ArrayList<StudentPoints> marksList) {
        var gradedStudents = new ArrayList<String>();
        for (StudentPoints student: marksList) {
            var entry = student.name + ": ";
            if (student.points >= minMark) entry += "passed";
            else entry += "not passed";
            gradedStudents.add(entry);
        }
        return gradedStudents;
    }
}
