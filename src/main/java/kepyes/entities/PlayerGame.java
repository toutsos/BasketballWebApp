/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author atoutsios
 */

@Entity
@Table (name="player_game")
public class PlayerGame implements Serializable{

    @Id
    private int id;
    
    @JoinColumn (name = "points")
    private int points;
    
    @ManyToOne
    @JoinColumn (name = "idplayer")
    private Player player;
    
    @ManyToOne
    @JoinColumn (name = "idgame")
    private Game game;
    
    public PlayerGame() {
    }
    
    

    public PlayerGame(int points, Player playerid, Game game) {
        this.points = points;
        this.player = playerid;
        this.game = game;
    }

    public PlayerGame(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    
    
    
    
}//class
