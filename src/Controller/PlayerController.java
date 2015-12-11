/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Player;

/**
 *
 * @author yudi
 */
public class PlayerController {
    
    private Player player;
    
    public boolean setPlayer (String name) {
        if(name.equals(""))
            return false;
        player = Player.getPlayer(name, System.currentTimeMillis()/1000);
        return true;
    }
}
