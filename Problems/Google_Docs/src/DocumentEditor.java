package Problems.Google_Docs.src;

import Problems.Google_Docs.src.elements.ImageElement;
import Problems.Google_Docs.src.elements.NewLineElement;
import Problems.Google_Docs.src.elements.TabSpaceElement;
import Problems.Google_Docs.src.elements.TextElement;
import Problems.Google_Docs.src.persistance.Persistance;

public class DocumentEditor {

    Document document;
    Persistance persistance;

    public DocumentEditor(Document document, Persistance persistance) {
        this.document = document;
        this.persistance = persistance;
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addNewLine() {
        document.addElement(new NewLineElement());
    }
    
    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    public String render() {
        return document.render();
    }

    public void save() {
        persistance.save(render());
    }

    public void print() {
        System.out.println(render());
    }
    
}
