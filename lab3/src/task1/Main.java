package task1;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    private static final double maxMark = 100.0;
    public static void main(String[] args) {
        var pointsList = new ArrayList<StudentPoints>();
        for (int i = 0; i < 10; i++) {
            var name = "student" + i;
            var mark = Math.random() * maxMark;
            var student = new StudentPoints(name, mark);
            pointsList.add(student);
            System.out.println(student.name + ' ' + new DecimalFormat("##.##").format(student.points));
        }

        var pointsToOffsetList = new PointsList(new OffsetStrategy(), pointsList);
        var offsetList = pointsToOffsetList.convertMarksList();
        System.out.println("Offsets");
        for (String entry: offsetList) {
            System.out.println(entry);
        }

        var pointsToMarksList = new PointsList(new MarkStrategy(), pointsList);
        var markList = pointsToMarksList.convertMarksList();
        System.out.println("Marks");
        for (String entry: markList) {
            System.out.println(entry);
        }
    }
}
