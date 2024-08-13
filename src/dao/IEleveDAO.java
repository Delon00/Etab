package dao;

import models.Student;

import java.util.List;

public interface IEleveDAO {
    Student ajouter(Student eleve);
    Student modifier(Student eleve);
    void supprimer(int identifiant);
    List<Student> obtenirEleve();
    Student Obtenir(int identifiant);
}
