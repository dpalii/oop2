package task1;

public class ReminderFactory {
    private static ReminderFactory instance = null;
    private ReminderFactory() {}
    public static ReminderFactory getInstance()
    {
        if (instance == null) instance = new ReminderFactory();
        return instance;
    }
    public Reminder createReminder(String type)
    {
        Reminder reminder = null;
        if (type.equals("master")) reminder = new MasterReminder();
        else if (type.equals("bachelor")) reminder = new BachelorReminder();
        else reminder = new DefaultReminder();
        return reminder;
    }
}
