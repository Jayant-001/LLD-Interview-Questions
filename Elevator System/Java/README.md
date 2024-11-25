
# Simple Elevator System

This is a simple design of an Elevator system where each Elevator will be handled separately


## Requirements
1. The elevator can go up and down in a real-world fashion.
2. Users can send requests to the elevator from both outside and inside the elevator.


### Behaviours
1. When elevator is going up or down, it will stop at all the floors that the users requested.
2. If the elevator received a request of going down while it is going up, the elevator will go to the highest floor in the current requests, and then go down.
3. Users can send requests at anytime.


## Assumptions
Now, in real life, the elevator will finish all up requests before starting down requests. Let’s assume that going up has more priority than going down, which means that when the elevator is in IDLE state, and has both up and down requests, it will execute up requests first.

I used a max heap to store all down requests and sort them by their desired floor. Similarly, a min heap to store all up requests and sort them by their desired floor.

When, the requester is outside of the elevator, the elevator needs to stop at the currentFloor of the requester, before going to the desiredFloor of the requester.

Here is the elevator class implementation after keeping all the above in mind.


## Time and Space Complexity
The main structure that we use in this design is heap. It has a time complexity of O(nlogn). The space complexity is O(n).