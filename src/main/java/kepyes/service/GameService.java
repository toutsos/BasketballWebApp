/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.service;

import java.util.List;
import kepyes.dao.GameDao;
import kepyes.entities.Game;

/**
 *
 * @author atoutsios
 */
public class GameService {
     GameDao gDao = new GameDao();
    
    public List<Game> getGames(){
        return gDao.findAll();
    }
    
    public Game findGame(int id){
        return gDao.find(id);
    }
    
    
    public Game createGame(Game c){
        return gDao.save(c);
    }

    public Game updateGame(Game c){
        return gDao.update(c);
    }
    
    public void deleteGame(int c){
        gDao.delete(c);
    }
    
}
