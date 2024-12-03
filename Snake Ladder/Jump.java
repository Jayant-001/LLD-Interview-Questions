public class Jump {
    int start, end;

    public Jump(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Jump : " + start + " => " + end;
    }
}
