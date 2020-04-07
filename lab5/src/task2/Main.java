package task2;

public class Main {

    public static void main(String[] args) {
        var vitas = new PopSinger("Vitas");
        vitas.addAvailablePlace("concert hall");
        vitas.addAvailablePlace("club");

        var eminem = new RapSinger("Eminem");
        eminem.addAvailablePlace("stadium");

        var serdiychka = new PopSinger("Verka Serdiuchka");
        serdiychka.addAvailablePlace("club");
        serdiychka.addAvailablePlace("concert hall");
        serdiychka.addAvailablePlace("stadium");

        var prodCenter = new ProducerCenter();
        prodCenter.register(vitas);
        prodCenter.register(eminem);
        prodCenter.register(serdiychka);

        prodCenter.organizeConcert("stadium", 1, 1);

        prodCenter.organizeConcert("club", 2, 1);
    }
}
