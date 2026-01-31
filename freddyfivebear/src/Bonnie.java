package src;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bonnie {

    private OfficeUI office;
    private Timer tick;
    private boolean atOffice;
    private boolean alive;

    public Bonnie(OfficeUI office) {
        this.office = office;
        alive = true;

        tick = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (alive) {
                    movement();
                }
            }
        });
    }

    public void startAI(){
        tick.start();
        atOffice = false;
    }

    public void movement() {
        int num = (int) (Math.random() * 3) + 1;

        if (atOffice) {
            if (office.isLeftClosed()) {
                atOffice = false;
            } else {
                alive = false;
            }
        } else if (num == 1) {
            atOffice = true;
        }
        office.repaint();
        
    }

    public boolean isAtOffice() {
        return atOffice;
    }

    public boolean isAlive() {
        return alive;
    }
}