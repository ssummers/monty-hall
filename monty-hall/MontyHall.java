import javax.swing.*;
import java.awt.*;

public class MontyHall
{
    // Monty Hall Problem
    private JTextArea panel, display;
    private ImageIcon door = new ImageIcon("door.jpg");

    //resizing the door image
    Image doorImg = door.getImage();
    Image newDoorImg = doorImg.getScaledInstance(135, 250, Image.SCALE_SMOOTH);
    ImageIcon newDoor = new ImageIcon(newDoorImg);

    public JButton door1, door2, door3, reset, /*changeUser,*/ goAgain, endGame, doorSelected1, doorSelected2;
    private JLabel stayed, stayedWon, swapped, swappedWon, empty;

    public MontyHall()
    {
        panel = new JTextArea();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);

        display = new JTextArea();

        // Creating the area to display the stats and results of choices.
        Box displayResults = Box.createVerticalBox();
        displayResults.setPreferredSize(new Dimension(40,100));
        panel.add(layout.PAGE_START, displayResults);

        insertTextToBox(displayResults);

        makeButtons();

        // Creating the Grid Layout and Panel for the buttons
        JPanel p1 = new JPanel();
        GridLayout g1 = new GridLayout(1,3);
        p1.setLayout(g1);

        JPanel p2 = new JPanel();
        GridLayout g2 = new GridLayout(2,2);
        p2.setLayout(g2);

        addButtonsToPanel(p1);
        addButtonsToPanel2(p2);

        panel.add(layout.CENTER, p1);
        panel.add(layout.PAGE_END, p2);

        JFrame frame1 = new JFrame("Monty Hall");
        frame1.setContentPane(panel);
        frame1.setSize(410, 425);
        frame1.setVisible(true);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MontyHallEngine montyHallEngine = new MontyHallEngine(this);

        door1.addActionListener(montyHallEngine);
        door2.addActionListener(montyHallEngine);
        door3.addActionListener(montyHallEngine);
        reset.addActionListener(montyHallEngine);
        //changeUser.addActionListener(montyHallEngine);
        endGame.addActionListener(montyHallEngine);
        goAgain.addActionListener(montyHallEngine);
        doorSelected1.addActionListener(montyHallEngine);
        doorSelected2.addActionListener(montyHallEngine);
    }

    public void counterInts(int count1, int count2, int count3, int count4)
    {
        String stayedCount = Integer.toString(count1);
        String stayedWin = Integer.toString(count2);
        String swappedCount = Integer.toString(count3);
        String swappedWin = Integer.toString(count4);

        stayed.setText("Games Stayed: " + stayedCount);
        stayedWon.setText("Games Stayed and Won: " + stayedWin);
        swapped.setText("Games Swapped: " + swappedCount);
        swappedWon.setText("Games Swapped and Won: " + swappedWin);
    }

    public void insertTextToBox(Box box)
    {
        stayed = new JLabel("Games Stayed: \n");
        stayedWon = new JLabel("Games Stayed and Won: \n");

        swapped = new JLabel("Games Swapped: \n");
        swappedWon = new JLabel("Games Swapped and Won: \n");
        empty = new JLabel("\n");

        box.add(stayed);
        box.add(stayedWon);

        box.add(empty);

        box.add(swapped);
        box.add(swappedWon);
    }

    public void makeButtons()
    {
        door1 = new JButton("1", newDoor);
        door1.setPreferredSize(new Dimension(40,40));
        door2 = new JButton("2", newDoor);
        door2.setPreferredSize(new Dimension(40,40));
        door3 = new JButton("3", newDoor);
        door3.setPreferredSize(new Dimension(40,40));

        reset = new JButton("Reset Statistics");
        reset.setPreferredSize(new Dimension(50,30));
        //changeUser = new JButton("Change User");
        //changeUser.setPreferredSize(new Dimension(50,30));
        goAgain = new JButton("Play Again");
        goAgain.setPreferredSize(new Dimension(50, 30));
        doorSelected1 = new JButton("Door Selected");
        doorSelected1.setPreferredSize(new Dimension(50,30));
        doorSelected2 = new JButton("Final Selection");
        doorSelected2.setPreferredSize(new Dimension(50,30));
        endGame = new JButton("End Game");
        endGame.setPreferredSize(new Dimension(100,30));
    }

    public void addButtonsToPanel(JPanel p1)
    {
        p1.add(door1);
        p1.add(door2);
        p1.add(door3);
    }

    public void addButtonsToPanel2(JPanel p2)
    {
        p2.add(doorSelected1);
        p2.add(endGame);
        p2.add(doorSelected2);
        p2.add(reset);
        p2.add(goAgain);
        //p2.add(changeUser);
    }

    public void setDisplay(String s)
    {
        display.setText(s);
    }

    public String getDisplay()
    {
        return display.getText();
    }
}
