package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    private String classe;
    private String matricule;

    public Student(int id, String nom, String prenom, Date dateNaissance, String ville, String telephone, String matricule, String classe) {
        super(id, nom, prenom, dateNaissance, ville, telephone);
        this.matricule = matricule;
        this.classe = classe;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        Student.students = students;
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        Student.sc = sc;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    //-------------------------------------
public static void menuStudent() {
    while (true) {
        System.out.println("\n");
        System.out.println("******************************************************");
        System.out.println("                GESTION DES ELEVES                    ");
        System.out.println("******************************************************\n");
        System.out.println("MENU:\n");
        System.out.println("1: Ajouter un élève");
        System.out.println("2: Supprimer un élève");
        System.out.println("3: Modifier les informations de l'élève");
        System.out.println("4: Lister les élèves");
        System.out.println("5: Obtenir le dernier élève ajouté");
        System.out.println("6:Retour");
        System.out.println("0:Quitter");
        System.out.println("\n");
        System.out.print("Choisissez une option: ");
        int choix = sc.nextInt();
        sc.nextLine();

        switch (choix) {
            case 1:
                addStudent();
                break;
            case 2:
                delete();
                break;
            case 3:
                addStudent();
                break;
            case 4:
                listStudent();
                break;
            case 5:
                lastAdded();
            case 6:
                //Main.quit();
                return;
            case 0:
                return;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }
}
    public static void addStudent(){
        System.out.println("\n");
        int nextId = students.size() + 1;
        System.out.println("CREATION DU L'ELEVE AVEC L'ID : " + nextId);
        System.out.println("\n");
        System.out.print("Entrez le nom de l'élève: ");
        String nom = sc.nextLine();
        System.out.print("Entrez le prénom de l'élève: ");
        String prenom = sc.nextLine();
        System.out.print("Entrez la date de naissance de l'élève (DD-MM-YYYY): ");
        String dateNaissanceStr = sc.nextLine();
        Date dateNaissance = null;
        try {dateNaissance = new SimpleDateFormat("dd-MM-yyyy").parse(dateNaissanceStr);}
        catch (ParseException e) {
            System.out.println("Format de date invalide.");
            return;
        }
        System.out.print("Entrez la ville de l'élève: ");
        String ville = sc.nextLine();
        System.out.print("Entrez le téléphone de l'élève: ");
        String telephone = sc.nextLine();
        System.out.print("Entrez le matricule de l'élève:  ");
        String matricule = sc.nextLine();
        System.out.print("Entrez la classe de l'élève: ");
        String classe = sc.nextLine();

        Student nouveauEleve = new Student(

                nextId,
                nom,
                prenom,
                dateNaissance,
                ville,
                telephone,
                matricule,
                classe
        );

        students.add(nouveauEleve);
        System.out.println("Elève ajouté avec succès !");
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'identifiant de la personne à supprimer: ");
        int identifiant = sc.nextInt();
        sc.nextLine();

        boolean removed = students.removeIf(personne -> personne.getId() == identifiant);

        if (removed) {System.out.println("Personne supprimée avec succès.");}
        else {System.out.println("Aucune personne trouvée avec cet identifiant.");}
    }

    public static void listStudent() {
        if (students.isEmpty()) {
            System.out.println("Aucun Élève disponible.");
        } else {
            int idWidth = 5;
            int nameWidth = 20;
            int dateWidth = 15;
            int cityWidth = 15;
            int phoneWidth = 15;

            System.out.printf("%-" + idWidth + "s %-"+ nameWidth + "s %-"+ dateWidth + "s %-"+ cityWidth + "s %-"+ phoneWidth + "s%n",
                    "ID", "Nom", "Date de Naissance", "Ville", "Téléphone");
            System.out.println(new String(new char[idWidth + nameWidth + dateWidth + cityWidth + phoneWidth + 10]).replace('\0', '-'));

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            for (Student s : students) {
                System.out.printf("%-" + idWidth + "d %-"+ nameWidth + "s %-"+ dateWidth + "s %-"+ cityWidth + "s %-"+ phoneWidth + "s%n",
                        s.getId(), s.getNom(), dateFormat.format(s.getDateNaissance()), s.getVille(), s.getTelephone());
            }
        }
    }

    public static void lastAdded() {
        if (students.isEmpty()) {
            System.out.println("Aucun élève disponible.");
        } else {
            Student lastStudent = students.get(students.size() - 1);

            int idWidth = 5;
            int nameWidth = 20;
            int matriculeWidth = 10;
            int classeWidth = 10;
            int cityWidth = 15;
            int phoneWidth = 15;

            System.out.printf("%-" + idWidth + "s %-"+ nameWidth + "s %-"+ matriculeWidth + "s %-"+ classeWidth + "s %-"+ cityWidth + "s %-"+ phoneWidth + "s%n",
                    "ID", "Nom", "Matricule", "Classe", "Ville", "Téléphone");
            System.out.println(new String(new char[idWidth + nameWidth + matriculeWidth + classeWidth + cityWidth + phoneWidth + 6]).replace('\0', '-'));


            System.out.printf("%-" + idWidth + "d %-"+ nameWidth + "s %-"+ matriculeWidth + "s %-"+ classeWidth + "s %-"+ cityWidth + "s %-"+ phoneWidth + "s%n",
                    lastStudent.getId(), lastStudent.getNom(), lastStudent.getMatricule(), lastStudent.getClasse(), lastStudent.getVille(), lastStudent.getTelephone());
        }
    }

}
