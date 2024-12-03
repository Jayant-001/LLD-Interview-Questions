public class EmployeeDaoImpl implements  EmployeeDao {
    @Override
    public void create(String client, EmployeeDo employee) {
        System.out.println("Creating an employee with name " + employee.name);
    }

    @Override
    public void update(String client, EmployeeDo employee) {
        System.out.println("Updating an employee with name " + employee.name);
    }

    @Override
    public EmployeeDo get(String client, String employeeName) {
        System.out.println("Returning an Employee with name " + employeeName);
        return new EmployeeDo(employeeName);
    }
}
