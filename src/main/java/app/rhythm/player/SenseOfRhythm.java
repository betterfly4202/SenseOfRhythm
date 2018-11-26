package app.rhythm.player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by betterFLY on 07/11/2018.
 */
public class SenseOfRhythm extends JFrame {

    // 배경화면 다운로드 : http://wallpaperswide.com/search.html?q=music
    private Image screenImage;
    private Graphics screenGraphic;

    private Image background = new ImageIcon(this.getClass().getResource("/images/background/intro.jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(this.getClass().getResource("/images/interface/menuBar.png")));

    //FIXME : IMAGE화면 자체를 필요로함
    private ImageIcon exitButtonEnteredImage = new ImageIcon(this.getClass().getResource("/images/button/btn_exit_entered.png"));
    private ImageIcon exitButtonBasicImage =new ImageIcon(this.getClass().getResource("/images/button/btn_exit_basic.png"));

    private ImageIcon startButtonImage =new ImageIcon(this.getClass().getResource("/images/button/btn_start.png"));
    private ImageIcon quitButtonImage =new ImageIcon(this.getClass().getResource("/images/button/btn_quit.png"));

    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonImage);
    private JButton quitButton = new JButton(quitButtonImage);

    private int mouseX,mouseY;

    public SenseOfRhythm(){
        setUndecorated(true); // -> GUI 기본 메뉴바 제거
        setTitle("Sense Of Rhythm");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false); // 사용자 사이즈 조절 제한
        setLocationRelativeTo(null); // 화면의 정 중앙
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 후 실제로 프로세스를 종료시킴
        setVisible(true); // 실제로 인터페이스를 표출
        setLayout(null); // btn, jlabel 삽입시 위치에 맞도록 설정
        setBackground(new Color(0, 0, 0, 0)); // paintComponents(g) 호출 시 배경을 흰색으로

        addExitButton();
        addMenuBar();
        addQuitButton();
        addStartButton();


//        Music music = new Music("intro_music.mp3", true);
//        music.start();
    }

    public void addMenuBar(){
        menuBar.setBounds(0, 0, 1280, 30);

        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                // x,y좌표 갖고와서 JFrame 인터페이스 위치 이동
                setLocation(x, y);
            }
        });

        add(menuBar);
    }

    public void addExitButton(){
        exitButton.setBounds(1245, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                exitButton.setIcon(exitButtonEnteredImage);
            }

            @Override
            public void mouseExited(MouseEvent e){
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                System.exit(0);
            }
        });

        add(exitButton);
    }

    public void addStartButton(){
        startButton.setBounds(40, 200, 400, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);

        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                startButton.setIcon(startButtonImage);
            }

            @Override
            public void mouseExited(MouseEvent e){
                startButton.setIcon(startButtonImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                //게임시작 이벤트
                startButton.setVisible(false);
                quitButton.setVisible(false);
                background = new ImageIcon(this.getClass().getResource("/images/background/game_background.jpg")).getImage();

                // 5강까지 완료
                // https://www.youtube.com/watch?v=v4MVn4Zb0IY&list=PLRx0vPvlEmdDySO3wDqMYGKMVH4Qa4QhR&index=6
            }
        });

        add(startButton);
    }

    public void addQuitButton(){
        quitButton.setBounds(40, 350, 400, 100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);

        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                quitButton.setIcon(quitButtonImage);
            }

            @Override
            public void mouseExited(MouseEvent e){
                quitButton.setIcon(quitButtonImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                System.exit(0);
            }
        });

        add(quitButton);
    }

    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        paintComponents(g);
        this.repaint();
//        paintComponents(g);
//        this.revalidate();
        repaint();
    }
}
