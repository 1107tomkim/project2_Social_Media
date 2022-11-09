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
    void create_user_test(){
        String randomName = "";
        Random random = new Random();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < 10; i++) {
            int randNum = random.nextInt(26);
            randomName += alphabet[randNum];
        }
        User newUser = new User(0,randomName,"password",true);
        User savedUser = userDAO.createUser(newUser);
        System.out.println(savedUser);

        Assertions.assertNotEquals(0,savedUser.getId());
    }
    @Test
    @Order(2)
    void get_user_by_id_test(){
        User gottenUser = userDAO.getUserById(1);
        System.out.println(gottenUser);
        Assertions.assertNotNull(gottenUser);
    }
    @Test
    @Order(3)
    void get_user_by_username_test(){
        User user = userDAO.getUserById(1);
        System.out.println(user);

        String username = user.getUsername();
        int id = user.getId();

        User gottenUser = userDAO.getUserByUsername(username);
        Assertions.assertEquals(id, gottenUser.getId());
    }
//    @Test
//    @Order(4)
//    void get_all_employees_test(){
//
//        List<User> allEmployees = userDAO.getAllEmployees();
//        for (User e : allEmployees) {
//            System.out.println(e.toString());
//        }
//        Assertions.assertTrue((allEmployees.size()> 0));
//    }
    @Test
    @Order(5)
    void update_user_test(){
        User user = userDAO.getUserById(1);
        User user2 = new User(user.getId(),user.getUsername(),"newPassword"; /*user.isManager()*/);
        userDAO.updateUser(user2);
        User updatedUser = userDAO.getUserById(1);
        Assertions.assertEquals("newPassword",updatedUser.getPassword());
    }
//    @Test
//    @Order(6)
//    void change_role_test() {
//        User employee = userDAO.getEmployeeByUsername("SomeGuy");
//        boolean firstrole = employee.isManager();
//
//        System.out.println(employee);
//
//        employee = userDAO.changeEmployeeRole(employee, !firstrole);
//
//        System.out.println(employee);
//        Assertions.assertNotEquals(firstrole, employee.isManager());

    }
    @Test
    @Order(7)
    void upload_photo_test() {
        User user = userDAO.getUserByUsername("SomeGuy");
        System.out.println(user);
        byte[] bytes = new byte[50];
        userDAO.uploadPhotoToUser(user, bytes);
        User user2 = userDAO.getUserByUsername("SomeGuy");
        System.out.println(user2);
        byte[] bytes2 =  user2.getPhoto();
        Assertions.assertEquals(50, bytes2.length);
    }
    @Test
    @Order(8)
    void delete_user_by_id_test(){
        boolean result = userDAO.deleteUserById(8);
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
