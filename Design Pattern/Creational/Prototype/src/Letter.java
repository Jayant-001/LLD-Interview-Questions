package src;

public class Letter extends Document {

    private String recipient;

    public Letter() {
        setTitle("Generic Letter");
        setContent("Dear [Recipient],\\n" + //
                        "\\n" + //
                        "This is a template for a generic letter.");
        this.recipient = "N/A";
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
        setContent(getContent().replace("[Recipient]", recipient));
    }

    @Override
    public void display() {
        System.out.println("--- Letter ---");
        System.out.println("Title: " + getTitle());
        System.out.println("Recipient: " + getRecipient());
        System.out.println("Content: " + getContent());
        System.out.println("Attachments: " + getAttachments());
        System.out.println();
    }
    
}
