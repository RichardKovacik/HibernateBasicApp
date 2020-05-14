package org.example.CRUD;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.plaf.synth.SynthTableUI;

public class UpdateObject {
    public static void main(String[] args) {
        //creating SessionFactory
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session=factory.getCurrentSession();

        try {
            long id=4L;
            // start transaction
            session.beginTransaction();
            //use sesion object to update java object to database
            Student studentObject=session.get(Student.class,id);
            //update student
            studentObject.setLastname("Fjodor");
            studentObject.setEmail("collins@gmail.com");


            //delete object from db
            //session.delete(studentObject);
            //commit transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
