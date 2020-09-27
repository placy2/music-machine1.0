 import static java.lang.Math.*;

public class Random
{

    public String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    public String key;

    /** Constructor */
    public Random(String myKey)
    {
        key = myKey;
    }

    /** Main method, runs transpose, playEight twice in a row, then parses those 16 results into lettered notes in playedNotes */
    /**public void main(String[] args)
    {
        transpose(key, notes);
        int counter = 0;
        playEight();
        for(int i = 0; i < 8; i++)
        {
            if(playedInts[i]==-1)
            {
                playedNotes[counter] = "error";
            }
            else
            {
                playedNotes[counter] = transposed[playedInts[i]];
            }
            counter++;
        }
        playEight();
        for(int i = 0; i < 8; i++)
        {
            if(playedInts[i]==-1)
            {
                playedNotes[counter] = "error";
            }
            else
            {
                playedNotes[counter] = transposed[playedInts[i]];
            }
            counter++;
        }
    }*/

    String[] transposed = new String[notes.length+1];
    /** Changing the 0 value and adding the octave value for the note array if we need a non C key */
    public String[] transpose(String key, String[] notes)
    {
        int start = 0;
        for(int i = 0; i < notes.length; i++)
        {
            if(notes[i]==key) start = i;
        }

        int counter = 0;
        for(int i = start; i < notes.length; i++)
        {
            transposed[counter] = notes[i];
            counter++;
        }
        for(int i = 0; i < start; i++)
        {
            transposed[counter] = notes[i];
            counter++;
        }

        transposed[counter] = key+"2";
        return transposed;
    }


    String[] playedNotes = new String[8];

    /** Returning an array of eight ints, which correspond to note values */
    public void playEight()
    {
        
        for(int i = 0; i < 8; i++)
        {
            playedNotes[i] = transposed[randNum()];
        }
    }

  

    /** Simplifying calling a random value from 1-1000 */
    public int randNum()
    {
        return (int)(Math.random()*12);
    }

    /**Printer method that returns the results of playedNotes*/
    public void print()
    {
        System.out.print("In the key of "+key+", your song looks like this!");
        System.out.println("");
        for(int i=0;i<playedNotes.length;i++)
        {
            if(i==playedNotes.length-1) System.out.print(playedNotes[i]);
            else System.out.print(playedNotes[i]+", ");
        }
        System.out.println("");
        System.out.println("The Music Machine, by Parker Lacy and Alex Martin");
    }
}


