package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.Comment;
import dev.jsonmusk.entities.Post;
import dev.jsonmusk.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAOPostgres implements PostDAO {

    @Override
    public Post createPost(Post post) {
        // insert this new post into db
        try (Connection connection = ConnectionFactory.getConnection()) {
            Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
            String sql = "insert into posts values(default, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, post.getPostText());
            ps.setInt(2, post.getUserId());
            ps.setTimestamp(3, newTimestamp);
            ps.setBytes(4, post.getPostPhoto());
            // Temporarily set like and dislike values as 0 so we do not need to mess with the
            // object for the time being.
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            post.setPostId(rs.getInt("post_id"));
            return post;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Post getPostById(int id) {
        // select the post from db with corresponding id
        return null;
    }



    @Override
    public Post updatePost(Post post) {
        // update the post in db with corresponding id
        return null;
    }

    @Override
    public boolean deletePostById(int id) {
        // delete post from db
        return false;
    }
}
