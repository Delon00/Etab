import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Prof extends Person implements IEducation,ICRUDProfesseur {
    static ArrayList<Prof> professeur = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    private Boolean vacant;
    private String matiereEnseigne;
    private String  prochainCours;
    private String sujetProchaineReunion;

    public Prof(int id, String nom, String prenom, Date dateNaissance, String ville, String telephone, Boolean vacant, String matiereEnseigne, String prochainCours, String sujetProchaineReunion) {
        super(id, nom, prenom, dateNaissance, ville, telephone);
        this.vacant = vacant;
        this.matiereEnseigne = matiereEnseigne;
        this.prochainCours = prochainCours;
        this.sujetProchaineReunion = sujetProchaineReunion;
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        Prof.sc = sc;
    }

    public Boolean getVacant() {
        return vacant;
    }

    public void setVacant(Boolean vacant) {
        this.vacant = vacant;
    }

    public String getMatiereEnseigne() {
        return matiereEnseigne;
    }

    public void setMatiereEnseigne(String matiereEnseigne) {
        this.matiereEnseigne = matiereEnseigne;
    }

    public String getProchainCours() {
        return prochainCours;
    }

    public void setProchainCours(String prochainCours) {
        this.prochainCours = prochainCours;
    }

    public String getSujetProchaineReunion() {
        return sujetProchaineReunion;
    }

    public void setSujetProchaineReunion(String sujetProchaineReunion) {
        this.sujetProchaineReunion = sujetProchaineReunion;
    }

    public static void menuProf() {
        while (true) {
            System.out.println("******************************************************");
            System.out.println("************* GESTION DES PROFESSEURS ****************");
            System.out.println("******************************************************");
            System.out.println("MENU:");
            System.out.println("1: Ajouter un professeur");
            System.out.println("2: Supprimer un professeur");
            System.out.println("3: Modifier les informations du professeur");
            System.out.println("4: Lister les professeurs");
            System.out.println("5: Obtenir le dernier professeur ajouté");
            System.out.println("6: Retour");
            System.out.println("0: Quitter");
            System.out.print("Choisissez une option: ");
            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    addProf();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    modifyProf();
                    break;
                case 4:
                    listProf();
                    break;
                case 5:
                    return;
                case 0:
                    Main.menu();
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public static void addProf(){
        System.out.println("\n");
        int nextId = professeur.size() + 1;
        System.out.println("CREATION DU PROFESSEUR AVEC L'ID : " + nextId);
        System.out.println("\n");
        System.out.print("Entrez le nom du professeur: ");
        String nom = sc.nextLine();
        System.out.print("Entrez le prénom du professeur: ");
        String prenom = sc.nextLine();
        System.out.print("Entrez la date de naissance du professeur (DD-MM-YYYY): ");
        String dateNaissanceStr = sc.nextLine();
        Date dateNaissance = null;
        try {dateNaissance = new SimpleDateFormat("dd-MM-yyyy").parse(dateNaissanceStr);}
        catch (ParseException e) {
            System.out.println("Format de date invalide.");
            return;
        }
        System.out.print("Entrez la ville du professeur: ");
        String ville = sc.nextLine();
        System.out.print("Entrez le téléphone du professeur: ");
        String telephone = sc.nextLine();
        System.out.print("Le professeur est-il vacant (true/false)? ");
        Boolean vacant = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Entrez la matière enseignée par le professeur: ");
        String matiereEnseigne = sc.nextLine();
        System.out.print("Entrez le prochain cours du professeur: ");
        String prochainCours = sc.nextLine();
        System.out.print("Entrez le sujet de la prochaine réunion du professeur: ");
        String sujetProchaineReunion = sc.nextLine();

        Prof nouveauProf = new Prof(

                professeur.size() + 1,
                nom,
                prenom,
                dateNaissance,
                ville,
                telephone,
                vacant,
                matiereEnseigne,
                prochainCours,
                sujetProchaineReunion
        );


        professeur.add(nouveauProf);
        System.out.println("Professeur ajouté avec succès !");
    }
    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'identifiant de la personne à supprimer: ");
        int identifiant = sc.nextInt();
        sc.nextLine();

        boolean removed = professeur.removeIf(personne -> personne.getId() == identifiant);

        if (removed) {System.out.println("Personne supprimée avec succès.");}
        else {System.out.println("Aucune personne trouvée avec cet identifiant.");}
    }
    public static void modifyProf() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez l'identifiant du professeur à modifier: ");
        int identifiant = sc.nextInt();
        sc.nextLine();

    }

    public static void listProf() {
        if (professeur.isEmpty()) {
            System.out.println("Aucun professeur disponible.");
        } else {
            int idWidth = 5;
            int nameWidth = 20;
            int subjectWidth = 15;
            int nextClassWidth = 20;
            int meetingSubjectWidth = 25;
            int vacantWidth = 10;
            int cityWidth = 15;
            int phoneWidth = 15;

            System.out.printf("%-" + idWidth + "s %-"+ nameWidth + "s %-"+ subjectWidth + "s %-"+ nextClassWidth + "s %-"+ meetingSubjectWidth + "s %-"+ vacantWidth + "s %-"+ cityWidth + "s %-"+ phoneWidth + "s%n",
                    "ID", "Nom", "Matière", "Prochain Cours", "Sujet Réunion", "Vacant", "Ville", "Téléphone");
            System.out.println(new String(new char[idWidth + nameWidth + subjectWidth + nextClassWidth + meetingSubjectWidth + vacantWidth + cityWidth + phoneWidth + 7]).replace('\0', '-'));

            for (Prof p : professeur) {
                System.out.printf("%-" + idWidth + "d %-"+ nameWidth + "s %-"+ subjectWidth + "s %-"+ nextClassWidth + "s %-"+ meetingSubjectWidth + "s %-"+ vacantWidth + "s %-"+ cityWidth + "s %-"+ phoneWidth + "s%n",
                        p.getId(), p.getNom(), p.getMatiereEnseigne(), p.getProchainCours(), p.getSujetProchaineReunion(), p.getVacant() ? "Oui" : "Non", p.getVille(), p.getTelephone());
            }
        }
    }


    @Override
    public String enseigner(String matiere) {
        return String.format("Enseigne la matière %s", matiere);
    }

    @Override
    public String preparerCours(String cours) {
        return String.format("Prépare le contenu d'un cours sur le sujet %s", prochainCours);
    }

    @Override
    public String assisterReunion(String sujet) {
        return String.format("Doit assister à une reunion sur %s", sujetProchaineReunion);
    }

    @Override
    public Prof ajouter(Prof professeur) {
        return null;
    }

    @Override
    public Prof modifier(Prof professeur) {
        return null;
    }

    @Override
    public void supprimer(int identifiant) {

    }

    @Override
    public List<Prof> obtenirProfesseur() {
        return List.of();
    }

    @Override
    public Prof Obtenir(int identifiant) {
        return null;
    }
}
