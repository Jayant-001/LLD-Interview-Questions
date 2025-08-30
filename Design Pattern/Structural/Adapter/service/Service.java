package service;

public class Service implements IService {
    
    @Override
    public String getData() {
        return "Data from the original service";
    }
}
