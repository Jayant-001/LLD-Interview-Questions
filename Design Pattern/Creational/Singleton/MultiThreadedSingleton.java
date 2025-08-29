public class MultiThreadedSingleton {
    public static volatile MultiThreadedSingleton instance;
    public String value;
    private MultiThreadedSingleton(String value) {
        System.out.println("Creating an instance of singleton class");
        this.value = value;
    }

    public static MultiThreadedSingleton getInstance(String value) {
        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.
        
        // It may seem that having the `result` variable here is completely
        // pointless. There is, however, a very important caveat when
        // implementing double-checked locking in Java, which is solved by
        // introducing this local variable.

        MultiThreadedSingleton result = instance;
        if(result != null) return result;
        synchronized(MultiThreadedSingleton.class) {
            if(instance == null) instance = new MultiThreadedSingleton(value);
            return instance;
        }
    }
}
