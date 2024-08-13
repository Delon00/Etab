import java.util.List;

public interface ICRUDProfesseur {

    Prof ajouter(Prof professeur);

    Prof modifier(Prof professeur);

    void supprimer(int identifiant);

    List<Prof> obtenirProfesseur();

    Prof Obtenir(int identifiant);
}

