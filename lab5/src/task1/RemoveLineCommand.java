package task1;

public class RemoveLineCommand extends Command {

    public RemoveLineCommand(Editor editor, int line)
    {
        this.editor = editor;
        this.line = line;
    }

    @Override
    public boolean execute() {
        editor.textField.remove(line);
        return true;
    }

    @Override
    public String toString()
    {
        return "rm\n" + line + "\n";
    }
}