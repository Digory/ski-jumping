import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    private final JumpGenerator jumpGenerator = new JumpGenerator();

    public void start(Scanner reader){
        this.reader = reader;
        inputParticipants();
        tournamentBegins();
        displayResults();
    }

    public void inputParticipants(){
        System.out.println("Kumpula ski jumping week\n"
                + "Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true){
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if (name.isEmpty()){
                break;
            }
            jumpGenerator.add(new SkiJumper(name));
        }
    }

    public void tournamentBegins(){
        System.out.println("\nThe tournament begins!");
        while (true){
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String input = reader.nextLine();
            if (input.equalsIgnoreCase("quit")){
                break;
            }
            if (input.equalsIgnoreCase("jump")){
                jumpGenerator.jump();
            }
        }
    }

    public void displayResults(){
        jumpGenerator.printResults();
    }

}
