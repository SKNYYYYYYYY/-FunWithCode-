import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissors {
    static Scanner input = new Scanner(System.in);
    static int myWins = 0;
    static  int compWins = 0;
    public static void play(){

        String userChoice,compChoice = null;
        String option1 ="rock";
        String option2 ="paper";
        String option3 ="scissors";
        System.out.println("");

        System.out.println("Enter your choice");
        userChoice = input.next();
        Random random = new Random();
        int randomChoice = random.nextInt(3)+1;
        switch (randomChoice){
            case 1:
                compChoice = option1;
                break;
            case 2:
                compChoice = option2;
                break;
            default:
                compChoice = option3;
                break;
        }

        if (userChoice.equals(compChoice)) {
            System.out.println("");

            System.out.println("You tied, computer chose " + compChoice+" too. Please repeat.");

            play();
        }
        else if (userChoice.equalsIgnoreCase("rock") && (compChoice.equalsIgnoreCase("paper"))){
           compWins +=1;
            System.out.println("");
            System.out.println("Oh no computer won😱😱");
            System.out.println("Computer chose paper💀");

        }
        else if (userChoice.equalsIgnoreCase("rock") && (compChoice.equalsIgnoreCase("scissors"))){
            myWins +=1;
            System.out.println("");

            System.out.println("You won🤠🤠");
            System.out.println("Computer chose scissors😂");

        }
        else if (userChoice.equalsIgnoreCase("paper") && (compChoice.equalsIgnoreCase("rock"))){
            myWins +=1;
            System.out.println("");

            System.out.println("You won🤠🤠");
            System.out.println("Computer chose rock😂");

        }
         else if (userChoice.equalsIgnoreCase("paper") && (compChoice.equalsIgnoreCase("scissors"))){
            compWins +=1;
            System.out.println("");

            System.out.println("Oh no computer won😱😱");
            System.out.println("Computer chose scissors💀");

        }
         else if (userChoice.equalsIgnoreCase("scissors") && (compChoice.equalsIgnoreCase("paper"))){
            myWins +=1;
            System.out.println("");

            System.out.println("You won🤠🤠");
            System.out.println("Computer chose paper😂");

        } else if (userChoice.equalsIgnoreCase("scissors") && (compChoice.equalsIgnoreCase("rock"))){
            compWins +=1;
            System.out.println("");

            System.out.println("Oh no computer won😱😱");
            System.out.println("Computer chose rock💀");


        }

    }

    private static void  outputing() throws InterruptedException {
        String dot = ".", open="Opening output file";

        System.out.print(open);

        for (int i = 0; i <=2; i++) {
            System.out.print(dot);

            Thread.sleep(1000);
        }
//        for (int x = 0; x < 3; x++) {
//            StringBuilder stringBuilder = new StringBuilder(dot);
//            stringBuilder.delete(0,1);
//
//        }



    }
    public static void main(String[] args) {
        for (int i = 0; i < 3 ; i++) {
            play();

        }
        System.out.println("");

        System.out.println("You have " +myWins+ " points");
        System.out.println("Computer has " +compWins+ " points");
        try {
            FileWriter writer = new FileWriter("output.txt", true);
            System.out.println("");
            writer.write("Your wins: " + myWins + "        Computer wins: " + compWins+ "\n");
            writer.close();
            System.out.println("These records have been saved to the file named output");


                outputing();






            //To open the output file
            File file = new File("output.txt");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
            Thread.sleep(5000);
            file.length();
            System.exit(1);


        }
       catch (IOException e) {
            System.err.println("Error writing to the file "+ e.getMessage());

           throw new RuntimeException(e);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
