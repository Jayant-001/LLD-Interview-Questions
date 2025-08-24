import app.Application;
import factories.GUIFactory;
import factories.MacFactory;
import factories.WinFactory;

public class Main {

    public static void main(String[] args) {
        
        GUIFactory winFactory = new WinFactory();
        
        Application app = new Application(winFactory);
        app.createUI();
        app.paint();
        
        
        GUIFactory macFactory = new MacFactory();
        app = new Application(macFactory);
        app.createUI();
        app.paint();
    }
}
