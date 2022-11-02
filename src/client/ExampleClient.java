package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Actor;
import entity.Movie;
import util.HibernateUtil;

public class ExampleClient {
    public static void main(String[] args) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction transaction = session.getTransaction();

        try {
            transaction.begin();
    
            // Movie m1 = new Movie("American Hustle");
            // Movie m2 = new Movie("The Prestige");
    
            // Actor a1 = new Actor("Christian Bale");
            // Actor a2 = new Actor("Hugh Jackman");
    
            // m1.getActors().add(a1);
    
            // m2.getActors().add(a1);
            // m2.getActors().add(a2);
            
            // session.persist(m1);
            // session.persist(m2);

            Movie movie = (Movie) session.get(Movie.class, 1L);
            Actor actor = (Actor) session.get(Actor.class, 2L);
            movie.getActors().add(actor);// updating inverse end
    
            transaction.commit();
        } catch (Exception e) {
            if(transaction!=null){transaction.rollback();}
            e.printStackTrace();
        
        } finally {
            if(session!=null){session.close();}
        }
        System.exit(0);
    }
 }




