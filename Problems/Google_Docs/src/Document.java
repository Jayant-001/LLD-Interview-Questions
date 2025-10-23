package Problems.Google_Docs.src;

import java.util.ArrayList;
import java.util.List;

import Problems.Google_Docs.src.elements.DocumentElement;

// Responsible for maintaining the list of document elements and rendering them
public class Document {
    List<DocumentElement> elements;
    public Document() {
        elements = new ArrayList<>();
    }

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public void removeElement(DocumentElement element) {
        elements.remove(element);
    }

    public String render() {
        String s = "";
        s += "-----------------------------------------------\n";
        for(DocumentElement element : elements) {
            s += element.render();
        }
        s += "\n-----------------------------------------------";

        return s;
    }


}
