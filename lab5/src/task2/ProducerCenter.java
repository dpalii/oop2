package task2;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class ProducerCenter extends AbstractProducerCenter {
    private ArrayList<AbstractArtist> artistBase = new ArrayList<>();
    @Override
    public void register(AbstractArtist artist) {
        artistBase.add(artist);
    }

    @Override
    public void organizeConcert(String place, int popSingerAmount, int rapSingerAmount) {
        var performanceProgram = new ArrayList<AbstractArtist>();
        var popSingersAssigned = 0;
        var rapSingersAssigned = 0;
        for (AbstractArtist singer: artistBase)
        {
            if (popSingersAssigned >= popSingerAmount && rapSingersAssigned >= rapSingerAmount) break;
            if (popSingersAssigned <= popSingerAmount && singer.getGenre().equals("pop") && singer.isAvailable(place))
            {
                popSingersAssigned += 1;
                performanceProgram.add(singer);
            }
            else if (rapSingersAssigned <= rapSingerAmount && singer.getGenre().equals("rap") && singer.isAvailable(place))
            {
                rapSingersAssigned += 1;
                performanceProgram.add(singer);
            }
        }
        if (popSingersAssigned < popSingerAmount || rapSingersAssigned < rapSingerAmount)
        {
            System.out.println("cannot organize a concert");
            return;
        }
        System.out.println("A concert at a " + place);
        for (AbstractArtist singer: performanceProgram)
        {
            System.out.println(singer.name + " is performing");
            singer.perform();
        }
        System.out.println("-*-*-");
    }

}
