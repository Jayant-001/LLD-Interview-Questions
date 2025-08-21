import creator.GcpUloaderCreator;
import creator.S3UploaderCreator;
import creator.UploaderCreator;
import entities.FileUploader;

public class Main {

    static void initialize() {
        // Create an S3 uploader
        UploaderCreator s3UploaderCreator = new S3UploaderCreator();
        FileUploader s3Uploader = s3UploaderCreator.createFileUploader();
        s3Uploader.upload(new Object(), "example.txt", "/path/to/s3");

        // Create a GCP uploader
        UploaderCreator gcpUploaderCreator = new GcpUloaderCreator();
        FileUploader gcpUploader = gcpUploaderCreator.createFileUploader();
        gcpUploader.upload(new Object(), "example.txt", "/path/to/gcp");
    }

    public static void main(String[] args) {

        initialize();
    }
}
