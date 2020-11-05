/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.dao;

import java.util.ArrayList;
import java.util.List;
import kepyes.entities.Player;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author a.toutsios
 */
public class PlayerDao extends JPAUtil<Player> {
    
    private static final String FINDALL = "select p from Player p";
    private static final String FINDFROMNAME = "SELECT p FROM Player p WHERE p.name = :name";
    
    
    public List<Player> findAllPlayers(){
        List<Player> players = null;
        EntityManager em = getEntityManager();
        try {
           players = em.createQuery(FINDALL, Player.class).getResultList();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        em.close();
        
        return players;
    }
    
    public Player findPlayerFromName(String name){
        EntityManager em = getEntityManager();
        TypedQuery<Player> query = em.createQuery(FINDFROMNAME, Player.class);
        query.setParameter("name", name);
        List<Player> list = query.getResultList();
        return list.get(0);
    }
    
    public Player find(int id){
        return super.find(Player.class, id);
    }
    
    public Player getPlayerWithoutClosingEm(int id){
        EntityManager em = getEntityManager();
        Player t = em.find(Player.class, id);
        return t;
    }
    
    public Player save(Player c){
        return super.save(c);
    }
    
    public Player update(Player c){
        return super.update(c);
    }
    
    public String getState(Player p){
        boolean isManaged = getEntityManager().contains(p);
        return (isManaged?"Managed":"Detached");//ternary operation
    }
    
    
    
    public void updatePlayer(Player p){
       EntityManager em = getEntityManager();
       em.getTransaction().begin();
       Player old = em.find(Player.class, p.getId());
       old.setTotalRank(p.getTotalRank());
       old.setTotalTrainings(p.getTotalTrainings()+1);
//       old.setTrainings(p.getTrainings());
       
       old = em.merge(old);
       em.getTransaction().commit();
       em.close();
    }


    public void delete (int id){
        super.delete(Player.class,id);
    }
    
}//class
