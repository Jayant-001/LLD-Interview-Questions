public class Main {
    public static void main(String[] args) {

        LogProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logger.log(LogProcessor.ERROR, "THis is error message");
        logger.log(LogProcessor.INFO, "THis is info message");
        logger.log(LogProcessor.DEBUG, "THis is debug message");
    }
}