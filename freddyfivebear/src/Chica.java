package src;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Chica {

    private OfficeUI office;
    private Timer tick;
    private boolean atOffice;
    private boolean alive;

    public Chica(OfficeUI office) {
        this.office = office;
        alive = true;

        tick = new Timer(5500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movement();
            }
        });
    }
    
    public void startAI(){
        tick.start();
    }

    public void movement() {
        int num = (int) (Math.random() * 3) + 1;

        if (atOffice) {
            if (office.isRightClosed()) {
                atOffice = false;
            } else {
                alive = false;
            }
        } else if (num == 1) {
            atOffice = true;
        }
        
    }

    public boolean isAtOffice() {
        return atOffice;
    }

    public boolean isAlive() {
        return alive;
    }
}