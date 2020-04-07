package task2;

public class PopSinger extends AbstractArtist
{
    public PopSinger(String name)
    {
        super(name);
        this.genre = "pop";
    }
    @Override
    public void perform() {
        System.out.println("*performs a casual pop song (uncool)*");
    }
}
