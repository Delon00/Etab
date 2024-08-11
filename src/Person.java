import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private static int nextId = 1;
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String ville;
    private String telephone;

    private static List<Person> personnes = new ArrayList<>();

    public Person(int id, String nom, String prenom, Date dateNaissance, String ville, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.telephone = telephone;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Person.nextId = nextId;
    }

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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public static List<Person> getPersonnes() {
        return personnes;
    }

    public static void setPersonnes(List<Person> personnes) {
        Person.personnes = personnes;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", ville='" + ville + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
//public static int obtenirAge(Date dateNaissance) {}
}
