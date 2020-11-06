/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.dao;

import kepyes.entities.Player;
import kepyes.entities.Stadium;
import kepyes.entities.Training;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
/**
 *
 * @author a.toutsios
 */
public class TrainingDao extends JPAUtil<Training>{
   
    private static final String SORTFROMTRAININGS = "SELECT * FROM player order by trainings_number DESC";
    
    public List<Training> findAll(){
            return super.findAll("from Training");
        }
        public Training find(int id){
            return super.find(Training.class, id);
        }
        
        public List<Player> playersSortedFromTrainingsNumber (){
            List<Player> playersSorted = null;
            EntityManager em = getEntityManager();
            Query query = em.createNativeQuery(SORTFROMTRAININGS, Player.class);
            playersSorted = (List<Player>)query.getResultList();
            return playersSorted;
        } 
        
//        public List<Player> playerSortedFromRank(List<Player> playerList){
//            List<Player> playerSortedFromRank = null;
//            EntityManager em = getEntityManager();
//            if(playerList.size()<= 10){
//                
//            }
//           }
        
        public Training save(Training c){
            return super.save(c);
        }
        
        public Training update(Training c){
            return super.update(c);
        }
        
        public void delete (int id){
            super.delete(Training.class,id);
        }
        
        public Training findTrainingFromDate(LocalDateTime date){
        EntityManager em = getEntityManager();
        TypedQuery<Training> query = em.createNamedQuery("Training.findFromDate", Training.class);
        query.setParameter("date", date);
        List<Training> list = query.getResultList();
        return list.get(0);
    }
    
}//class
