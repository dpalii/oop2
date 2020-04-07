package task2;

public class RapSinger extends AbstractArtist {

    public RapSinger(String name)
    {
        super(name);
        this.genre = "rap";
    }
    @Override
    public void perform() {
        System.out.println("*performs a mind-blowing freestyle rap " +
                "and leaves everyone sitting with their mouths open*");
    }
}
