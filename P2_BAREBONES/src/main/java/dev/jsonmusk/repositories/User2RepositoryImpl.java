package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.User2;
import dev.jsonmusk.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class User2RepositoryImpl implements User2Repository{



    /// this is where we need to connect to the database.
    // havent set up yet, right now stored in memory as a Array List
    private List<User2> users;
//
//    public User2RepositoryImpl() {
//        this.users = new ArrayList<>();
//    }

    @Override
    public User2 signup(String email, String password) {
        String userId = UUID.randomUUID().toString();
        User2 user = new User2(userId, email, password);
        //users.add(user);

        try(Connection connection = ConnectionFactory.getConnection()){
            // Here is the unfun thing about JDBC, you have to write SQL statements in Java
            // I recommend putting in comments the SQL command you are trying to execute
            //INSERT INTO employee VALUES (DEFAULT, 'fname', 'lname', 'email', 'passwd', isAdmin);
            String sql = "insert into users values(? , ? , ?)";
            // The only thing in the sql String that isnt "just a string" are the question marks
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // We use Return generated Keys, to get back the primary key of our newly created book
            //Parameters START at 1, they are not indexed at 0
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);


            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();//this returns the id that was created
            resultSet.next();//you need to move the cursor to the first valid record, or you will get a null response
            //int generatedKey = resultSet.getInt("id");
            //employee.setId(generatedKey);


            System.out.println(user);
            return user;
        }
        catch (SQLException e){

            e.printStackTrace();
            //throw new UserTakenException("this si the usertakenex in DAOpostgres");

        }
       return null;
    }
        //return user;



    @Override
    public Optional<User2> findByEmail(String email) {
        Predicate<User2> query = user -> user.getEmail().equalsIgnoreCase(email);
        return users.stream().filter(query).findFirst();
    }
//    private List<User2> users;
//
//    public User2RepositoryImpl() {
//        this.users = new ArrayList<>();
//    }
//
//    @Override
//    public User2 signup(String email, String password) {
//        String userId = UUID.randomUUID().toString();
//        User2 user = new User2(userId, email, password);
//        users.add(user);
//        return user;
//
//    }
//
//    @Override
//    public Optional<User2> findByEmail(String email) {
//        Predicate<User2> query = user -> user.getEmail().equalsIgnoreCase(email);
//        return users.stream().filter(query).findFirst();
//    }

}
