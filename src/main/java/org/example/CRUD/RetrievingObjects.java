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
            //display students
            for (Student tempStudent:students) {
                System.out.println("id:"+tempStudent.getId()+"  meno:"+tempStudent.getFirstname()+"  " +
                        "priezvisko: "+tempStudent.getLastname()+"  email: "+tempStudent.getEmail());

            }

            //commit transaction
            session.getTransaction().commit();

        }finally {
            factory.close();
        }

    }

}
