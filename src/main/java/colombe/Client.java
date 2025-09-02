package colombe;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private final int id;
    private final String nom;
    private final String telephone;
    private final String email;
    private final List<Commande> commandes;

    public Client(int id, String nom, String telephone, String email, List<Commande> commandes) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.commandes = commandes;
    }

    public Client(int id, String nom, String telephone, String email) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.commandes = new ArrayList<>();
    }

    public List<Commande> getCommandes() {
        return commandes;
    }



    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public List<Commande> getCommandeBetweenTwoInstants(Instant instant1,Instant instant2){
        return commandes.stream().filter(c -> c.getDateDeCreation().isAfter(instant1) && c.getDateDeCreation().isBefore(instant2)).toList();
    }

    public List<Commande> getCommandeBetweenFirstInstant(Instant firstInstant){
        return commandes.stream().filter(c -> c.getDateDeCreation().isAfter(firstInstant)).toList();
    }
    public List<Commande> getCommandeBetweenLastInstant(Instant lastInstant){
        return commandes.stream().filter(c -> c.getDateDeCreation().isBefore(lastInstant)).toList();
    }

    public List<Commande> getCommandeBetweenTwoInstants(){
        return commandes;
    }



}
