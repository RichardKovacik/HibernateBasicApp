import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
        public static void main(String[] args) {
            //creating SessionFactory
            SessionFactory factory= new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
            //create session
            Session session=factory.getCurrentSession();

            try {
                //use ssesion object to save java object to database

                //create Student object
                Student student=new Student("Samo","Kovacik","samuso.123@gmail.com");
                // start transaction
                session.beginTransaction();
                //save student object
                session.save(student);
                //commit transaction
                session.getTransaction().commit();

            }finally {
                factory.close();
            }

        }
}
