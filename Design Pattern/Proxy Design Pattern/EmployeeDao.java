public interface EmployeeDao {

    void create(String client, EmployeeDo employee) throws Exception;
    void update(String client, EmployeeDo employee) throws Exception;
    EmployeeDo get(String client, String employeeName) throws Exception;

}
