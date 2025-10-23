package Problems.Google_Docs.src.elements;

public class TextElement extends DocumentElement{
    String text;
    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return "Text: " + text;
    }
}
