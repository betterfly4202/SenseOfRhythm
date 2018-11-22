import org.junit.Test;

import java.util.GregorianCalendar;

/**
 * Created by betterfly
 * Date : 2018.11.19
 */
public class CompareWithString {
    @Test
    public void builderNbuffer(){
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        new Thread(() -> {
            for(int i=0; i<10000; i++) {
                stringBuffer.append(i);
                stringBuilder.append(i);
            }
        }).start();

        new Thread(() -> {
            for(int i=0; i<10000; i++) {
                stringBuffer.append(i);
                stringBuilder.append(i);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);

                System.out.println("StringBuffer.length: "+ stringBuffer.length());
                System.out.println("StringBuilder.length: "+ stringBuilder.length());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Test
    public void compareWithBuilderNBuffer(){
        System.gc();
        long start=new GregorianCalendar().getTimeInMillis();
        long startMemory=Runtime.getRuntime().freeMemory();
//        StringBuffer sb = new StringBuffer(); // 11390, 10968, 11684, 10713, 10916
        StringBuilder sb = new StringBuilder(); // 11351, 10453, 10757, 10939
        for(int i = 0; i<200000; i++){
            sb.append(":"+i);
            sb.insert(i, "Hi");
        }
        long end=new GregorianCalendar().getTimeInMillis();
        long endMemory=Runtime.getRuntime().freeMemory();
        System.out.println(":::: StringBuilder Performance ::::");
        System.out.println("Time Taken:"+(end-start));
        System.out.println("Memory used:"+(startMemory-endMemory));
    }

    @Test
    public void threadString(){
        System.gc();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        new Thread(() -> {
            for(int i=0; i<100000; i++) {
                stringBuffer.append(i);
                stringBuilder.append(i);
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);

                System.out.println("StringBuffer.length: "+ stringBuffer.length());
                System.out.println("StringBuilder.length: "+ stringBuilder.length());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(stringBuffer.length());
        System.out.println(stringBuilder.length());
    }
}
