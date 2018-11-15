import org.junit.Before;
import org.junit.Test;

/**
 * Created by betterfly
 * Date : 2018.11.10
 */


public class ImmuntableTest {
    @Before
    public void setUp() {

    }

    @Test
    public void immutableTest(){
        String a = "immutable";
        String b = a;
        System.out.println("a.hashCode : "+a.hashCode());
        System.out.println("b.hashCode : "+b.hashCode());
        System.out.println("a : "+ a);
        System.out.println("b : "+ b);

        System.out.println("=====change b value=======");
        b += " add str";
        System.out.println("a.hashCode : "+a.hashCode());
        System.out.println("a : "+ a);
        System.out.println("b.hashCode : "+b.hashCode());
        System.out.println("b : "+ b);
    }

    @Test
    public void mutableTest(){
        int [] a = {1,2};
        int [] b= a;
        System.out.println("a.hashCode : "+a.hashCode());
        System.out.println("b.hashCode : "+b.hashCode());
        for(int x : a){
            System.out.println("a : "+x);
        }
        for(int x : b){
            System.out.println("b : "+x);
        }

        System.out.println("=====change b value=======");
        b[1] = 5;
        System.out.println("a.hashCode : "+a.hashCode());
        System.out.println("b.hashCode : "+b.hashCode());
        for(int x : a){
            System.out.println("a : "+x);
        }
        for(int x : b){
            System.out.println("b : "+x);
        }
    }
}
