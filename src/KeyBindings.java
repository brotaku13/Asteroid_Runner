import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by brian on 5/4/2017.
 */
public class KeyBindings extends AbstractAction {
    String cmd;
    Player player;

    public KeyBindings (Player player, String cmd){
        this.cmd = cmd;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (cmd) {
            case ("UP"):
                player.setUP(true);
                break;
            case ("UP_RELEASED"):
                player.setUP(false);
                break;
            case ("DOWN"):
                player.setDOWN(true);
                break;
            case ("DOWN_RELEASED"):
                player.setDOWN(false);
                break;
            case ("RIGHT"):
                player.setRIGHT(true);
                break;
            case ("RIGHT_RELEASED"):
                player.setRIGHT(false);
                break;
            case ("LEFT"):
                player.setLEFT(true);
                break;
            case ("LEFT_RELEASED"):
                player.setLEFT(false);
                break;
            default:
                player.setRIGHT(false);
                player.setLEFT(false);
                player.setDOWN(false);
                player.setUP(false);
                break;

        }


    }
}
