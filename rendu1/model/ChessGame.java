import javax.swing.*;
import java.util.List;

public abstract class ChessGame extends JFrame{

        JFrame frame;
        List<Player> listPlayers;


        public ChessGame(JFrame frame, List<Player> listPlayers)
        {
            this.frame = frame;
            this.listPlayers = listPlayers;
        }
}
