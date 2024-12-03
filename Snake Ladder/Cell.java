public class Cell {
    int id;
    Jump jump = null;

    public Cell(int id) {
        this.id = id;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }

    public Jump getJump() {
        return this.jump;
    }
}
