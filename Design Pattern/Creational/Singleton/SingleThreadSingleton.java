
// This only works in Single Threaded environment
public class SingleThreadSingleton {
    
    private static SingleThreadSingleton instance;
    public String value;
    private SingleThreadSingleton(String value) {
        this.value = value;
    }

    // Make this block synchronized for mutual exclusion
    public static SingleThreadSingleton getInstance(String value) {
        if(instance == null) {
            System.out.println("Creating an instance of Singleton class");
            instance = new SingleThreadSingleton(value);
        }
        return instance;
    }
}
