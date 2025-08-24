package entities;

public class Computer {
    // Required parameters
    private String CPU;
    private String RAM;

    // Optional parameters
    private String GPU;
    private String storage;
    private boolean hasWiFi;

    public Computer(String CPU, String RAM, String GPU, String storage, boolean hasWiFi) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.GPU = GPU;
        this.storage = storage;
        this.hasWiFi = hasWiFi;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", GPU='" + GPU + '\'' +
                ", storage='" + storage + '\'' +
                ", hasWiFi=" + hasWiFi +
                '}';
    }
}