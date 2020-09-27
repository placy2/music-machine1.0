# README

#### Overview
This repository contains the raw .java and .wav files from my high school senior project (2016-17). This was written in Java in BlueJ and assumes it is being run there, with the console output available. 
It also implements a limited Swing GUI. If opened in BlueJ, running `GuiApp1` will run the project as intended. 
The code is obviously quite unorganized, as I just uploaded the entire directory of related project files we had at the end of the project.

The project's goal was to create a program capable of "writing music" in Java.
I worked with another student throughout the year, largely during classtime, to refine this idea. What we ended up with is split between the `Algorithms` files and the `SecondSemester` files.
The research we did, combined with our relative lack of math or programming knowledge, meant we settled on using a very basic probability model for the first try, generating each note in a melody
based on weighted probabilities for the previous note (starting and ending on the root of the chord). This is successfully implemented in Algorithms.java, but sounds... awful.

The app that is run with `GuiApp1` factors in what is likely more important in real life than a melody: a chord structure, or harmony. 
In SecondSemester.java, we split a variety of chords into categories that we termed "complexities." In the Beginner complexity, only the I, IV, and V chords are included. 
This generation would ideally also be based on weighted randomization, but is instead almost entirely generated randomly. Certain chords, such as the iii chord, are weighted towards a natural movement (in this case, vi). 

#### Future Goals
While actually refactoring this code is not something I necessarily want to do, 
something that I have now managed to figure out that I did not at the time is freely modifiable code generation of audible notes. 
This means this is a perfect time to try and create a web application that features some of this program's functionality and logic, in a more robust and modern way.
Check out the progress in music-machine2.0 on my Github.
