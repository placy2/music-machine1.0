 import static java.lang.Math.*;
/**
 * Algorithms.java

 * Name: Parker Lacy 
 * Date: 11/11/16
 * Period: 4A
 *
 */
public class Algorithms
{
    public String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    public String key;

    /** Constructor */
    public Algorithms(String myKey)
    {
        key = myKey;
    }

    String[] playedNotes= new String[8];
    /** Main method, runs transpose, playEight twice in a row, then parses those 16 results into lettered notes in playedNotes */
    public void main(String[] args)
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
    }

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

        transposed[counter] = key;
        return transposed;
    }

    /** Helper method for determining inequalities easily (for probabilities)*/
    public boolean isBetween(int x, int low, int high)
    {
        return(x>=low && x<= high);
    }

    int[] playedInts = new int[8];

    /** Returning an array of eight ints, which correspond to note values */
    public void playEight()
    {
        playedInts[0] = 0;
        playedInts[1] = onRoot(randNum());
        for(int i = 2; i < 8; i++)
        {
            playedInts[i] = playOne(playedInts[i-1], randNum());
        }
    }

    /**Passing in the current note and a random number to return a single note using helper methods*/
    public int playOne(int current, int rand)
    {
        if(current==0) return onRoot(rand);
        if(current==1) return onm2(rand);
        if(current==2) return onM2(rand);
        if(current==3) return onm3(rand);
        if(current==4) return onM3(rand);
        if(current==5) return onP4(rand);
        if(current==6) return ona4(rand);
        if(current==7) return onP5(rand);
        if(current==8) return onm6(rand);
        if(current==9) return onM6(rand);
        if(current==10) return onm7(rand);
        if(current==11) return onM7(rand);
        if(current==12) return onP8(rand);
        return -1;
    }

    /**Probability helper to establish interval from the root */
    public int onRoot(int rand)
    {
        //root
        if(isBetween(rand, 0, 46)){
            return 0; 
        }
        //M2
        else if(isBetween(rand, 47, 332)){
            return 2; 
        }
        //P4
        else if(isBetween(rand, 333, 523)){
            return 5; 
        }
        //P5
        else if(isBetween(rand, 523, 809)){
            return 7; 
        }
        //m6
        else if(isBetween(rand, 810, 857)){
            return 8; 
        }
        //P8
        else if(isBetween(rand, 858, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the minor second */
    public int onm2(int rand)
    {
        //P8
        return 12;
    }

    /**Probability helper to establish interval from the major second */
    public int onM2(int rand)
    {
        //root
        if(isBetween(rand, 0, 375)){
            return 0; 
        }
        //M2
        else if(isBetween(rand, 376, 685)){
            return 2; 
        }
        //m3
        else if(isBetween(rand, 686, 748)){
            return 3; 
        }
        //P5
        else if(isBetween(rand, 749, 811)){
            return 7; 
        }
        //M6
        else if(isBetween(rand, 812, 874)){
            return 9; 
        }
        //m7
        else if(isBetween(rand, 875, 937)){
            return 10; 
        }
        //P8
        else if(isBetween(rand, 938, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the minor third */
    public int onm3(int rand)
    {
        //root
        if(isBetween(rand, 0, 40)){
            return 0; 
        }
        //m2
        else if(isBetween(rand, 41, 194)){
            return 1; 
        }
        //m3
        else if(isBetween(rand, 195, 771)){
            return 3; 
        }
        //a4
        else if(isBetween(rand, 772, 848)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 849, 886)){
            return 7; 
        }
        //m6
        else if(isBetween(rand, 887, 924)){
            return 8; 
        }
        //m7
        else if(isBetween(rand, 925, 962)){
            return 10; 
        }
        //P8
        else if(isBetween(rand, 963, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the major third */
    public int onM3(int rand)
    {
        //M2
        if(isBetween(rand, 0, 154)){
            return 2; 
        }
        //M3
        else if(isBetween(rand, 155, 513)){
            return 4; 
        }
        //P4
        else if(isBetween(rand, 514, 769)){
            return 5; 
        }
        //a4
        else if(isBetween(rand, 770, 846)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 847, 923)){
            return 7; 
        }
        //P8
        else if(isBetween(rand, 924, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the perfect fourth */
    public int onP4(int rand)
    {
        //root
        if(isBetween(rand, 0, 10)){
            return 0; 
        }
        //m2
        else if(isBetween(rand, 11, 30)){
            return 1; 
        }
        //M2
        else if(isBetween(rand, 31, 55)){
            return 2; 
        }
        //m3
        else if(isBetween(rand, 56, 65)){
            return 3; 
        }
        //M3
        else if(isBetween(rand, 66, 105)){
            return 4; 
        }
        //P4
        else if(isBetween(rand, 106, 465)){
            return 5; 
        }
        //a4
        else if(isBetween(rand, 466, 485)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 486, 660)){
            return 7; 
        }
        //m6
        else if(isBetween(rand, 661, 735)){
            return 8; 
        }
        //M6
        else if(isBetween(rand, 736, 780)){
            return 9; 
        }
        //m7
        else if(isBetween(rand, 781, 880)){
            return 10; 
        }
        //M7
        else if(isBetween(rand, 881, 905)){
            return 11; 
        }
        //P8
        else if(isBetween(rand, 906, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the augmented fourth */
    public int ona4(int rand)
    {
        //m2
        if(isBetween(rand, 0, 45)){
            return 1; 
        }
        //m3
        else if(isBetween(rand, 46, 288)){
            return 3; 
        }
        //M3
        else if(isBetween(rand, 289, 379)){
            return 4; 
        }
        //P4
        else if(isBetween(rand, 380, 424)){
            return 5; 
        }
        //a4
        else if(isBetween(rand, 425, 606)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 607, 727)){
            return 7; 
        }
        //m6
        else if(isBetween(rand, 728, 803)){
            return 8; 
        }
        //M6
        else if(isBetween(rand, 804, 818)){
            return 9; 
        }
        //m7
        else if(isBetween(rand, 819, 924)){
            return 10; 
        }
        //M7
        else if(isBetween(rand, 925, 985)){
            return 11; 
        }
        //P8
        else if(isBetween(rand, 986, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the perfect fifth */
    public int onP5(int rand)
    {
        //root
        if(isBetween(rand, 0, 17)){
            return 0; 
        }
        //m2
        else if(isBetween(rand, 18, 51)){
            return 1; 
        }
        //M2
        else if(isBetween(rand, 52, 119)){
            return 2; 
        }
        //m3
        else if(isBetween(rand, 120, 136)){
            return 3; 
        }
        //M3
        else if(isBetween(rand, 137, 244)){
            return 4; 
        }
        //P4
        else if(isBetween(rand, 245, 346)){
            return 5; 
        }
        //a4
        else if(isBetween(rand, 347, 352)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 353, 710)){
            return 7; 
        }
        //m6
        else if(isBetween(rand, 711, 795)){
            return 8; 
        }
        //M6
        else if(isBetween(rand, 796, 892)){
            return 9; 
        }
        //m7
        else if(isBetween(rand, 893, 926)){
            return 10; 
        }
        //M7
        else if(isBetween(rand, 927, 943)){
            return 11; 
        }
        //P8
        else if(isBetween(rand, 944, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the minor sixth */
    public int onm6(int rand)
    {
        //m2
        if(isBetween(rand, 0, 146)){
            return 1; 
        }
        //M2
        else if(isBetween(rand, 147, 152)){
            return 2; 
        }
        //m3
        else if(isBetween(rand, 153, 214)){
            return 3; 
        }
        //M3
        else if(isBetween(rand, 215, 225)){
            return 4; 
        }
        //P4
        else if(isBetween(rand, 226, 371)){
            return 5; 
        }
        //a4
        else if(isBetween(rand, 372, 540)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 541, 568)){
            return 7; 
        }
        //m6
        else if(isBetween(rand, 569, 810)){
            return 8; 
        }
        //M6
        else if(isBetween(rand, 811, 838)){
            return 9; 
        }
        //m7
        else if(isBetween(rand, 839, 911)){
            return 10; 
        }
        //M7
        else if(isBetween(rand, 912, 950)){
            return 11; 
        }
        //P8
        else if(isBetween(rand, 951, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the major sixth */
    public int onM6(int rand)
    {
        //M2
        if(isBetween(rand, 0, 97)){
            return 2; 
        }
        //m3
        else if(isBetween(rand, 98, 112)){
            return 3; 
        }
        //M3
        else if(isBetween(rand, 113, 122)){
            return 4; 
        }
        //P4
        else if(isBetween(rand, 123, 202)){
            return 5; 
        }
        //a4
        else if(isBetween(rand, 203, 252)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 253, 403)){
            return 7; 
        }
        //M6
        else if(isBetween(rand, 404, 699)){
            return 9; 
        }
        //m7
        else if(isBetween(rand, 700, 835)){
            return 10; 
        }
        //M7
        else if(isBetween(rand, 836, 930)){
            return 11; 
        }
        //P8
        else if(isBetween(rand, 931, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the minor seventh */
    public int onm7(int rand)
    {
        //m2
        if(isBetween(rand, 0, 64)){
            return 1; 
        }
        //M2
        else if(isBetween(rand, 65, 137)){
            return 2; 
        }
        //m3
        else if(isBetween(rand, 138, 208)){
            return 3; 
        }
        //M3
        else if(isBetween(rand, 209, 210)){
            return 4; 
        }
        //P4
        else if(isBetween(rand, 211, 289)){
            return 5; 
        }
        //a4
        else if(isBetween(rand, 290, 319)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 320, 392)){
            return 7; 
        }
        //m6
        else if(isBetween(rand, 393, 503)){
            return 8; 
        }
        //M6
        else if(isBetween(rand, 504, 569)){
            return 9; 
        }
        //m7
        else if(isBetween(rand, 570, 780)){
            return 10; 
        }
        //M7
        else if(isBetween(rand, 781, 872)){
            return 11; 
        }
        //P8
        else if(isBetween(rand, 873, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the major seventh */
    public int onM7(int rand)
    {
        //m2
        if(isBetween(rand, 0, 83)){
            return 1; 
        }
        //M2
        else if(isBetween(rand, 84, 149)){
            return 2; 
        }
        //m3
        else if(isBetween(rand, 150, 196)){
            return 3; 
        }
        //M3
        else if(isBetween(rand, 197, 292)){
            return 4; 
        }
        //P4
        else if(isBetween(rand, 293, 299)){
            return 5; 
        }
        //a4
        else if(isBetween(rand, 300, 359)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 360, 385)){
            return 7; 
        }
        //m6
        else if(isBetween(rand, 386, 449)){
            return 8; 
        }
        //M6
        else if(isBetween(rand, 450, 532)){
            return 9; 
        }
        //m7
        else if(isBetween(rand, 533, 677)){
            return 10; 
        }
        //M7
        else if(isBetween(rand, 678, 910)){
            return 11; 
        }
        //P8
        else if(isBetween(rand, 911, 1000)){
            return 12; 
        }
        return -1;
    }

    /**Probability helper to establish interval from the octave (perfect eighth) */
    public int onP8(int rand)
    {
        //root
        if(isBetween(rand, 0, 4)){
            return 0; 
        }
        //m2
        else if(isBetween(rand, 5, 129)){
            return 1; 
        }
        //M2
        else if(isBetween(rand, 130, 262)){
            return 2; 
        }
        //m3
        else if(isBetween(rand, 263, 293)){
            return 3; 
        }
        //M3
        else if(isBetween(rand, 294, 339)){
            return 4; 
        }
        //P4
        else if(isBetween(rand, 340, 428)){
            return 5; 
        }
        //a4
        else if(isBetween(rand, 429, 454)){
            return 6; 
        }
        //P5
        else if(isBetween(rand, 455, 489)){
            return 7; 
        }
        //m6
        else if(isBetween(rand, 490, 520)){
            return 8; 
        }
        //M6
        else if(isBetween(rand, 521, 552)){
            return 9; 
        }
        //m7
        else if(isBetween(rand, 553, 727)){
            return 10; 
        }
        //M7
        else if(isBetween(rand, 728, 802)){
            return 11; 
        }
        //P8
        else if(isBetween(rand, 803, 1000)){
            return 12; 
        }
        return -1;
    }

    /** Simplifying calling a random value from 1-1000 */
    public int randNum()
    {
        return (int)(Math.random()*1001);
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
