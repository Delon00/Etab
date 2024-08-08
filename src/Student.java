import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Student {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in); // Ensure scanner is defined

    private String studentId;
    private String nom;
    private String prenom;
    private int age;
    private String genre;
    private ArrayList<Integer> notes;

    public Student(String nom, String prenom, int age, String genre, ArrayList<Integer> notes) {
        this.studentId = UUID.randomUUID().toString(); // Automatically generate studentId
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.genre = genre;
        this.notes = notes != null ? notes : new ArrayList<>(); // Initialize notes if null
    }

    public String getStudentId() {
        return studentId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<Integer> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Integer> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", genre='" + genre + '\'' +
                ", notes=" + notes +
                '}';
    }





//-------------------------------------
public static void menuStudent() {
    while (true) {
        System.out.println("1: Ajouter un élève");
        System.out.println("2: Modifier les informations de l'élève");
        System.out.println("3: Gérer les notes");
        System.out.println("4: Liste des élèves");
        System.out.println("5: Quitter");
        System.out.print("Choisissez une option: ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                addStudent();
                break;
            case 2:
                addStudent();
                break;
            case 3:
                addStudent();
                break;
            case 4:
                Student.listStudents();
                break;
            case 5:
                Main.quit();
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }
}
    public static void addStudent() {
        System.out.print("Entrez le nom de l'élève: ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom de l'élève: ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez l'âge de l'élève: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String genre;
        while (true) {
            System.out.print("Entrez le genre de l'élève (h=Homme/f=Femme): ");
            genre = scanner.nextLine();
            if (genre.equalsIgnoreCase("h") || genre.equalsIgnoreCase("f")) {
                break;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer 'h' ou 'f'.");
            }
        }

        Student student = new Student(nom, prenom, age, genre, new ArrayList<>()); // Initialize notes as an empty list
        students.add(student);

        System.out.println("Élève ajouté avec succès!");
    }

    public static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("Aucun élève trouvé.");
        } else {
            int idWidth = 36; // UUID length
            int nameWidth = 20;
            int surnameWidth = 20;
            int ageWidth = 3;
            int genreWidth = 6;

            System.out.printf("%-" + idWidth + "s %-"+ nameWidth + "s %-"+ surnameWidth + "s %-" + ageWidth + "s %-" + genreWidth + "s%n",
                    "ID", "Nom", "Prénom", "Âge", "Genre");
            System.out.println("-".repeat(idWidth + nameWidth + surnameWidth + ageWidth + genreWidth + 12));

            for (Student student : students) {
                System.out.printf("%-" + idWidth + "s %-"+ nameWidth + "s %-"+ surnameWidth + "s %-" + ageWidth + "d %-" + genreWidth + "s%n",
                        student.getStudentId(),
                        student.getNom(),
                        student.getPrenom(),
                        student.getAge(),
                        student.getGenre().toUpperCase());
            }
        }
    }

}
