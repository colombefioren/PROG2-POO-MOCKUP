package colombe;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private final int id;
    private final Instant dateDeCreation;
    private final List<Plat> platCommandee;


    public void addPlat(Plat plat){
        platCommandee.add(plat);
    }

    public Commande(int id, Instant dateDeCreation, List<Plat> platCommandee) {
        this.id = id;
        this.dateDeCreation = dateDeCreation;
        this.platCommandee = platCommandee;
    }

    public Commande(int id, Instant dateDeCreation) {
        this.id = id;
        this.dateDeCreation = dateDeCreation;
        this.platCommandee = new ArrayList<>();
    }

    public List<Plat> getPlatCommandee() {
        return platCommandee;
    }

    public int getId() {
        return id;
    }

    public Instant getDateDeCreation() {
        return dateDeCreation;
    }

    public double getTotalPrice(){
        return platCommandee.stream().mapToDouble(Plat::getLastPrix).sum();
    }
}
