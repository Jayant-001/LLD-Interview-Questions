public class Singleton {
    
    private static Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            System.out.println("Creating an instance of Singleton class");
            instance = new Singleton();
        }
        return instance;
    }
}
