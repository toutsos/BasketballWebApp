/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import kepyes.entities.PlayerGame;
import kepyes.entities.Player;
import kepyes.entities.Game;

/**
 *
 * @author atoutsios
 */

public class PlayerGameDao extends JPAUtil<PlayerGame>{
   
    public List<PlayerGame> findAllPlayersGames(){
        EntityManager em = getEntityManager();
        TypedQuery query = em.createQuery("SELECT pg FROM PlayerGame pg", PlayerGame.class);
        List<PlayerGame> players = query.getResultList();
        return players;
    }
    
    
    public PlayerGame find(int id){
        return super.find(PlayerGame.class, id);
    }
    
    public PlayerGame getPlayerWithoutClosingEm(int id){
        EntityManager em = getEntityManager();
        PlayerGame t = em.find(PlayerGame.class, id);
        return t;
    }
    
    public PlayerGame save(PlayerGame c){
        return super.save(c);
    }
    
    public PlayerGame update(PlayerGame c){
        
        return super.update(c);
    }

    public void delete (int id){
        super.delete(PlayerGame.class,id);
    }
    
    
    
    
}
