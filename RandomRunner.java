import java.io.File;
import javax.sound.sampled.*;

public class RandomRunner
{ public static void main ( String[] args) 
    {
        Random test = new Random("G");
        test.transpose(test.key, test.notes);
        test.playEight();
        test.print();
        for(int i=0; i < test.playedNotes.length; i++)
        {
            try{
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File(test.playedNotes[i]+".wav"));
                Clip test1 = AudioSystem.getClip();  

                test1.open(ais);
                test1.start();

                while (!test1.isRunning())
                    Thread.sleep(0);
                while (test1.isRunning())
                    Thread.sleep(0);

                test1.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
