/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail.view;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;
import oregontrail.control.GameControl;
import oregontrail.exceptions.GameControlException;

/**
 *
 * @author Mike
 */
public class MainMenuView extends View {
    
    public MainMenuView() {
        super("\n"
              + "\n\t-----------------------------------------"
              + "\n\t| Main Menu                             |"
              + "\n\t-----------------------------------------"
              + "\n\t  N - Start new game"
              + "\n\t  R - Restart existing game"
              + "\n\t  S - Save the game"
              + "\n\t  L - Load a saved game"
              + "\n\t  H - Get help on how to play the game"
              + "\n\t  E - Exit Oregon Trail"
              + "\n\t-----------------------------------------");
    }
    
    
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); //convert all uppercase
        char inputChar; 
        boolean endView = false;
        
        inputChar = getInputChar(value);
        
        switch (inputChar) {
            case 'N': 
            try {
                startNewGame();
            } catch (GameControlException e) {
                this.console.println(e.getMessage());
            }
            case 'R':
               restartGame();
               break;
            case 'S':
                this.saveGame();
                break;
            case 'L':
                this.loadGame();
                break;
            case 'H':
                getHelp();
                break;
            case 'E':
                return true;
            default: 
                this.console.println("Invalid menu item.");
        }
        return false; 
    }
    
    private void startNewGame() throws GameControlException {
        GameControl.createNewGame(OregonTrail.getPlayer());   
        GameMenuView gameMenuView = new GameMenuView();
        boolean valid = false;
        BuyOxenView oxen = new BuyOxenView();
        while (!valid) {
            valid = oxen.display();
        }
        valid = false;
        while (!valid){
            valid = gameMenuView.display();
        }
    }

    private void saveGame() {
       SaveGameView saveGameView = new SaveGameView();
       saveGameView.display();
    }
    
    private void restartGame() {
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        startExistingGameView.displayStartExistingGameView();
    }
    
    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        boolean exitHelpMenu;
        exitHelpMenu = false;
        while(!exitHelpMenu) {
            exitHelpMenu = helpMenuView.display();
        }
    }

    private void loadGame() {
        LoadGameView loadGameView = new LoadGameView();
        loadGameView.display();
        // this.console.println("*** loadGame() called ***");
    }

}
