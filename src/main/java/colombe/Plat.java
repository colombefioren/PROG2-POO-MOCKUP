package colombe;

import java.time.Instant;
import java.util.HashMap;

public class Plat {

    private final int id;
    private final String nom;
    private final HashMap<Instant,ChangePriceForm> historiquePrix = new HashMap<>();


    public Plat(int id, String nom,double prix) {
        this.id = id;
        this.nom = nom;
        historiquePrix.put(Instant.now(),new ChangePriceForm("Not defined",prix));
    }


    public double getLastPrix(){
        return historiquePrix.get(historiquePrix.keySet().stream().max(Instant::compareTo).get()).getPrice();
    }

    public HashMap<Instant,ChangePriceForm> getHistoriquePrix() {
        return historiquePrix;
    }

    public void changePrix(Instant date, Double prix,String reason) {
        ChangePriceForm changePriceForm = new ChangePriceForm(reason, prix);
        historiquePrix.put(date, changePriceForm);
    }

    public void changePrix(Double prix,String reason) {
        ChangePriceForm changePriceForm = new ChangePriceForm(reason, prix);
        historiquePrix.put(Instant.now(), changePriceForm);
    }

    public void changePrix(Double prix) {
        ChangePriceForm changePriceForm = new ChangePriceForm("", prix);
        historiquePrix.put(Instant.now(), changePriceForm);
    }

    public String getReason(Instant instant){
        return historiquePrix.get(instant).getReason();
    }

    public String showHistoriquePrix(){
        StringBuilder historique = new StringBuilder();
        for (Instant instant : historiquePrix.keySet()) {
            historique.append("Date: ").append(instant).append(" Price: ").append(historiquePrix.get(instant).getPrice()).append(" Reason: ").append(this.getReason(instant)).append("\n");
        }
        return historique.toString();
    }

}
