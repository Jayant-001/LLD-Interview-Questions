package Problems.Google_Docs.src;

import Problems.Google_Docs.src.persistance.Persistance;
import Problems.Google_Docs.src.persistance.SaveToFile;

public class Main {

    public static void main(String []args) {

        Document document = new Document();
        Persistance filePersistance = new SaveToFile();

        DocumentEditor editor = new DocumentEditor(document, filePersistance);
        
        editor.addText("Hello world");
        editor.addNewLine();
        editor.addImage("path/to/image1.png");
        editor.addNewLine();
        editor.addText("Sample text data");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addImage("path/to/image2.png");

        editor.print();
        editor.save();
    }
}
