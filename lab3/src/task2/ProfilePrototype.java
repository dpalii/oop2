package task2;

public abstract class ProfilePrototype implements Cloneable
{
    private String password;
    private String login;


    public void setPassword(String value)
    {
        this.password = value;
    }
    public void setLogin(String value)
    {
        this.login = value;
    }
    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return clone;
    }
    public void showProfile()
    {
        System.out.println("login: " + login);
    }
}
