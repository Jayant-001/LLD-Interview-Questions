import java.util.ArrayList;
import java.util.List;

public class Building {
    private final List<Elevator> elevators;
    private ElevatorSelectionStrategy selectionStrategy;

    public Building(ElevatorSelectionStrategy selectionStrategy) {
        elevators = new ArrayList<>();
        this.selectionStrategy = selectionStrategy;
    }

    public void setSelectionStrategy(ElevatorSelectionStrategy selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }

    public void addElevator(Elevator elevator) {
        this.elevators.add(elevator);
    }

    public void removeElevator(Elevator elevator) {
        this.elevators.remove(elevator);
    }

    public void sendRequest(Request request) {
        Elevator elevator = selectionStrategy.selectElevator(elevators, request);
        elevator.addRequest(request);
    }

    public void run() {
        for(Elevator elevator : elevators) {
            elevator.processRequests();
        }
    }
}
