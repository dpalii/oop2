package task1;

import java.util.ArrayList;
// Context
public class PointsList
{
    ConversationStrategy strategy;
    ArrayList<StudentPoints> marksList;
    public PointsList(ConversationStrategy strategy, ArrayList<StudentPoints> marksList) {
        this.strategy = strategy;
        this.marksList = marksList;
    }
    public ArrayList<String> convertMarksList() {
        return strategy.convert(marksList);
    }
}
