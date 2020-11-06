
package kepyes.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="game")
public class Game implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    public String opponent;
    
    @Column (name="datetime")
    public LocalDateTime gameDateTime;

    @ManyToOne
    public Stadium gameStadium;
    
    @OneToMany (mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PlayerGame> players = new HashSet<>();
    
        //CONSTRUCTOR//
    
    public Game() {
    }

    public Game(String opponent, LocalDateTime gameDateTime, Stadium stadium) {
        this.opponent = opponent;
        this.gameDateTime = gameDateTime;
        this.gameStadium=stadium;
    }
    
        //GETTERS-SETTERS
    
    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
      
   
    public LocalDateTime getGameDateTime() {
        return gameDateTime;
    }

    public void setGameDateTime(LocalDateTime gameDateTime) {
        this.gameDateTime = gameDateTime;
    }
    
        public Stadium getGameStadium() {
        return gameStadium;
    }

    public void setGameStadium(Stadium gameStadium) {
        this.gameStadium = gameStadium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<PlayerGame> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerGame> players) {
        this.players = players;
    }
        
    

    //METHODS//
   
    
    /**
     * Converts LocalDateTIme of game to LocalDate for equals reasons
     * @param localGameTime
     * @return LocalDate
     */
    public LocalDate getDate () {
        LocalDate newDate = gameDateTime.toLocalDate();
        return newDate;
    }//getDate

    @Override
    public String toString() {
        return "Opponent=" + opponent + ", Date: " + gameDateTime + ", Stadium= " + gameStadium + '}';
    }

    


}//class
