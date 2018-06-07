
import java.util.ArrayList;

public class SkiJumper implements Comparable<SkiJumper> {

    private final String name;
    private final ArrayList<Integer> jumpLengths;
    private int totalPoints;

    public SkiJumper(String name) {
        this.name = name;
        jumpLengths = new ArrayList<Integer>();
        totalPoints = 0;
    }

    public String getName() {
        return name;
    }
    
    public int getPoints(){
        return totalPoints;
    }

    public void addPoints(int points) {
        totalPoints += points;
    }

    public void addLength(int length) {
        jumpLengths.add(length);
    }

    public String printLengths() {
        String lengths = "jump lengths: ";
        for (int i = 0; i < jumpLengths.size(); i++) {
            if (i == jumpLengths.size() - 1) {
                lengths += jumpLengths.get(i) + " m";
            } else {
                lengths += jumpLengths.get(i) + " m, ";
            }
        }
        return lengths;
    }

    @Override
    public String toString() {
        return name + " (" + totalPoints + " points)";
    }

    @Override
    public int compareTo(SkiJumper other) {
        // We want to put SkiJumpers with the least points first when sorting a list with Collections.
        if (this.getPoints() > other.getPoints()){
            return 1;
        }
        else if (this.getPoints() == other.getPoints()){
            return 0;
        }
        else {
            return -1;
        }
    }
}
