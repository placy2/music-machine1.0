import java.io.File;
import javax.sound.sampled.*;
/**
 * Write a description of class SecondSemesterRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondSemesterRunner
{
    public int num;
    public SecondSemester test;

    public SecondSemesterRunner(String myKey, String myNum, String myComp)
    {
        test = new SecondSemester(myKey, myComp);
        test.main(null);
        num = Integer.parseInt(myNum);
    }

    public void main(String[] args)
    {
        String[] playedChords = new String[num];
        int[] root = {0,4,7};
        playedChords[0] = test.convert(root);
        playedChords[playedChords.length-1] = test.convert(root);
        for(int i = 1; i < playedChords.length-1; i++)
        {
            String temp = test.selectChord();
            if(temp.contains(" "))
            {
                playedChords[i] = temp.substring(0, temp.lastIndexOf(" "));
                i++;
                playedChords[i] = temp.substring(temp.lastIndexOf(" ")+1, temp.length());
            }
            else
            {
                playedChords[i] = temp;
            }
        }

        System.out.print("In the key of "+test.key+", your song's chord structure looks like this!");
        System.out.println("");
        for(int i=0;i<playedChords.length;i++)
        {
            if(i==playedChords.length-1) System.out.print(playedChords[i]);
            else System.out.print(playedChords[i]+", ");
        }
        System.out.println("");
        System.out.println("A potential melody that fits into your song's chord structure looks like this!");
        String[] playedNotes = new String[playedChords.length];
        playedNotes[playedChords.length-1] = test.key;
        for(int i=0; i< playedChords.length-1; i++)
        {
            int rand = (int)(Math.random()*(playedChords[i].length()-1));
            if(playedChords[i].charAt(rand)=='#')
            {
                playedNotes[i] = playedChords[i].charAt(rand-1) + "#";
            }
            else if(playedChords[i].charAt(rand+1)=='#')
            {
                playedNotes[i] = playedChords[i].charAt(rand) + "#";
            }
            else
            {
                playedNotes[i] = playedChords[i].substring(rand, rand+1);
            }
            if(i==playedNotes.length-2) System.out.print(playedNotes[i]+", " + playedNotes[i+1]);
            else System.out.print(playedNotes[i]+", ");
        }
        System.out.println("");
        System.out.println("It should be playing now, turn your sound on!");
        System.out.println("");
        for(int i=0; i < playedNotes.length; i++)
        {
            try{
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File(playedNotes[i]+".wav"));
                Clip test = AudioSystem.getClip();  

                test.open(ais);
                test.start();

                while (!test.isRunning())
                    Thread.sleep(0);
                while (test.isRunning())
                    Thread.sleep(0);

                test.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }
}
