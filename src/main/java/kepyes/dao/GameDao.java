/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.dao;

import kepyes.entities.Game;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
/**
 *
 * @author a.toutsios
 */
public class GameDao extends JPAUtil<Game> {
    
    private static final String FINDALL = "SELECT g FROM Game g";
    
    public List<Game> findAll(){
            EntityManager em = getEntityManager();
            TypedQuery query = em.createQuery(FINDALL, Game.class);
            List<Game> games = query.getResultList();
            return games;
        }
    
        public Game find(int id){
            return super.find(Game.class, id);
        }
        
        public Game getGameWithoutClosingEm(int id){
            EntityManager em = getEntityManager();
            Game t = em.find(Game.class, id);
            return t;
        }
        
        public Game save(Game c){
            return super.save(c);
        }
        
        public Game update(Game c){
            return super.update(c);
        }
        
        public void delete (int id){
            super.delete(Game.class,id);
        }
    
    
}//class
