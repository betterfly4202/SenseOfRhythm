package app.rhythm.player;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by betterFLY on 07/11/2018.
 */

// intro 배경 음악 삽입 : youtube 등에서 non copyrighted music 검색하여 서칭 >> 작업 시 유의할 필요가 있음
// resources 아래에 music 폴더 생성
// 자바에서 음악 재생을 위해 라이브러리 필요
// http://www.javazoom.net/index.shtml
/*
<dependency>
            <groupId>de.huxhorn.sulky</groupId>
            <artifactId>de.huxhorn.sulky.3rdparty.jlayer</artifactId>
            <version>1.0</version>
        </dependency>
 */

public class Music extends Thread{
    private Player player; // javazoom lib.

    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Music(String name, boolean isLoop){
        try {
            this.isLoop = isLoop;
            file = new File(Main.class.getResource("/music/"+name).toURI());
            fis = new FileInputStream(file);
//            bis = new BufferedInputStream(bis);
            player = new Player(fis);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public int getTime(){
        if(player == null){
            return 0;
        }

        return player.getPosition(); // 현재 플레이어의 재생 시간
    }

    // mp3 player closer
    public void close(){
        isLoop = false;
        player.close();
        this.interrupt(); // thread 종료
    }

    @Override
    public void run(){
        try{
            do{
                player.play(); //player 재생
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            }while(isLoop);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
