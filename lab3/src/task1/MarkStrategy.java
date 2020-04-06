package task1;

import java.util.ArrayList;

public class MarkStrategy implements ConversationStrategy {

    @Override
    public ArrayList<String> convert(ArrayList<StudentPoints> marksList) {
        var gradedStudents = new ArrayList<String>();
        for (StudentPoints student: marksList) {
            var entry = student.name + ": " + (int)(student.points * 12.0 / 100.0);
            gradedStudents.add(entry);
        }
        return gradedStudents;
    }
}
