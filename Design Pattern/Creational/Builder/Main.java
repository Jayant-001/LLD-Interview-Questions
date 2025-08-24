import builder.ComputerBuilder;
import builder.Director;
import entities.Computer;

public class Main {

    public static void main(String[] args) {

        ComputerBuilder builder = new ComputerBuilder("Intel i9", "32 GB");

        Director director = new Director();

        Computer gamingComputer = director.buildGamingComputer(builder);
        System.out.println("Gaming Computer: " + gamingComputer);

        ComputerBuilder builder2 = new ComputerBuilder("Intel i5", "16 GB");
        
        Computer officeComputer = director.buildOfficeComputer(builder2);
        System.out.println("Office Computer: " + officeComputer);

    }
}