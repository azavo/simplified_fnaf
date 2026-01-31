package src;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class OfficeUI extends JPanel {
    private Image office;

    private Bonnie bonnie;
    private Chica chica;

    private Image bonnieimg;
    private Image chicaimg;

    private Image bonniescare;
    private Image chicascare;
    private Image employment;
    private Image winscreen;

    private Image leftdoor;
    private Image rightdoor;

    private Image leftempty;
    private Image rightempty;
    
    private JLabel hour;
    private JLabel battery;

    private JButton leftlight;
    private JButton rightlight;

    private JButton leftdoorb;
    private JButton rightdoorb;

    private ImageIcon bat1;
    private ImageIcon bat2;
    private ImageIcon bat3;
    private ImageIcon bat4;

    private boolean leftLightOn;
    private boolean rightLightOn;
    private boolean leftDoorClosed;
    private boolean rightDoorClosed;

    private boolean deadbonnie;
    private boolean deadchica;
    private boolean deadfreddy;
    private boolean won;
    
    public OfficeUI(){
        try {
            office = ImageIO.read(new File("freddyfivebear\\src\\images\\defaultoffice.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bonnieimg = ImageIO.read(new File("freddyfivebear\\src\\images\\bonnieirl.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            chicaimg = ImageIO.read(new File("freddyfivebear\\src\\images\\chicairl.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            leftdoor = ImageIO.read(new File("freddyfivebear\\src\\images\\leftdoor.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rightdoor = ImageIO.read(new File("freddyfivebear\\src\\images\\rightdoor.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            leftempty = ImageIO.read(new File("freddyfivebear\\src\\images\\leftempty.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rightempty = ImageIO.read(new File("freddyfivebear\\src\\images\\rightempty.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bonniescare = ImageIO.read(new File("freddyfivebear\\src\\images\\bonniescare.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            chicascare = ImageIO.read(new File("freddyfivebear\\src\\images\\chicascare.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            employment = ImageIO.read(new File("freddyfivebear\\src\\images\\employment.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            winscreen = ImageIO.read(new File("freddyfivebear\\src\\images\\winscreen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));
        this.setLayout(new GridLayout(4,4));
        
        bat1 = new ImageIcon(new ImageIcon("freddyfivebear\\src\\images\\bat1.png").getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH));
        bat2 = new ImageIcon(new ImageIcon("freddyfivebear\\src\\images\\bat2.png").getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH));
        bat3 = new ImageIcon(new ImageIcon("freddyfivebear\\src\\images\\bat3.png").getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH));
        bat4 = new ImageIcon(new ImageIcon("freddyfivebear\\src\\images\\bat4.png").getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH));

        for (int i = 0; i < 20; i++) {
            if (i == 4) {
                hour = new JLabel("12 AM");
                hour.setFont(new Font("Courier", Font.BOLD, 16));
                hour.setForeground(Color.WHITE);
                this.add(hour);
            }
            else if(i == 6){
                leftlight = new JButton("L");
                leftlight.addActionListener(e -> {
                    leftLightOn = !leftLightOn;
                    if(leftLightOn){
                        if(bonnie.isAtOffice()){
                            SFX.stinger();
                        }
                    }
                    SFX.light();
                    repaint();
                });
                JPanel LBP = new JPanel(new FlowLayout(FlowLayout.LEFT,20,0));
                LBP.setOpaque(false);
                LBP.add(leftlight);
                this.add(LBP);
            }
            else if(i == 9){
                rightlight = new JButton("L");
                rightlight.addActionListener(e -> {
                    rightLightOn = !rightLightOn;
                    if(rightLightOn){
                        if(chica.isAtOffice()){
                            SFX.stinger();
                        }
                    }
                    SFX.light();
                    repaint();
                });
                JPanel RBP = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50,0));
                RBP.setOpaque(false);
                RBP.add(rightlight);
                this.add(RBP);
            }
            else if(i == 11){
                leftdoorb = new JButton("D");
                leftdoorb.addActionListener(e -> {
                    leftDoorClosed = !leftDoorClosed;
                    SFX.door();
                    repaint();
                });
                JPanel LBP = new JPanel(new FlowLayout(FlowLayout.LEFT,20,0));
                LBP.setOpaque(false);
                LBP.add(leftdoorb);
                this.add(LBP);
            }
            else if(i == 14){
                rightdoorb = new JButton("D");
                rightdoorb.addActionListener(e -> {
                    rightDoorClosed = !rightDoorClosed;
                    SFX.door();
                    repaint();
                });
                JPanel RBP = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50,0));
                RBP.setOpaque(false);
                RBP.add(rightdoorb);
                this.add(RBP);
            }
            else if (i == 16) {
                battery = new JLabel("100%");
                battery.setIcon(bat1);
                battery.setFont(new Font("Courier", Font.BOLD, 16));
                battery.setForeground(Color.WHITE);
                this.add(battery);
            }
            else {
                JPanel empty = new JPanel();
                empty.setOpaque(false);
                this.add(empty);
            }
        }
        
    }

    public void setBonnie(Bonnie b){
        bonnie = b;
    }
    public void setChica(Chica c){
        chica = c;
    }

    public void updateBattery(int b){
        battery.setText(b + "%");
        if (b > 66) {
            battery.setIcon(bat1);
        }
        else if (b > 33) {
            battery.setIcon(bat2);
        }
        else if (b > 0) {
            battery.setIcon(bat3);
        }
        else {
            battery.setIcon(bat4);
        }
    }
    public void updateHour(int h){
        hour.setText(h + " AM");
    }

    public boolean isLeftClosed() {
        return leftDoorClosed;
    }
    public boolean isRightClosed() {
        return rightDoorClosed;
    }
    public boolean isLeftLightOn(){
        return leftLightOn;
    }
    public boolean isRightLightOn(){
        return rightLightOn;
    }
    public Bonnie getBonnie() {
        return bonnie;
    }
    public Chica getChica() {
        return chica;
    }

    public void paintComponent(Graphics g){

        g.drawImage(office, 0,0, this);
        
        if(bonnie.isAtOffice() && isLeftLightOn()){
            g.drawImage(bonnieimg, 0,0, this);
        }
        if(chica.isAtOffice() && isRightLightOn()){
            g.drawImage(chicaimg, 0,0, this);
        }
        

        if(isLeftLightOn()){
            g.drawImage(leftempty,0,0,this);
        }
        if(isRightLightOn()){
            g.drawImage(rightempty,0,0,this);
        }

        if(isLeftClosed()){
            g.drawImage(leftdoor, 0,0, this);
        }

        if(isRightClosed()){
            g.drawImage(rightdoor, 0,0, this);
        }

        if(deadbonnie){
            g.drawImage(bonniescare,0,0,this);
        }

        if(deadchica) {
            g.drawImage(chicascare,0,0,this);
        }

        if(deadfreddy){
            g.drawImage(employment,0,0,this);
        }
        if(won){
            g.drawImage(winscreen, 0, 0, this);
        }
    }

    public void jumpscare(String animatronic) {
        leftlight.setOpaque(false);
        rightlight.setOpaque(false);
        leftdoorb.setOpaque(false);
        rightdoorb.setOpaque(false);
        if (animatronic.equals("bonnie")) {
            deadbonnie = true;
        } else if (animatronic.equals("chica")) {
            deadchica = true;
        } else {
            deadfreddy = true;
        }
        SFX.boom();
        this.repaint();
    }
    public void win(){
        won = true;
        this.repaint();
    }
}
