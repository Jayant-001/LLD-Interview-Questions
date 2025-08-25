package src;

import java.util.ArrayList;
import java.util.List;

public abstract class Document implements Cloneable {
    private String title;
    private String content;
    private List<String> attachments;

    public Document() {
        this.attachments = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    @Override
    public Document clone() throws CloneNotSupportedException {
        Document clonedDoc = (Document) super.clone();
        clonedDoc.attachments = new ArrayList<>(this.attachments);
        return clonedDoc;
    }

    @Override
    public String toString() {
        String attachmentsList = String.join(", ", attachments);
        return "Document: [title=" + title + ", content=" + content + ", attachments= " + attachmentsList + "]";
    }

    public abstract void display();
}
