//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiApp1 {
    String keyChosen;
    String numChosen;
    String compChosen;

    //Note: Typically the main method will be in a
    //separate class. As this is a simple one class
    //example it's all in the one class.
    public static void main(String[] args) {

        new GuiApp1();
    }

    public GuiApp1()
    {
        JFrame guiFrame = new JFrame();

        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Music Machine Version 2");
        guiFrame.setSize(500,350);

        //Centers JFrame
        guiFrame.setLocationRelativeTo(null);

        //Options for the JComboBoxes
        String[] majKeys = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        String[] numNotes = {"4","8","16","32"};
        String[] complex = {"Beginner", "Beginner 2", "Intermediate", "Intermediate 2",
                "Advanced", "Odd"};

        final JPanel comboPanel = new JPanel();
        JLabel keyLbl = new JLabel("Key:");
        JComboBox keys = new JComboBox(majKeys);
        JLabel numLbl = new JLabel("# of Notes Generated:");
        JComboBox nums = new JComboBox(numNotes);
        JLabel compLbl = new JLabel("Complexity");
        JComboBox comp = new JComboBox(complex);

        comboPanel.add(keyLbl);
        comboPanel.add(keys);
        comboPanel.add(numLbl);
        comboPanel.add(nums);
        nums.setSelectedIndex(1);
        comboPanel.add(compLbl);
        comboPanel.add(comp);

        final JPanel infoPanel = new JPanel();
        JLabel keyChoiceLbl = new JLabel("C");
        JLabel numChoiceLbl = new JLabel("8");
        JLabel compChoiceLbl = new JLabel("Beginner");

        infoPanel.add(keyChoiceLbl);
        infoPanel.add(numChoiceLbl);
        infoPanel.add(compChoiceLbl);

        keys.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    JComboBox cb = (JComboBox)event.getSource();
                    String keyChosen = (String)cb.getSelectedItem();
                    keyChoiceLbl.setText(keyChosen);
                }
            });

        nums.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    JComboBox cb = (JComboBox)event.getSource();
                    String numChosen = (String)cb.getSelectedItem();
                    numChoiceLbl.setText(numChosen);
                }
            });

        comp.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    JComboBox cb = (JComboBox)event.getSource();
                    String compChosen = (String)cb.getSelectedItem();
                    compChoiceLbl.setText(compChosen);
                }
            });

        JButton theButt = new JButton("MAKE THAT MUSIC!");

        theButt.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    SecondSemesterRunner test = new SecondSemesterRunner(keyChoiceLbl.getText(), numChoiceLbl.getText(), compChoiceLbl.getText());
                    test.test.transpose(keyChoiceLbl.getText(), test.test.notes);
                    test.main(null);
                }
            });

        guiFrame.add(comboPanel, BorderLayout.NORTH);
        guiFrame.add(theButt, BorderLayout.CENTER);
        guiFrame.add(infoPanel, BorderLayout.SOUTH);

        guiFrame.setVisible(true);
    }
}