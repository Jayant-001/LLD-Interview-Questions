package builder;

import entities.Computer;

public class Director {
    
    public Computer buildGamingComputer(ComputerBuilder builder) {
        return builder
                .setGPU("NVIDIA RTX 3080")
                .setStorage("3TB SSD")
                .setHasWifi(true)
                .build();
    }

    public Computer buildOfficeComputer(ComputerBuilder builder) {
        return builder
                .setStorage("1TB HDD")
                .setHasWifi(false)
                .build();
    }
}
