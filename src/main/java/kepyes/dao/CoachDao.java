/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import kepyes.entities.Coach;
import java.util.List;
/**
 *
 * @author a.toutsios
 */

public class CoachDao extends JPAUtil<Coach>{

        private static final String FINDALL = "SELECT c FROM Coach c";
    
        public List<Coach> findAll(){
            List<Coach> coaches = new ArrayList<>();
            EntityManager em = getEntityManager();
            coaches = em.createQuery(FINDALL, Coach.class).getResultList();
            em.close();
            return coaches;
        }
        
        public Coach find(int id){
            return super.find(Coach.class, id);
        }
        
        public Coach getCoachWithoutClosingEm(int id){
            EntityManager em = getEntityManager();
            Coach t = em.find(Coach.class, id);
            return t;
        }
        
        public Coach save(Coach c){
            return super.save(c);
        }
        
        public Coach update(Coach c){
            Coach oldCoach = findAll().get(0);
            System.out.println(oldCoach);
            oldCoach.setName(c.getName());
            oldCoach.setSalary(c.getSalary());
            oldCoach.setStart(c.getStart());
            System.out.println(oldCoach);
            return super.update(oldCoach);
        }
        
        public void delete (int id){
            super.delete(Coach.class,id);
        }
        
        

}//class
