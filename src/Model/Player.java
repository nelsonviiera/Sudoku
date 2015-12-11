/* http://www.onlinetutorialspoint.com/hibernate/singleton-hibernate-sessionfactory-example.html
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

/**
 *
 * @author yudi
 */
@Entity
@Inheritance
public class Player implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private long time;
    @Column
    private int totalPlays;
    private static Player instance;

    public Player() {
    }

    private Player(String name, long time) {
        this.name = name;
        this.time = time;
    }
    
    public static Player getPlayer(String name, long time) {
        if(instance == null)
            instance = new Player(name, time);
        return instance;
    }
    
    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public long getInitial() {
        return time;
    }

    public void setInitial(long time) {
        this.time = time;
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    public void setTotalPlays(int totalPlays) {
        this.totalPlays = totalPlays;
    }
}
