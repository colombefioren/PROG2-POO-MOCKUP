package colombe;

import java.time.Instant;
import java.util.List;

public class CommandeEnLigne extends Commande{
    private final MoyenPayement moyenPayement;
    private final String adresseDeLivraison;


    public CommandeEnLigne(int id, Instant dateDeCreation, List<Plat> platCommandee, MoyenPayement moyenPayement, String adresseDeLivraison) {
        super(id, dateDeCreation, platCommandee);
        this.moyenPayement = moyenPayement;
        this.adresseDeLivraison = adresseDeLivraison;
    }

    public CommandeEnLigne(int id, Instant dateDeCreation, MoyenPayement moyenPayement, String adresseDeLivraison) {
        super(id, dateDeCreation);
        this.moyenPayement = moyenPayement;
        this.adresseDeLivraison = adresseDeLivraison;
    }

    public MoyenPayement getMoyenPayement() {
        return moyenPayement;
    }

    public String getAdresseDeLivraison() {
        return adresseDeLivraison;
    }
}
