package task2;

import java.util.ArrayList;

public abstract class AbstractArtist {
    protected String genre;
    public String name;
    protected ArrayList<String> availablePlaces = new ArrayList<>();
    public AbstractArtist(String name)
    {
        this.name = name;
    }
    public String getGenre()
    {
        return genre;
    }
    public abstract void perform();
    public boolean isAvailable(String place)
    {
        return availablePlaces.contains(place);
    }
    public void addAvailablePlace(String place)
    {
        availablePlaces.add(place);
    }
}
