
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JumpGenerator{

    private final ArrayList<SkiJumper> skiJumpers = new ArrayList<SkiJumper>();
    private final Random random = new Random();
    private int roundCounter = 0;

    public void add(SkiJumper skiJumper) {
        skiJumpers.add(skiJumper);
    }

    public void printResults(){
        System.out.println("\nThanks!\n\n"
                + "Tournament results:\n"
                + "Position    Name");
        Collections.sort(skiJumpers);
        Collections.reverse(skiJumpers);

        // Displays the results in order of most points first.

        int counter = 1;
        for (SkiJumper elements : skiJumpers){
            System.out.println(counter+"           "+elements+"\n"
                    + "            "+elements.printLengths());
        }

    }

    public void jump() {
        roundCounter++;
        Collections.sort(skiJumpers);

        // The jumper with the least points starts first.

        System.out.println("\nRound " + roundCounter + "\n"
                + "Jumping order:");
        int counter = 1;
        for (SkiJumper elements : skiJumpers) {
            System.out.println("  " + counter + ". " + elements);
            counter++;
        }

        System.out.println("Results of round "+roundCounter);

        for (SkiJumper elements : skiJumpers) {
            int distance = randomLength();
            int[] judgeVotes = judgeVotes();
            elements.addLength(distance);
            elements.addPoints(distance);
            Arrays.sort(judgeVotes);

            // Only the middle 3 judge votes are taken into account.

            for (int i = 1; i < 4; i++) {
                elements.addPoints(judgeVotes[i]);
            }
            System.out.println("  "+elements.getName()+"\n"
                    + "    length: "+distance+"\n"
                            + "    judge votes: "+Arrays.toString(judgeVotes));

        }
    }

    public int[] judgeVotes() {
        int[] judgeVotes = new int[5];
        for (int i = 0; i < 5; i++) {
            judgeVotes[i] = randomVote();
        }
        return judgeVotes;
    }

    public int randomLength() {
        return random.nextInt(61) + 60;
    }

    public int randomVote() {
        return random.nextInt(11) + 10;
    }
}
