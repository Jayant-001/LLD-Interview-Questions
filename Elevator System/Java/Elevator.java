import java.util.PriorityQueue;

public class Elevator {
    int currentFloor;
    Direction direction;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        direction = Direction.IDLE;

        // use default, which is a min heap
        upQueue = new PriorityQueue<>((a, b) -> a.desiredFloor - b.desiredFloor);

        // use a max heap
        downQueue = new PriorityQueue<>((a, b) -> b.desiredFloor - a.desiredFloor);
    }

    public void sendUpRequest(Request upRequest) {
        // If the request is sent from outside the elevator,
        // we need to stop at the current floor of the requester
        // to pick him up, and then go the desired floor.
        if(upRequest.location == Location.OUTSIDE_ELEVATOR) {
            // Go pick up the requester who is outside the elevator
            upQueue.offer(
                    new Request(upRequest.currentFloor, upRequest.currentFloor,
                            Direction.UP, Location.OUTSIDE_ELEVATOR)
            );
            System.out.println("Append up request going to floor " + upRequest.currentFloor + ".");
        }

        // Go to the desired floor
        upQueue.offer(upRequest);
        System.out.println("Append up request going to floor " + upRequest.desiredFloor + ".");
    }

    public void sendDownRequest(Request downRequest) {
        // Similar to the sendUpRequest logic
        if(downRequest.location == Location.OUTSIDE_ELEVATOR) {
            downQueue.offer(new Request(downRequest.currentFloor, downRequest.currentFloor,
                    Direction.DOWN, Location.OUTSIDE_ELEVATOR));

            System.out.println("Append down request going to floor " + downRequest.currentFloor + ".");
        }

        // Go to the desired floor
        downQueue.offer(downRequest);
        System.out.println("Append down request going to floor " + downRequest.desiredFloor + ".");
    }

    public void run() {

        while(!upQueue.isEmpty() || !downQueue.isEmpty()) {
            // Process requests
            processRequests();
        }

        System.out.println("Finished all the requests");
        this.direction = Direction.IDLE;
    }

    public void processRequests() {

        if(this.direction == Direction.UP || this.direction == Direction.IDLE) {
            processUpRequests();
            processDownRequests();
        }
        else {
            processDownRequests();
            processUpRequests();
        }
    }

    public void processUpRequests() {
        while(!upQueue.isEmpty()) {
            Request request = upQueue.poll();
            // Communicate with hardware
            this.currentFloor = request.desiredFloor;
            System.out.println("Processing up requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if(!downQueue.isEmpty()) {
            this.direction = Direction.DOWN;
        }
        else this.direction = Direction.IDLE;
    }

    public void processDownRequests() {
        while(!downQueue.isEmpty()) {
            Request request = downQueue.poll();
            // Communicate with hardware
            this.currentFloor = request.desiredFloor;
            System.out.println("Processing down requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if(!upQueue.isEmpty()) {
            this.direction = Direction.UP;
        }
        else {
            this.direction = Direction.IDLE;
        }
    }
}
