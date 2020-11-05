/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.service;

import java.util.List;
import kepyes.dao.StadiumDao;
import kepyes.entities.Stadium;

/**
 *
 * @author atoutsios
 */
public class StadiumService {
    
    StadiumDao sDao = new StadiumDao();
    
    public List<Stadium> getStadiums(){
        return sDao.findAll();
    }
    
    public Stadium createStadium(Stadium s){
        return sDao.save(s);
    }

    public Stadium updateStadium(Stadium s){
        return sDao.update(s);
    }
    
    public void deleteStadium(int s){
        sDao.delete(s);
    }
    
    public Stadium findStadiumFromName(String name){
        return sDao.findStadiumFromName(name);
    }
}
