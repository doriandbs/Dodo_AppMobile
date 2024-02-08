package fr.ensitech.dodoapp.entities;

public class User {


    private String uuid;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

    public User(String uuid,String nom, String prenom, String email, String motDePasse) {
        this.uuid = uuid;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getUUID() {
        return uuid;
    }

    public void setUUID(String UUID) {
        this.uuid = UUID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
