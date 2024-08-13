package services;

import dao.IProfesseurDAO;
import models.Prof;

import java.util.List;

public interface IProfesseurService {
    Prof add(Prof professeur);
    Prof update(Prof professeur);
    void delete(int identifiant);
    List<Prof> getAll();
    Prof getOne(int identifiant);
}
