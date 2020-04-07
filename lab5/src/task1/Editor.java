package task1;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Editor
{
    public ArrayList<String> textField = new ArrayList<>();

    private static final String historyPath = "C:\\Users\\dmitr\\Desktop\\OOP\\OOP design patterns\\lab5\\data\\history.txt";
    private static final String textPath = "C:\\Users\\dmitr\\Desktop\\OOP\\OOP design patterns\\lab5\\data\\text.txt";

    private Stack<Command> history = new Stack<>();

    public void init() {
        deserialize();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("restore last version (y/n)");
        try {
            var ans = reader.readLine();
            if (ans.equals("y")) restore();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        var stopped = false;
        while(!stopped) {

            System.out.println((linesToString()));
            System.out.println("1. Add line\n" +
                    "2. Remove line\n" +
                    "3. Save\n" +
                    "4. Exit");
            try {
                var option = reader.readLine();
                switch (option) {
                    case "1":
                    {
                        System.out.println("enter line num");
                        var line = Integer.parseInt(reader.readLine()) - 1;
                        System.out.println("enter text");
                        var text = reader.readLine();
                        executeCommand(new AddLineCommand(this, line, text));
                        break;
                    }
                    case "2":
                    {
                        System.out.println("enter line num");
                        var line = Integer.parseInt(reader.readLine()) - 1;
                        executeCommand(new RemoveLineCommand(this, line));
                        break;
                    }
                    case "3":
                    {
                        save();
                        break;
                    }
                    case "4":
                    {
                        stopped = true;
                        break;
                    }
                    default:
                    {
                        System.out.println("no such option");
                        break;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        serialize();
    }
    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }
    private void save()
    {
        history.clear();
        var text = new StringBuilder();
        for (String line: textField)
        {
            text.append(line).append("\n");
        }

        try {
            FileWriter writer = new FileWriter(textPath);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(text.toString());
            buffer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void serialize()
    {
        try {
            FileWriter writer = new FileWriter(historyPath);
            BufferedWriter buffer = new BufferedWriter(writer);
            var text = new StringBuilder();
            while (!history.isEmpty())
            {
                text.append(history.pop().toString());
            }
            buffer.write(text.toString());
            buffer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void deserialize()
    {
        try {
            // read history
            File log = new File(historyPath);
            Scanner logReader = new Scanner(log);
            while (logReader.hasNextLine()) {
                var line = logReader.nextLine();
                if (line.startsWith("add"))
                {
                    var index = Integer.parseInt(logReader.nextLine());
                    var text = logReader.nextLine();
                    history.push(new AddLineCommand(this, index, text));
                }
                else if (line.startsWith("rm"))
                {
                    var index = Integer.parseInt(logReader.nextLine());
                    history.push(new RemoveLineCommand(this, index));
                }
                else logReader.nextLine();
            }
            logReader.close();

            // read text
            File text = new File(textPath);
            Scanner textReader = new Scanner(text);
            while (textReader.hasNextLine()) {
                textField.add(textReader.nextLine());
            }
            textReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private String linesToString()
    {
        var text = new StringBuilder();
        for (int i = 0; i < textField.size(); i++)
        {
            text.append(i + 1).append("| ").append(textField.get(i)).append("\n");
        }
        return text.toString();
    }
    private void restore()
    {
        while(!history.isEmpty())
        {
            history.pop().execute();
        }
    }
}