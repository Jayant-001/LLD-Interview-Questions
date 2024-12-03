import com.sun.javaws.IconUtil;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner;

    public Game() {
        board = new Board(10);
        dice = new Dice(3);
        players = new LinkedList<>();
        winner = null;

        addPlayers();
    }

    public void startGame() {

        while(winner == null) {
            Player player = getNextPlayer();
            System.out.println("Turn: " + player.name + ", current position is: " + player.currentPosition);

            int diceValue = dice.rollDice();
            while(player.currentPosition + diceValue >= board.size* board.size)
                diceValue = dice.rollDice();

            System.out.println("Rolled a dice with value: " + diceValue);

            int newPosition = player.currentPosition + diceValue;

            System.out.println("Player " + player.name + " is moving from " + player.currentPosition + " to " + newPosition);
            player.currentPosition = newPosition;

            Cell playersCell = board.getCell(player.currentPosition);
            if(playersCell.jump != null) {
                System.out.println("Player got a jump from " + playersCell.jump.start + " to " + playersCell.jump.end);
                player.currentPosition = playersCell.jump.end;
            }

            if(player.currentPosition == board.size*board.size-1) {
                winner = player;
            }
            System.out.println();
        }
    }

    Player getNextPlayer () {
        Player player = players.removeFirst();
        players.addLast(player);
        return player;
    }

    void addPlayers() {
        Player player1 = new Player("jayant");
        Player player2 = new Player("Aman");

        players.addLast(player1);
        players.addLast(player2);
    }
}
