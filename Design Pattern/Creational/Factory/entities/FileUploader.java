package entities;

// Common interface for all buttons
public interface FileUploader {
    void upload(Object document, String fileName, String filePath);
}