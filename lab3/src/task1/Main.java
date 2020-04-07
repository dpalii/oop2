package task1;

import java.util.ArrayList;

public class Main {
    private static final int N = 10;
    public static void main(String[] args) {
        var factory = ReminderFactory.getInstance();
        var masterReminders = new ArrayList<Reminder>();
        var bachelorReminders = new ArrayList<Reminder>();
        for (int i = 0; i < N; i++)
        {
            masterReminders.add(factory.createReminder("master"));
            bachelorReminders.add(factory.createReminder("bachelor"));
        }
        for (Reminder reminder: masterReminders)
        {
            System.out.println(reminder.printReminder());
            System.out.println("***");
        }
        for (Reminder reminder: bachelorReminders)
        {
            System.out.println(reminder.printReminder());
            System.out.println("***");
        }
        var reminder = factory.createReminder("student");
        System.out.println(reminder.printReminder());
    }
}
