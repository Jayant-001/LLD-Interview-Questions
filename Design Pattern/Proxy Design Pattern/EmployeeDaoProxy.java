import java.util.Objects;

public class EmployeeDaoProxy implements EmployeeDao {

    EmployeeDao employeeDao;

    public EmployeeDaoProxy() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDo employee) throws Exception {

        // Only ADMIN can create an employee
        if(Objects.equals(client, "ADMIN")) {
            employeeDao.create(client, employee);
            return;
        }
        throw new Exception(client + " is not authorized to create an employee");
    }

    @Override
    public void update(String client, EmployeeDo employee) throws Exception {
        // Only ADMIN can update am employee
        if(Objects.equals(client, "ADMIN")) {
            employeeDao.update(client, employee);
            return;
        }
        throw new Exception(client + " is not authorized to update an employee");
    }

    @Override
    public EmployeeDo get(String client, String employeeName) throws Exception {
        // ADMIN and USER can perform get operation
        if(Objects.equals(client, "ADMIN") || Objects.equals(client, "USER")) {
            return employeeDao.get(client, employeeName);
        }

        throw new Exception(client + " is not authorized to get an employee");
    }
}
