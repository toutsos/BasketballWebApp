/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.service;

import java.util.ArrayList;
import java.util.List;
import kepyes.dao.CoachDao;
import kepyes.entities.Coach;


/**
 *
 * @author atoutsios
 */

public class CoachService {
    CoachDao cDao = new CoachDao();
    
    public List<Coach> coaches= new ArrayList<>();
    
    public List<Coach> getCoaches(){
        return cDao.findAll();
    }
    
    public Coach createCoach(Coach c){
        return cDao.save(c);
    }

    public Coach updateCoach(Coach c){
        return cDao.update(c);
    }
    
    public void deleteCoach(int c){
        cDao.delete(c);
    }
    
}
