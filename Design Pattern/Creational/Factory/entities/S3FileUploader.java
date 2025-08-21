package entities;

public class S3FileUploader implements FileUploader{
    
    @Override
    public void upload(Object document, String fileName, String filePath) {
        // Logic to upload the document to S3
        System.out.println("Uploading " + fileName + " to S3 at " + filePath);
    }
}
