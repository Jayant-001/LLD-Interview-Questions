package builder;

import entities.Computer;

public class ComputerBuilder {
    // Required parameters
    private String CPU;
    private String RAM;

    // Optional parameters
    private String GPU;
    private String storage;
    private boolean hasWiFi;

    public ComputerBuilder(String CPU, String RAM) {
        this.CPU = CPU;
        this.RAM = RAM;
    }

    public ComputerBuilder setGPU(String GPU) {
        this.GPU = GPU;
        return this;
    }

    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setHasWifi(boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
        return this;
    }

    public Computer build() {
        return new Computer(CPU, RAM, GPU, storage, hasWiFi);
    }

    public ComputerBuilder reset(String CPU, String RAM){
        this.CPU = CPU;
        this.RAM = RAM;
        this.GPU = null;
        this.storage = null;
        this.hasWiFi = false;
        return this;
    }
}
