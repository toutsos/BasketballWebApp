/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.service;

import java.util.List;
import kepyes.dao.TrainingDao;
import kepyes.entities.Player;
import kepyes.entities.Training;

/**
 *
 * @author atoutsios
 */
public class TrainingService {
    TrainingDao tDao = new TrainingDao();
    
    public List<Training> getTrainings(){
        return tDao.findAll();
    }
    
    public Training findTraining(int id){
        return tDao.find(id);
    }
    
    public List<Player> sortTraining(){
        return tDao.playersSortedFromTrainingsNumber();
    }
    
    public Training createTraining(Training t){
        return tDao.save(t);
    }

    public Training updateTraining(Training t){
        return tDao.update(t);
    }
    
    public void deleteTraining(int t){
       tDao.delete(t);
    }
}
