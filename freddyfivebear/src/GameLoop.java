package src;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameLoop {
    private OfficeUI office;

    private int battery;
    private int hour;
    private Timer tick;
    private int tickcounter;

    public GameLoop(OfficeUI o){
        office = o;
        battery = 100;
        hour = 12;

        tick = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (office.getBonnie().isAlive() && office.getChica().isAlive() && battery > 0 && (hour == 12 || hour < 6)) {
                    updateGame();
                } else {
                    if(hour == 6){
                        office.win();
                    }
                    else if (!office.getBonnie().isAlive()) {
                        office.jumpscare("bonnie");
                    } else if (!office.getChica().isAlive()) {
                        office.jumpscare("chica");
                    } else {
                        office.jumpscare("frezzle fastbear");
                    }
                    tick.stop();
                }
            }
        });
    }

    public void startNight(){
        tick.start();
    }

    public void updateGame() {
        tickcounter++;

        if(tickcounter % 3 == 0){
            int decrement = 1;
            if(office.isLeftLightOn()){
                decrement++;
            }
            if(office.isRightLightOn()){
                decrement++;
            }
            if(office.isLeftClosed()){
                decrement++;
            }
            if(office.isRightClosed()){
                decrement++;
            }
            battery-=decrement;
        }

        if (tickcounter % 25 == 0) {
            hour++;
            if (hour > 12) hour = 1;
        }

        office.updateBattery(battery);
        office.updateHour(hour);
    }
}
