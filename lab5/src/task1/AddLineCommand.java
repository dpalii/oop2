package task1;

public class AddLineCommand extends Command
{
    public AddLineCommand(Editor editor, int line, String text)
    {
        this.editor = editor;
        this.line = line;
        this.backup = text;
    }

    @Override
    public boolean execute() {
        editor.textField.add(line, backup);
        return true;
    }
    @Override
    public String toString()
    {
        return "add\n" + line + "\n" + backup + "\n";
    }
}
