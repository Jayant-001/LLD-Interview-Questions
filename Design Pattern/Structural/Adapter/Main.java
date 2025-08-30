import service.*;

public class Main {
    public static void main(String[] args) {

        IService service = new Service();
        ClientInterface adapter = new Adapter(service);
        System.out.println(adapter.getRealTimeData());

        IService advanceService = new AdvanceService();
        ClientInterface advanceAdapter = new Adapter(advanceService);
        System.out.println(advanceAdapter.getRealTimeData());
    }
}