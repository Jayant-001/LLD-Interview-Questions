import java.util.concurrent.ThreadLocalRandom;

public class Board {

    int size;
    Cell[][] cells;

    Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        initializeBoard();

        createSnakesLadders(5, 5);
    }

    void initializeBoard() {

        int count = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                Cell cell = new Cell(count++);
                cells[i][j] = cell;
            }
        }
    }

    void createSnakesLadders(int snakesCount, int laddersCount) {

        while(snakesCount > 0 || laddersCount > 0) {

            int startPoint = ThreadLocalRandom.current().nextInt(0,size*size);
            int endPoint = ThreadLocalRandom.current().nextInt(0,size*size);

            Cell cell = getCell(startPoint);

            // Add Ladder
            if(laddersCount > 0 && cell.jump == null && startPoint < endPoint) {
                cell.setJump(new Jump(startPoint, endPoint));
                laddersCount--;
            }
            // Add Snake
            if(snakesCount > 0 && cell.jump == null && endPoint > startPoint) {
                cell.setJump(new Jump(startPoint, endPoint));
                snakesCount--;
            }
        }
    }

    Cell getCell(int position) {
        int row = position / size;
        int col = position % size;
        return cells[row][col];
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.println("Cell: " + cells[i][j].id + " " +
                        (cells[i][j].jump != null ? cells[i][j].jump.toString() : "NULL"));
            }
        }
        System.out.println();
    }
}
