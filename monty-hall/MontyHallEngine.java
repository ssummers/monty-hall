import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class MontyHallEngine implements ActionListener
{
    MontyHall montyHall;
    String firstDoor, secondDoor;
    int carDoor = behindTheDoor();
    private ImageIcon goat = new ImageIcon("goat.jpg");
    private ImageIcon car = new ImageIcon("car.jpg");

    //resetting image sizes
    Image goatImg = goat.getImage();
    Image newGoatImg = goatImg.getScaledInstance(135, 250, Image.SCALE_SMOOTH);
    ImageIcon newGoat = new ImageIcon(newGoatImg);

    Image carImg = car.getImage();
    Image newCarImg = carImg.getScaledInstance(190,250, Image.SCALE_SMOOTH);
    ImageIcon newCar = new ImageIcon(newCarImg);

    private int swappedCount;
    private int stayedCount;
    private int swappedWin;
    private int stayedWin;

    //private String userName;
    private int score;
    private int totalGames;

    public MontyHallEngine(MontyHall montyHall)
    {
        this.montyHall = montyHall;

        //userName = JOptionPane.showInputDialog(null,"Please enter your user name.");

        JOptionPane.showMessageDialog(null, "Choose your first door and then press 'Door " +
                "Selected' to enter your first choice.");
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() instanceof JButton)
        {
            JButton clicked = (JButton)(e.getSource()); //saves the button that was clicked

            if (clicked.getText().contains("1"))
            {
                montyHall.setDisplay(clicked.getText());
            }

            if (clicked.getText().contains("2"))
            {
                montyHall.setDisplay(clicked.getText());
            }

            if (clicked.getText().contains("3"))
            {
                montyHall.setDisplay(clicked.getText());
            }

            if (clicked.getText() == "Door Selected") // Clicked one door already.
            {
                firstDoor = (montyHall.getDisplay());

                int firstDoorInt = Integer.parseInt(firstDoor);

                if (firstDoorInt == carDoor)
                {
                    if (firstDoorInt == 1)
                    {
                        montyHall.door3.setIcon(newGoat);
                    }

                    if (firstDoorInt == 2)
                    {
                        montyHall.door1.setIcon(newGoat);
                    }

                    if (firstDoorInt == 3)
                    {
                        montyHall.door2.setIcon(newGoat);
                    }
                }

                else if (firstDoorInt != carDoor)
                {
                    if (firstDoorInt == 1 && carDoor == 2)
                    {
                        montyHall.door3.setIcon(newGoat);
                    }

                    if (firstDoorInt == 1 && carDoor == 3)
                    {
                        montyHall.door2.setIcon(newGoat);
                    }

                    if (firstDoorInt == 2 && carDoor == 3)
                    {
                        montyHall.door1.setIcon(newGoat);
                    }

                    if (firstDoorInt == 2 && carDoor == 1)
                    {
                        montyHall.door3.setIcon(newGoat);
                    }

                    if (firstDoorInt == 3 && carDoor == 1)
                    {
                        montyHall.door2.setIcon(newGoat);
                    }

                    if (firstDoorInt == 3 && carDoor == 2)
                    {
                        montyHall.door1.setIcon(newGoat);
                    }
                }
                JOptionPane.showMessageDialog(null, "Choose your second door and press " +
                        "'Final Selection' to make your final selection.");
            }

            else if (clicked.getText() == "Final Selection")
            {
                secondDoor = montyHall.getDisplay();

                int firstDoorInt = Integer.parseInt(firstDoor);
                int secondDoorInt = Integer.parseInt(secondDoor);

                if (firstDoorInt == secondDoorInt)
                {
                    stayedCount += 1;
                    totalGames += 1;

                    if (secondDoorInt == carDoor)
                    {
                        JOptionPane.showMessageDialog(null, "You won the car!");
                        stayedWin += 1;
                        score += 1;

                        if (secondDoorInt == 1)
                        {
                            montyHall.door1.setIcon(newCar);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 2)
                        {
                            montyHall.door2.setIcon(newCar);
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 3)
                        {
                            montyHall.door3.setIcon(newCar);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door1.setIcon(newGoat);
                        }
                    }

                    else if (secondDoorInt != carDoor)
                    {
                        JOptionPane.showMessageDialog(null, "You won a goat!");

                        if (secondDoorInt == 1 && carDoor == 2)
                        {
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door2.setIcon(newCar);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 1 && carDoor == 3)
                        {
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newCar);
                        }

                        if (secondDoorInt == 2 && carDoor == 3)
                        {
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newCar);
                        }

                        if (secondDoorInt == 3 && carDoor == 2)
                        {
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door2.setIcon(newCar);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 3 && carDoor == 1)
                        {
                            montyHall.door1.setIcon(newCar);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 2 && carDoor == 1)
                        {
                            montyHall.door1.setIcon(newCar);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newGoat);
                        }
                    }
                }

                if (firstDoorInt != secondDoorInt)
                {
                    swappedCount += 1;
                    totalGames += 1;

                    if (secondDoorInt == carDoor)
                    {
                        JOptionPane.showMessageDialog(null, "You won the car!");
                        swappedWin += 1;
                        score += 1;

                        if (secondDoorInt == 1)
                        {
                            montyHall.door1.setIcon(newCar);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 2)
                        {
                            montyHall.door2.setIcon(newCar);
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 3)
                        {
                            montyHall.door3.setIcon(newCar);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door1.setIcon(newGoat);
                        }
                    }
                    else if (secondDoorInt != carDoor)
                    {
                        JOptionPane.showMessageDialog(null, "You won a goat!");

                        if (secondDoorInt == 1 && carDoor == 2)
                        {
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door2.setIcon(newCar);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 1 && carDoor == 3)
                        {
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newCar);
                        }

                        if (secondDoorInt == 2 && carDoor == 3)
                        {
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newCar);
                        }

                        if (secondDoorInt == 3 && carDoor == 2)
                        {
                            montyHall.door1.setIcon(newGoat);
                            montyHall.door2.setIcon(newCar);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 3 && carDoor == 1)
                        {
                            montyHall.door1.setIcon(newCar);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newGoat);
                        }

                        if (secondDoorInt == 2 && carDoor == 1)
                        {
                            montyHall.door1.setIcon(newCar);
                            montyHall.door2.setIcon(newGoat);
                            montyHall.door3.setIcon(newGoat);
                        }
                    }
                }
                montyHall.counterInts(stayedCount, stayedWin, swappedCount, swappedWin);

                JOptionPane.showMessageDialog(null, "You selected: " + secondDoor + "\nThe car"
                        + " was behind: Door " + carDoor);
            }

            else if (clicked.getText() == "Reset Statistics")
            {
                stayedWin = 0;
                stayedCount = 0;
                swappedCount = 0;
                swappedWin = 0;
                score = 0;

                montyHall.counterInts(stayedCount, stayedWin, swappedCount, swappedWin);
            }

            else if (clicked.getText() == "Play Again")
            {
                montyHall.door1.setIcon(montyHall.newDoor);
                montyHall.door2.setIcon(montyHall.newDoor);
                montyHall.door3.setIcon(montyHall.newDoor);
                firstDoor = null;
                secondDoor = null;
                carDoor = behindTheDoor();
            }

            else if (clicked.getText() == "Change User")
            {
                stayedWin = 0;
                stayedCount = 0;
                swappedCount = 0;
                swappedWin = 0;
                montyHall.counterInts(stayedCount, stayedWin, swappedCount, swappedWin);

                montyHall.door1.setIcon(montyHall.newDoor);
                montyHall.door2.setIcon(montyHall.newDoor);
                montyHall.door3.setIcon(montyHall.newDoor);
                firstDoor = null;
                secondDoor = null;
                carDoor = behindTheDoor();

                //infoToDB(userName, score, totalGames, swappedCount, swappedWin,
                //        stayedCount, stayedWin);

                score = 0;
                //userName = "";

                //userName = JOptionPane.showInputDialog(null,"Please enter your user name.");
            }

            else if (clicked.getText() == "End Game")
            {
                //infoToDB(userName, score, totalGames, swappedCount, swappedWin,
                //        stayedCount, stayedWin);
                System.exit(0);
            }
        }
    }

//    public void infoToDB(String userName, int score, int totalGames, int swappedCount, int swappedWin,
//                         int stayedCount, int stayedWin)
//    {
//        MontyHallDB montyHallDB = new MontyHallDB(userName, score, totalGames, swappedCount, swappedWin,
//                stayedCount, stayedWin);
//    }

    public int behindTheDoor()
    {
        int min = 1;
        int max = 3;

        int randomNum = ThreadLocalRandom.current().nextInt(min, max +1);

        return randomNum;
    }
}
