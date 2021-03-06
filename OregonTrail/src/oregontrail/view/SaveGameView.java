/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail.view;
import java.io.IOException;
import oregontrail.model.Game;
import oregontrail.OregonTrail;
import oregontrail.control.GameControl;
import oregontrail.exceptions.GameControlException;

/**
 *
 * @author mellissah.
 */

public class SaveGameView extends View {

    public SaveGameView() {
        super("\n\tEnter the path of the file to save:");
    }

    
/*    private String getInputs() {
        String[] inputs = new String[1]; //array one element long
        
        
       
        Display instructions to save the game
        input1 = getInput(thePromptMessage)
        save a reference to input1 in the inputs array
        return inputs; 
    }
*/
    @Override
    public boolean doAction(String inputs) {
        String filePath = inputs;
        Game game = OregonTrail.getCurrentGame();
        try {
            GameControl.saveGame(game, filePath);
        } catch (GameControlException e) {
            this.console.println(e.getMessage());
            return false;
        } catch (IOException e) {
            this.console.println("I/O Error: " + e.getMessage());
            return false;
        }
        this.console.println("Game successfully saved");
        return true;
    }

}
