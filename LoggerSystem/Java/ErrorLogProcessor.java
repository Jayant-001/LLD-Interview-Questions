public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int level, String message) {

        if(level == ERROR) {
            System.out.println("ERROR: " + message);
        }
        else {
            super.log(level, message);
        }
    }
}
