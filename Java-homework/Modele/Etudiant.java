package Modele;

public class Etudiant {
    private int id;
private String nom, prenom;
public int getId() {
return id;
}
public void setId(int id) {
    this.id = id;
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
    public Etudiant(int id, String nom, String prenom) {
    super();
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    }
    public Etudiant(int id) {
    super();
    this.id = id;
    }
    public Etudiant(String nom, String prenom, int ngroupe) {
    super();
    this.nom = nom;
    this.prenom = prenom;
    }
    public Etudiant() {
    super();
    }
    
    }
