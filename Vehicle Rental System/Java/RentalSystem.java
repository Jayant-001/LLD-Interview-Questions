import models.User;

import java.util.List;

public class RentalSystem {

    public List<User> users;
    public List<Store> stores;

    public RentalSystem(List<User> users, List<Store> stores) {
        this.stores = stores;
        this.users = users;
    }

    public List<User> getUsers () {
        return this.users;
    }

    public Store getStore(Location location) {

        // Stores filter logic goes here

        return this.stores.get(0);
    }
}
