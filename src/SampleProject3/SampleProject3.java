package SampleProject3;

//import java.util.Date;
import org.hibernate.SessionFactory;
//import org.hibernate.annotations.Parent;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.model.Cities;
import org.nlt.views.PInterface;
import org.nlt.views.PersonFrame;
//import org.nlt.model.Cities;
//import org.nlt.model.Persons;
//import org.nlt.model.States;
//import org.nlt.views.StateFrame;

public class SampleProject3 implements PInterface
{
    public static void main(String[] args) 
    {
        
        System.out.println("Before Login Frame");
         PInterface.setStatesMap();
        //System.out.println(stateMap);
         loginFrame.setVisible(true);
        //  cityFrame.setVisible(true);
         cityFrame.setStateCombo();
        System.out.println("After Login Frame");
        
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session ses = sf.openSession();
                                               //Records dalneke liye
//        Persons person=new Persons();
//        person.setName("Eddie");
//        person.setAge(20);
//        person.setPhone("4512250");
//        person.setStatus(1);
//        person.setCreated(new Date());
//        person.setModified(new Date());
//        person.setCity((Cities) ses.get(Cities.class, 2));

//        States state=new States();
//        state.setName("Punjab");
//        state.setStatus(1);
//          state.setCreated(new Date());
//        state.setModified(new Date());

      //  Cities city=new Cities();
//        city.setName("Ludhiana");
//        city.setStatus(1);
//        city.setCreated(new Date());
//        city.setModified(new Date());
//      city.setState((States)ses.get(States.class, 2));

//        ses.beginTransaction();
//        ses.save(person);
//        ses.getTransaction().commit();
//        System.out.println("Rs");
        
    }
}