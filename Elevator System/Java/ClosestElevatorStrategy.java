import java.util.List;

public class ClosestElevatorStrategy implements ElevatorSelectionStrategy {

    @Override
    public Elevator selectElevator(List<Elevator> elevators, Request request) {
        Elevator elevator = null;
        int minDistance = Integer.MAX_VALUE;

        for(Elevator el : elevators) {
            int distance = Math.abs(request.currentFloor - el.currentFloor);
            if(distance < minDistance) {
                minDistance = distance;
                elevator = el;
            }
        }
        return elevator;
    }
}
