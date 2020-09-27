import java.io.File;
import javax.sound.sampled.*;
public class AlgorithmsRunner
{
    public static void main ( String[] args) 
    {
        Algorithms test = new Algorithms("C");
        test.main(null);
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
