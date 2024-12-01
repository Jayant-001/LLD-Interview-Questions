import java.util.PriorityQueue;

public class Elevator {
    int id;
    int currentFloor;
    Direction direction;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public Elevator(int id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
        setDirection(Direction.IDLE);

        // use default, which is a min heap
        upQueue = new PriorityQueue<>((a, b) -> a.desiredFloor - b.desiredFloor);

        // use a max heap
        downQueue = new PriorityQueue<>((a, b) -> b.desiredFloor - a.desiredFloor);
    }

    public void addRequest(Request request) {
        if(request.direction == Direction.UP)
            upQueue.offer(request);
        else
            downQueue.offer(request);
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
            System.out.println("Elevator: " + this.id + " Append up request going to floor " + upRequest.currentFloor + ".");
        }

        // Go to the desired floor
        upQueue.offer(upRequest);
        System.out.println("Elevator: " + this.id + " Append up request going to floor " + upRequest.desiredFloor + ".");
    }

    public void sendDownRequest(Request downRequest) {
        // Similar to the sendUpRequest logic
        if(downRequest.location == Location.OUTSIDE_ELEVATOR) {
            downQueue.offer(new Request(downRequest.currentFloor, downRequest.currentFloor,
                    Direction.DOWN, Location.OUTSIDE_ELEVATOR));

            System.out.println("Elevator: " + this.id + " Append down request going to floor " + downRequest.currentFloor + ".");
        }

        // Go to the desired floor
        downQueue.offer(downRequest);
        System.out.println("Elevator: " + this.id + " Append down request going to floor " + downRequest.desiredFloor + ".");
    }

    public void run() {

        while(!upQueue.isEmpty() || !downQueue.isEmpty()) {
            // Process requests
            processRequests();
        }

        System.out.println("Elevator: " + this.id + " Finished all the requests");
        setDirection(Direction.IDLE);
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

    public int getRequestQueueSize() {
        return this.upQueue.size() + this.downQueue.size();
    }

    public void processUpRequests() {
        while(!upQueue.isEmpty()) {
            Request request = upQueue.poll();
            // Communicate with hardware
            this.currentFloor = request.desiredFloor;
            System.out.println("Elevator: " + this.id + " Processing up requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if(!downQueue.isEmpty()) {
            setDirection(Direction.DOWN);
        }
        else setDirection(Direction.IDLE);
    }

    public void processDownRequests() {
        while(!downQueue.isEmpty()) {
            Request request = downQueue.poll();
            // Communicate with hardware
            this.currentFloor = request.desiredFloor;
            System.out.println("Elevator: " + this.id + " Processing down requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if(!upQueue.isEmpty()) {
            setDirection(Direction.UP);
        }
        else {
            setDirection(Direction.IDLE);
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
