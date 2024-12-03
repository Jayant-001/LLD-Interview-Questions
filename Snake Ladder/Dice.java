import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount = 1;
    int min = 1;
    int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public Dice() {}

    public int rollDice() {
        int totalValue = 0;
        for(int i = 0; i < diceCount; i++) {
            totalValue += ThreadLocalRandom.current().nextInt(min,max+1);
        }
        return totalValue;
    }
}
