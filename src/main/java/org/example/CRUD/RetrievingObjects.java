package org.example.CRUD;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class RetrievingObjects {
    public static void main(String[] args) {
        //creating SessionFactory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session=factory.getCurrentSession();
        try {
            //start transaction
            session.beginTransaction();
            //getting students
            List<Student> students=session.createQuery("from models.Student ").list();
            //display all students
            System.out.println("dislaying all students from db table:");
            displayStudents(students);

            //query specific lastname
            System.out.println("dysplaying students with choosen lastname ");
             List<Student> studentsS=session.createQuery("from models.Student e where e.lastname='Kovacik'").list();
            displayStudents(studentsS);
            //commit transaction
            session.getTransaction().commit();

        }finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> students) {
        for (Student tempStudent:students) {
            System.out.println("id:"+tempStudent.getId()+"  meno:"+tempStudent.getFirstname()+"  " +
                    "priezvisko: "+tempStudent.getLastname()+"  email: "+tempStudent.getEmail());
        }
    }

}
