package services;

import models.Student;

import java.util.List;

public interface IEleveService {
    Student add(Student eleve);

    Student update(Student eleve);

    void delete(int identifiant);

    List<Student> obtenirEleve();

    Student Obtenir(int identifiant);
}
