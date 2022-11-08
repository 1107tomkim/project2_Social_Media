package dev.jsonmusk.daotests;

import dev.jsonmusk.entities.User;
import dev.jsonmusk.repositories.UserDAO;
import dev.jsonmusk.repositories.UserDAOPostgres;
import org.junit.jupiter.api.*;

import java.util.Random;

import java.util.List;

public class UserDAOTests {

    static UserDAO userDAO = new UserDAOPostgres();

//    @BeforeAll
//    static void setup() {
//        try (Connection connection = ConnectionFactory.getConnection()){
//            String sql = "DROP TABLE IF EXISTS employees";
//            Statement statement = connection.createStatement();
//            statement.execute(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try (Connection connection = ConnectionFactory.getConnection()){
//            String sql = "CREATE TABLE employees(\n" +
//                    "\t id serial PRIMARY KEY,\n" +
//                    "\t username varchar(40) NOT NULL UNIQUE,\n" +
//                    "\t password varchar(40) NOT NULL,\n" +
//                    "\t isManager bool,\n" +
//                    "\t firstname varchar(40),\n" +
//                    "\t lastname varchar(40),\n" +
//                    "\t email varchar(40),\n" +
//                    "\t photo bytea);";
//
//            Statement statement = connection.createStatement();
//            statement.execute(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    // this is kabob case, tests are written in kabob case
    @Test
    @Order(1)
    void create_employee_test(){
        String randomName = "";
        Random random = new Random();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < 10; i++) {
            int randNum = random.nextInt(26);
            randomName += alphabet[randNum];
        }
        User newEmployee = new User(0,randomName,"password",true);
        User savedEmployee = userDAO.createEmployee(newEmployee);
        System.out.println(savedEmployee);

        Assertions.assertNotEquals(0,savedEmployee.getId());
    }
    @Test
    @Order(2)
    void get_employee_by_id_test(){
        User gottenEmployee = userDAO.getEmployeeById(1);
        System.out.println(gottenEmployee);
        Assertions.assertNotNull(gottenEmployee);
    }
    @Test
    @Order(3)
    void get_employee_by_username_test(){
        User employee = userDAO.getEmployeeById(1);
        System.out.println(employee);

        String username = employee.getUsername();
        int id = employee.getId();

        User gottenEmployee = userDAO.getEmployeeByUsername(username);
        Assertions.assertEquals(id, gottenEmployee.getId());
    }
    @Test
    @Order(4)
    void get_all_employees_test(){

        List<User> allEmployees = userDAO.getAllEmployees();
        for (User e : allEmployees) {
            System.out.println(e.toString());
        }
        Assertions.assertTrue((allEmployees.size()> 0));
    }
    @Test
    @Order(5)
    void update_employee_test(){
        User employee = userDAO.getEmployeeById(1);
        User employee2 = new User(employee.getId(),employee.getUsername(),"newPassword",employee.isManager());
        userDAO.updateEmployee(employee2);
        User updatedEmployee = userDAO.getEmployeeById(1);
        Assertions.assertEquals("newPassword",updatedEmployee.getPassword());
    }
    @Test
    @Order(6)
    void change_role_test() {
        User employee = userDAO.getEmployeeByUsername("SomeGuy");
        boolean firstrole = employee.isManager();

        System.out.println(employee);

        employee = userDAO.changeEmployeeRole(employee, !firstrole);

        System.out.println(employee);
        Assertions.assertNotEquals(firstrole, employee.isManager());

    }
    @Test
    @Order(7)
    void append_photo_test() {
        User employee = userDAO.getEmployeeByUsername("SomeGuy");
        System.out.println(employee);
        byte[] bytes = new byte[50];
        userDAO.appendPhotoToEmployee(employee, bytes);
        User employee2 = userDAO.getEmployeeByUsername("SomeGuy");
        System.out.println(employee2);
        byte[] bytes2 =  employee2.getPhoto();
        Assertions.assertEquals(50, bytes2.length);
    }
    @Test
    @Order(8)
    void delete_employee_by_id_test(){
        boolean result = userDAO.deleteEmployeeById(8);
        Assertions.assertTrue(result);
    }

//    @AfterAll
//    static void teardown(){
//        try (Connection connection = ConnectionFactory.getConnection()){
//            String sql = "DROP TABLE IF EXISTS employees";
//            Statement statement = connection.createStatement();
//            statement.execute(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
