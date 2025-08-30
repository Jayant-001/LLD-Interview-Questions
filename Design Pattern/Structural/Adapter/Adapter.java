import service.IService;

class Adapter implements ClientInterface {

    // The adapter holds a reference to ANY class that implements IService
    private final IService service;

    // The dependency is "injected" through the constructor
    public Adapter(IService service) {
        this.service = service;
    }

    @Override
    public String getRealTimeData() {
        return service.getData() + " in real-time";
    }

}