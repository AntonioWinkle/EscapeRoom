import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Let's make an escape that's a little silly.
The goal of this escape room is to walk out
the front door with escape written over the door with a key. You get this key by heading
outside to get the key barried under your door mat.

The front door won't have escape written at the top of it, so you have to get paint to
make it an exit door.

You'll need your wallet containing all your pennies to go pick up groceries from the market.

Get a shovel from the retired mole that lives under your stairs.
Similar to the shovel get his old war helmet, that is especially good at headbutting,
for a favor.
His favorite color was always green.

Make green paint by mixing strange assortments of chemicals in your kitchen to make a
strange chemical with the same consistency of paint.

ACTUAL CODE PLAN VVV

Make use of buttons for different selection options, like looking at or taking items.

Perhaps use of switch statements that contain running functions for methods.

Methods should make use of if statements usually as some options shouldn't pop up if the
requirements aren't met.

Create boolean variables to hold data if certain items are being held or not.
 - This should help with the If statements allowing certain dialogue to appear, but it
 should also tell the program that certain things shouldn't more than once.

 when wanting to make movement between multiple dialogue boxes seem seamless, to do this
 clear layout should be at the beginning of most if not all programs so nothing lingers
 from past methods being run and potentially making the GUI appear cluttered and janky.

 NEW IDEA - making a lot of buttons might be an inefficent waste of time, so lets just make
 radio buttons or switches and have one button confirm a selection on the list.

 12/6/2021 - maybe make escape room simpler to not bog up code. Thought on situation
 more, utilize cases instead of button groups because it will allow for easy running of methods.
 Replace radio operator button thing with a text field and have the user give an input.
 */
public class EscapeRoom {

    static JPanel panel;
    static JLabel situationText;
    static JButton confirmButton, nextButton;
    static JRadioButton optionOne, optionTwo, optionThree, optionFour;
    static int situationNum;

    public static void main(String[] args) {new EscapeRoom();}

    public EscapeRoom(){
        panel = new JPanel(new BorderLayout());
        JFrame frame = new JFrame("A normal Escape Room");
        situationText = new JLabel();
        confirmButton = new JButton("Confirm");
        nextButton = new JButton("Next");
        optionOne = new JRadioButton("Placeholder");
        optionTwo = new JRadioButton("Placeholder");
        optionThree = new JRadioButton("Placeholder");
        optionFour = new JRadioButton("Placeholder");

        optionOne.setSelected(true);



        situationText.setBounds(180, 10, 200, 200);
        nextButton.setBounds(215,190,200,30);
        optionOne.setBounds(190, 190, 200, 30);
        optionTwo.setBounds(190,220, 200, 30);
        optionThree.setBounds(190,250,200,30);
        optionFour.setBounds(190,280,200, 30);
        confirmButton.setBounds(215, 310, 150, 25);

        ButtonGroup radios = new ButtonGroup();

        nextButton.addActionListener(new nextListener());
        confirmButton.addActionListener(new confirmListener());

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        radios.add(optionOne);
        radios.add(optionTwo);
        radios.add(optionThree);
        radios.add(optionFour);

        panel.add(nextButton);
        panel.add(optionOne);
        panel.add(optionTwo);
        panel.add(optionThree);
        panel.add(optionFour);
        panel.add(situationText, BorderLayout.NORTH);
        panel.setPreferredSize(new Dimension(200, 200));
        panel.add(confirmButton);

        situationText.setText("<html>" +
                "<p>You wake up to your room lying in bed and look around. " +
                "Around you are your night stand with various amounts of randomly" +
                " assorted items, your front door leading outside, a door to your " +
                "kitchen, and a hallway. You never quite understood your houses " +
                "layout, but its not time to worry about that. Time to start the day!</p>"
                + "</html>");

        optionOne.setVisible(false);
        optionTwo.setVisible(false);
        optionThree.setVisible(false);
        optionFour.setVisible(false);
        confirmButton.setVisible(false);

        panel.setLayout(null);
        frame.add(panel);
        frame.setVisible(true);

    }

    private class confirmListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            if(optionOne.isSelected()){
                nightStand();
            }
            if(optionTwo.isSelected()){
                frontDoor();
            }
            if(optionThree.isSelected()){
                situationNum = 3;
            }
            if(optionFour.isSelected()){
                situationNum = 4;
            }
        }
    }

    private class nextListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            optionOne.setVisible(true);
            optionTwo.setVisible(true);
            optionThree.setVisible(true);
            optionFour.setVisible(true);
            confirmButton.setVisible(true);
            nextButton.setVisible(false);
            mainRoom();
        }
    }

    public static void mainRoom(){
        optionOne.setText("Look at your night stand");
        optionTwo.setText("Observe the front door");
        optionThree.setText("Gaze at the room around");
        optionFour.setText("Contemplate life instead!");
    }

    public static void nightStand(){
        situationText.setText("You look at your cabinet.");
        optionOne.setText("Open Drawer");
        optionTwo.setText("Break lamp");
    }

    public static void frontDoor(){
        situationText.setText("You observe the front door.");
    }

}
