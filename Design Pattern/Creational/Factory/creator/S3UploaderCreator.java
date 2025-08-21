package creator;

import entities.FileUploader;
import entities.S3FileUploader;

public class S3UploaderCreator implements UploaderCreator{

    @Override
    public FileUploader createFileUploader() {
        return new S3FileUploader();
    }
}
