
public class Main {
    public static void main(String[] args) {

        // This is where it fails; if we run it in multi-threaded environment

        Runnable task1 = () -> {
            SingleThreadSingleton s1 = SingleThreadSingleton.getInstance("Foo");
            System.out.println(s1.value);
        };
        
        Runnable task2 = () -> {
            SingleThreadSingleton s2 = SingleThreadSingleton.getInstance("Bar");
            System.out.println(s2.value);
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        System.out.println("Finish");
    }
}