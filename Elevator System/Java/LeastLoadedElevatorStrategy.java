import java.util.List;

public class LeastLoadedElevatorStrategy implements ElevatorSelectionStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, Request request) {
        Elevator elevator = null;
        int minLoad = Integer.MAX_VALUE;
        for(Elevator el : elevators) {
            int load = el.getRequestQueueSize();
            if(load < minLoad) {
                minLoad = load;
                elevator = el;
            }
        }
        return elevator;
    }
}
