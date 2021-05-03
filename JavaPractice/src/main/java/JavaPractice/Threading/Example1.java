package JavaPractice.Threading;
public class Example1 extends Thread{
    
    @Override
    public void run(){
        System.out.println("Hello world");
    }
    
    
    public static void main(String[] args) {
        
        /*Example1 ex = new Example1();
        ex.start();
        */
        
        Multi3 mul = new Multi3();
        mul.run();
    }
}

class Multi3 implements Runnable{

    @Override
    public void run() {
        System.out.println("This is the Multi3 threading");
    }

}