/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;
import static oregontrail.control.MapControl.createMap;
import oregontrail.exceptions.GameControlException;
import oregontrail.model.Game;
import oregontrail.model.Map;
import oregontrail.model.Player;
import oregontrail.model.Supplies;

/**
 *
 * @author mellissah.
 */
public class GameControl {

    protected static final BufferedReader keyboard = OregonTrail.getInFile();
    protected static final PrintWriter console = OregonTrail.getOutFile();

    public static Player savePlayer(String name) throws GameControlException {
        
        if (name == null | name.length() < 1) {
            throw new GameControlException("Can't use a blank name.");
        }
        
        Player player = new Player();  // player = new Player object
        player.setName(name);  //save the name in the player object
        OregonTrail.setPlayer(player);  //save the player in the main class of the project
                
        return player; 
    }
    
    public static void createNewGame(Player player) throws GameControlException {
       if (player == null || player.getName().length() < 1) {
           throw new GameControlException("Can't create a game without a player.");
       }
       Game game = new Game(); 
       OregonTrail.setPlayer(player); 
       
       Supplies items = createItems();
       OregonTrail.setSupplies(items);
       
       //actors = createActors()
       // Save the list of actors in the Game object
       // Assign an actor to the player 
       
       
       int numOfRows = 2;
       int numOfColumns = 3;
       Map map;
        map = createMap(numOfRows, numOfColumns);
       if (map == null) {
           throw new GameControlException("Can't create a game map.");
       }
      
       OregonTrail.setMap(map);
    }
    
    public static Supplies createItems() {
        //System.out.println("The createItems class has been called.");
        Supplies items;
        items = new Supplies();
        return items;
       
        //Save the list of items in the game 
    }

    public static void saveGame(Game game, String filePath)
                                throws GameControlException, IOException {
        if (game == null)
            throw new GameControlException("Can't save: Invalid Game");
        if (filePath == null || filePath.length()<1)
            throw new GameControlException("Can't save: Invalid File Name");
        
        try (ObjectOutputStream out = 
                new ObjectOutputStream(new FileOutputStream(filePath))){
            out.writeObject(game);
            GameControl.console.println("saveGame() in GameControl class");
        }   catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    public static Game getGame(String filePath)
                               throws GameControlException, IOException {
        if (filePath == null || filePath.length()<1)
            throw new GameControlException("Can't load: Invalid File Name");
        Game game = new Game();
        try (ObjectInputStream objectInput
                    = new ObjectInputStream(new FileInputStream(filePath))){
            game = (Game) objectInput.readObject();
            // GameControl.console.println("loadGame() in GameControl class");
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found error: " + ex.getMessage());
            return null;
        }
        // System.out.println("*** GameControl getGame() called ***");
        
        return game;
    }

    public static void getGame(Game game, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}