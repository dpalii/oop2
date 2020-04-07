package task2;

public abstract class AbstractProducerCenter {
    public abstract void register(AbstractArtist artist);
    public abstract void organizeConcert(String place, int popSingerAmount, int rapSingerAmount);
}
