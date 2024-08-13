package models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe représentant une personne dans l'application ETAB.
 * Elle contient des informations personnelles telles que le nom,
 * le prénom, la date de naissance, la ville, et le numéro de téléphone.
 */
public class Person {
    /**
     * Le prochain identifiant unique à attribuer à une nouvelle personne.
     */
    private static int nextId = 1;

    /**
     * L'identifiant unique de la personne.
     */
    private int id;

    /**
     * Le nom de la personne.
     */
    private String nom;

    /**
     * Le prénom de la personne.
     */
    private String prenom;

    /**
     * La date de naissance de la personne.
     */
    private Date dateNaissance;

    /**
     * La ville de résidence de la personne.
     */
    private String ville;

    /**
     * Le numéro de téléphone de la personne.
     */
    private String telephone;

    /**
     * La liste statique contenant toutes les instances de la classe models.Person.
     */
    private static List<Person> personnes = new ArrayList<>();

    /**
     * Constructeur pour créer une nouvelle instance de la classe models.Person.
     *
     * @param id            L'identifiant unique de la personne.
     * @param nom           Le nom de la personne.
     * @param prenom        Le prénom de la personne.
     * @param dateNaissance La date de naissance de la personne.
     * @param ville         La ville de résidence de la personne.
     * @param telephone     Le numéro de téléphone de la personne.
     */
    public Person(int id, String nom, String prenom, Date dateNaissance, String ville, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.telephone = telephone;
    }

    /**
     * Retourne le prochain identifiant à attribuer.
     *
     * @return Le prochain identifiant unique.
     */
    public static int getNextId() {
        return nextId;
    }

    /**
     * Définit le prochain identifiant unique à attribuer.
     *
     * @param nextId Le prochain identifiant unique.
     */
    public static void setNextId(int nextId) {
        Person.nextId = nextId;
    }

    /**
     * Retourne l'identifiant unique de la personne.
     *
     * @return L'identifiant de la personne.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique de la personne.
     *
     * @param id L'identifiant de la personne.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne le nom de la personne.
     *
     * @return Le nom de la personne.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la personne.
     *
     * @param nom Le nom de la personne.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prénom de la personne.
     *
     * @return Le prénom de la personne.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de la personne.
     *
     * @param prenom Le prénom de la personne.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Retourne la date de naissance de la personne.
     *
     * @return La date de naissance de la personne.
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Définit la date de naissance de la personne.
     *
     * @param dateNaissance La date de naissance de la personne.
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Retourne la ville de résidence de la personne.
     *
     * @return La ville de résidence de la personne.
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la ville de résidence de la personne.
     *
     * @param ville La ville de résidence de la personne.
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * Retourne le numéro de téléphone de la personne.
     *
     * @return Le numéro de téléphone de la personne.
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Définit le numéro de téléphone de la personne.
     *
     * @param telephone Le numéro de téléphone de la personne.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Retourne la liste de toutes les personnes.
     *
     * @return La liste des personnes.
     */
    public static List<Person> getPersonnes() {
        return personnes;
    }

    /**
     * Définit la liste des personnes.
     *
     * @param personnes La nouvelle liste de personnes.
     */
    public static void setPersonnes(List<Person> personnes) {
        Person.personnes = personnes;
    }

    /**
     * Retourne une représentation en chaîne de caractères de l'objet models.Person.
     *
     * @return Une chaîne de caractères représentant l'objet models.Person.
     */
    @Override
    public String toString() {
        return "models.Person{" + "id=" + id + ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", ville='" + ville + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
