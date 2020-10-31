/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.service;

import java.util.List;
import kepyes.dao.PlayerDao;
import kepyes.entities.Player;

/**
 *
 * @author atoutsios
 */
public class PlayerService {
    PlayerDao pDao = new PlayerDao();
    
    public List<Player> getPlayer(){
        return pDao.findAllPlayers();
    }
    
    public Player createPlayer(Player c){
        return pDao.save(c);
    }

    public Player updatePlayer(Player c){
        return pDao.update(c);
    }
    
    public void deletePlayer(Player c){
        pDao.delete(c.getId());
    }
    
}

