package com.rhythm.player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by betterFLY on 07/11/2018.
 */
public class SenseOfRhythm extends JFrame {

    // 배경화면 다운로드 : http://wallpaperswide.com/search.html?q=music
    private Image screenImage;
    private Graphics screenGraphic;

    private Image introBackground;

    public SenseOfRhythm(){
        setTitle("Sense Of Rhythm");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false); // 사용자 사이즈 조절 제한
        setLocationRelativeTo(null); // 화면의 정 중앙
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 후 실제로 프로세스를 종료시킴
        setVisible(true); // 실제로 인터페이스를 표출

        introBackground = new ImageIcon(this.getClass().getResource("resources/images/intro.jpg")).getImage();

    }

    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g){
        g.drawImage(introBackground, 0, 0, null);
        this.repaint();
    }
}
