public class Main {
    public static void main(String[] args) {

        ElevatorSelectionStrategy selectionStrategy = new ClosestElevatorStrategy();

        Building building = new Building(selectionStrategy);


        Elevator elevator1 = new Elevator(1, 0);
        Elevator elevator2 = new Elevator(2, 3);
        Elevator elevator3 = new Elevator(3, 6);
        Elevator elevator4 = new Elevator(4, 9);

        building.addElevator(elevator1);
        building.addElevator(elevator2);
        building.addElevator(elevator3);
        building.addElevator(elevator4);


        Request upRequest1 = new Request(2, 2, Direction.UP, Location.OUTSIDE_ELEVATOR);
        Request upRequest2 = new Request(2, 3, Direction.UP, Location.INSIDE_ELEVATOR);

        Request downRequest1 = new Request(9, 9, Direction.DOWN, Location.OUTSIDE_ELEVATOR);
        Request downRequest2 = new Request(9, 2, Direction.DOWN, Location.INSIDE_ELEVATOR);
        Request downRequest3 = new Request(9, 4, Direction.DOWN, Location.INSIDE_ELEVATOR);

        building.sendRequest(upRequest1);
        building.sendRequest(upRequest2);

        building.sendRequest(downRequest1);
        building.sendRequest(downRequest2);
        building.sendRequest(downRequest3);


        building.run();
    }
}