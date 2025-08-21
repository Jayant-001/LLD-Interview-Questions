package creator;

import entities.FileUploader;
import entities.GCPFileUploader;

public class GcpUloaderCreator implements UploaderCreator {

    @Override
    public FileUploader createFileUploader() {
        return new GCPFileUploader();
    }
}
