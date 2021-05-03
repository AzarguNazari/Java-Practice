package JavaPractice.ThreadLesson;

/**
 *
 * @author Hazar Gul
 */
public class ThreadTutorials {

    public static void main(String[] args) {

        Graphics anim = new Graphics("Animation");
        Graphics cartoom = new Graphics("Cartoon");
        
        Thread video = new Thread(new Video("Chapli Choplin"));
        video.setName("Video");
        
        
        anim.start();
        cartoom.start();
        video.start();
        
        
    }

}

class Graphics extends Thread{
    public Graphics(String gName){
        this.setName(gName);
    }
    @Override
    public void run(){
        for(int x = 0; x < 10; x++){
            System.out.println(this.getName() + " Graphics");
        }
    }
    synchronized public void someJob(){
        System.out.println("THis job is accessed on by on Thread");
    }
    public void careFul(){
        synchronized(this){
            System.out.println("This is just a portion of syncronized part of thread");
        }
    }
}

class Video implements Runnable{
    private final String videoName;
    public Video(String vName){
        videoName = vName;
    }
    @Override
    public void run() {
        for(int x =0; x < 10; x++){
            System.out.println("Video fuck Video");
        }
    }

}