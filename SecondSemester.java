import static java.lang.Math.*;
/** Similar to first set of algorithms, works based on chords and less probability, 
 * more relying on sets of nested arrays
 * 
 */
public class SecondSemester
{
    public String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    public String key;
    public String comp;

    public SecondSemester(String myKey, String myComp)
    {
        key = myKey;
        comp = myComp;
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

        transposed[counter] = key+"2";
        return transposed;
    }

    /** Helper method for determining inequalities easily (for probabilities)*/
    public boolean isBetween(int x, int low, int high)
    {
        return(x>=low && x<= high);
    }

    /** Massive declaration of arrays inbound (all chord difficulties) */
    public int[][] beg = {{0,4,7}, {5,9,0}, {7,11,2}};
    public int[][] beg2 = {{2,5,9}, {4,7,11}, {9,0,4}};
    public int[][] imd = {{11,2,5}, {2,5,9,0}, {7,11,2,5}, {11,2,5,9}};
    public int[][] imd2 = {{2,6,9}, {6,9,0,4}, {6,9,0}, {2,6,9,0}};
    public int[][] adv = {{0,3,7}, {7,10,2}, {5,8,11}, {9,1,4}};
    public int[][] odd = {{0,4,8}, {5,9,1}, {7,11,3}, {11,2,5,9}, {11,2,5,8}};
    public int[][] modal = {{0,2,4,5,7,9,11}, {0,2,3,5,7,9,10}, {0,1,3,5,7,8,10}, {0,2,4,6,7,9,11}, {0,2,4,5,7,9,10}, {0,2,3,5,7,8,10}};

    /** Converting chordal array into readable note String form */
    public String convert(int[] raw)
    {
        String result = "";
        for(int i = 0; i < raw.length; i++)
        {
            result += transposed[raw[i]];
        }
        return result;
    }
    
    /** Randomly selects from arrays available, then randomly selects within the array (unless weighted, e.g. beg2) and returns the String form of the chord */
    public String selectChord()
    {
        int rand;
        
        if(comp.equals("Beginner"))
        {
            rand = (int)(Math.random()*beg.length);
            return convert(beg[rand]);
        }
        else if(comp.equals("Beginner 2"))
        {
            rand = (int) (Math.random()*2);
            if(rand==0)
            {
                rand = (int)(Math.random()*beg.length);
                return convert(beg[rand]);
            }
            else
            {
                rand = (int)(Math.random()*1001);
                if(isBetween(rand, 0, 300)) return convert(beg2[0]);
                else if(isBetween(rand, 301, 400)) return convert(beg2[1]);
                else return convert(beg2[2]);
            }
        }
        else if(comp.equals("Intermediate"))
        {
            rand = (int)(Math.random()*3);
            if(rand==0)
            {
                rand = (int)(Math.random()*beg.length);
                return convert(beg[rand]);
            }
            else if(rand==1)
            {
                rand = (int)(Math.random()*1001);
                if(isBetween(rand, 0, 300)) return convert(beg2[0]);
                else if(isBetween(rand, 301, 400)) return convert(beg2[1]);
                else return convert(beg2[2]);
            }
            else
            {
                rand = (int)(Math.random()*imd.length);
                return convert(imd[rand]);
            }
            
        }
        else if(comp.equals("Intermediate 2"))
        {
            rand = (int)(Math.random()*4);
            if(rand==0)
            {
                rand = (int)(Math.random()*beg.length);
                return convert(beg[rand]);
            }
            else if(rand==1)
            {
                rand = (int)(Math.random()*1001);
                if(isBetween(rand, 0, 300)) return convert(beg2[0]);
                else if(isBetween(rand, 301, 400)) return convert(beg2[1]);
                else return convert(beg2[2]);
            }
            else if(rand==2)
            {
                rand = (int)(Math.random()*imd.length);
                return convert(imd[rand]);
            }
            else
            {
                rand = (int)(Math.random()*imd2.length);
                return convert(imd2[rand]) + " " + convert(beg[2]);
            }
        }
        else if(comp.equals("Advanced"))
        {
            rand = (int)(Math.random()*5);
            if(rand==0)
            {
                rand = (int)(Math.random()*beg.length);
                return convert(beg[rand]);
            }
            else if(rand==1)
            {
                rand = (int)(Math.random()*1001);
                if(isBetween(rand, 0, 300)) return convert(beg2[0]);
                else if(isBetween(rand, 301, 400)) return convert(beg2[1]);
                else return convert(beg2[2]);
            }
            else if(rand==2)
            {
                rand = (int)(Math.random()*imd.length);
                return convert(imd[rand]);
            }
            else if(rand==3)
            {
                rand = (int)(Math.random()*imd2.length);
                return convert(imd2[rand]) + " " +  convert(beg[2]);
            }
            else
            {
                rand = (int)(Math.random()*adv.length);
                return convert(adv[rand]);
            }
        }
        else if(comp.equals("Odd"))
        {
            rand = (int)(Math.random()*6);
            if(rand==0)
            {
                rand = (int)(Math.random()*beg.length);
                return convert(beg[rand]);
            }
            else if(rand==1)
            {
                rand = (int)(Math.random()*1001);
                if(isBetween(rand, 0, 300)) return convert(beg2[0]);
                else if(isBetween(rand, 301, 400)) return convert(beg2[1]);
                else return convert(beg2[2]);
            }
            else if(rand==2)
            {
                rand = (int)(Math.random()*imd.length);
                return convert(imd[rand]);
            }
            else if(rand==3)
            {
                rand = (int)(Math.random()*imd2.length);
                return convert(imd2[rand]) + " " +  convert(beg[2]);
            }
            else if(rand==4)
            {
                rand = (int)(Math.random()*adv.length);
                return convert(adv[rand]);
            }
            else
            {
                rand = (int)(Math.random()*odd.length);
                if(rand==0)
                {
                    return convert(odd[rand]) + " " +  convert(beg[0]);
                }
                if(rand==3)
                {
                    rand = (int)(Math.random()*2);
                    if(rand==0) return convert(odd[3]) + " " +  convert(beg[0]);
                    else return convert(odd[3]) + " " +  convert(beg2[2]);
                }
                else
                {
                    return convert(odd[rand]);
                }
            }
        }
        else if(comp.equals("Modal"))
        {
            return "Modal development is still under construction";
            /** Randomly select a mode, then choose a starting point and do i, i+2, i+4 (position based). If value at position is 12 or greater, subtract 12.
             * Also make sure to create a new array for the storage of these values that can be fed into the convert method.
             */
        }
        else return "error";
    }
    
    public void main(String[] args)
    {
        transpose(key, notes);
    }
}