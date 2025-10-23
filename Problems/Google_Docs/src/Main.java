package Problems.Google_Docs.src;

public class Main {

    public static void main(String []args) {

        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello world");
        editor.addImage("path/to/image1.png");
        editor.addText("Sample text data");

        System.out.println(editor.renderDocument());
        editor.printDocument();
    }
}
