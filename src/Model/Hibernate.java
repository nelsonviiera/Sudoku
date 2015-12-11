/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author nelsonjr
 */
public class Hibernate {
    public void insertPlayer(Player p){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Sudoku");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        em.close();
        factory.close();
    }
    
    public static ArrayList<Player> listAll() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Sudoku");
        EntityManager em = factory.createEntityManager();

        ArrayList<Player> player = new ArrayList<>();

        em.getTransaction().begin();
        Query q = em.createQuery("FROM Player as p ORDER BY p.time ASC");
        player = (ArrayList<Player>) q.getResultList();
        em.getTransaction().commit();
        em.close();
        factory.close();
        return player;
    }
    
}
