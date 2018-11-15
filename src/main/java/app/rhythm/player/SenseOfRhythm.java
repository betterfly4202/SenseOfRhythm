package app.rhythm.player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by betterFLY on 07/11/2018.
 */
public class SenseOfRhythm extends JFrame {

    // 배경화면 다운로드 : http://wallpaperswide.com/search.html?q=music
    private Image screenImage;
    private Graphics screenGraphic;

    private Image introBackground = new ImageIcon(this.getClass().getResource("/images/background/intro.jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(this.getClass().getResource("/images/interface/menuBar.png")));
    private JButton exitButton = new JButton(new ImageIcon(this.getClass().getResource("/images/button/btn_exit_basic.png")));

    public SenseOfRhythm(){
        setUndecorated(true); // -> GUI 기본 메뉴바 제거
        setTitle("Sense Of Rhythm");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false); // 사용자 사이즈 조절 제한
        setLocationRelativeTo(null); // 화면의 정 중앙
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 후 실제로 프로세스를 종료시킴
        setVisible(true); // 실제로 인터페이스를 표출
        setBackground(new Color(110, 110, 100, 0)); // paintComponents(g) 호출 시 배경을 흰색으로
        setLayout(null); // btn, jlabel 삽입시 위치에 맞도록 설정

        menuBar.setBounds(0, 0, 1280, 30);
        add(menuBar);

        exitButton.setBounds(50, 50, 30, 30);
        add(exitButton);

        Music music = new Music("intro_music.mp3", true);
        music.start();
    }

    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        paintComponents(g);
//        this.revalidate();
        repaint();
    }
}
