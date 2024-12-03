public class Main {
    public static void main(String[] args) {

        try {
            EmployeeDao employeeDao = new EmployeeDaoProxy();

            employeeDao.create("ADMIN", new EmployeeDo("Akash"));
            employeeDao.update("ADMIN", new EmployeeDo("Akash"));
            employeeDao.get("ADMIN", "aman");

            employeeDao.get("DEVELOPER", "aman");
            employeeDao.create("USER", new EmployeeDo("Akash"));
            employeeDao.update("USER", new EmployeeDo("Akash"));
            employeeDao.get("USER", "aman");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}