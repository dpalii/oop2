package task1;

import java.io.Serializable;

public abstract class Command implements Serializable {
    protected Editor editor;
    protected String backup;
    protected int line;
    public abstract boolean execute();
//    public abstract String toString();
}
