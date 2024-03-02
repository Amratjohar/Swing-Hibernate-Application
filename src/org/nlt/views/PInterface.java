package org.nlt.views;

import java.util.LinkedHashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.model.Cities;
import org.nlt.model.Persons;
import org.nlt.model.States;

public interface PInterface
{
    public static Session ses = getDatabaseSession();
    public static LinkedHashMap<Integer, States> stateMap = new LinkedHashMap();
    public static LinkedHashMap<Integer, Cities> cityMap = new LinkedHashMap();
    public static LinkedHashMap<Integer, Persons> personMap = new LinkedHashMap();

    public static UserFrame userFrame = new UserFrame();
    public static LoginFrame loginFrame = new LoginFrame();
    public static PersonFrame personFrame = new PersonFrame();
    public static StateFrame stateFrame = new StateFrame();
    public static CityFrame cityFrame = new CityFrame();

    public static void setStatesMap()
    {
        stateMap.clear();
        ses.beginTransaction();
        Query query = ses.createQuery("from States where status=1");
        List<States> stateList = query.list();
        
        for (States state : stateList) 
        {
            stateMap.put(state.getId(), state);
        }
        ses.getTransaction().commit();
    }
  
    public static void setCityMap()
    {
        cityMap.clear();
        
        ses.beginTransaction();
        Query query = ses.createQuery("from Cities where status=1");
        List<Cities> cityList = query.list();
        
        for (Cities city : cityList) 
        {
            cityMap.put(city.getId(), city);
        }
        ses.getTransaction().commit();
    }
    
    public static void setPersonMap()
    {
        personMap.clear();
        
        ses.beginTransaction();
        Query query = ses.createQuery("from Persons where status =1");
        List<Persons> personList = query.list();
        
        for (Persons person : personList) 
        {
            personMap.put(person.getId(), person);
        }
        ses.getTransaction().commit();
    }

    public static Session getDatabaseSession()
    {
        System.out.println("Hye");
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        System.out.println("Bye");
        return s;
    }
}