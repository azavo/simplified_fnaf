package src;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.*;


public class App {
    public static void main(String[] args){
        JFrame frame = new JFrame();
	    frame.setSize(500, 500);
	    frame.setTitle("freddy fastbear");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OfficeUI office = new OfficeUI();
	    frame.add(office, BorderLayout.CENTER);
	    frame.setVisible(true);
        
        Bonnie bonnie = new Bonnie(office);
        Chica chica = new Chica(office);
        
        office.setBonnie(bonnie);
        office.setChica(chica);
        bonnie.startAI();
        chica.startAI();

        GameLoop gameLoop = new GameLoop(office);
        gameLoop.startNight();
    }
}
