/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kepyes.entities;

import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table (name="player")
@NamedQueries({
    @NamedQuery(name = "Player.findFromName", query = "SELECT p FROM Player p WHERE p.name = :name"),
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")
})
public class Player implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
    public String name;
    
    public int age;
    
    public String phone;
    
    public int height;
    
    public double weight;
    
    @Column (name="trainings_number")
    public int totalTrainings;
    
    @OneToMany (mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PlayerTraining> trainings = new HashSet<>();
    
    @Transient
    private double totalRank;
    
    public Player(String name, int age, String phone, int height, double weight) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.height = height;
        this.weight = weight;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getTotalTrainings() {
        return totalTrainings;
    }

    public void setTotalTrainings(int trainings) {
        this.totalTrainings = trainings;
    }

    public Set<PlayerTraining> getTrainings() {
        return trainings;
    }

    public void setTrainings(PlayerTraining t) {
        this.trainings.add(t);
    }

    public double getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(double totalRank) {
        this.totalRank = totalRank;
    }
    
    
    
    @Override
    public String toString() {
        return name + ", age: " + age + ", phone: " + phone + ", height: " + height + ", weight: " + weight + ", MO rank: " +(totalRank/totalTrainings);
    }

}//class
