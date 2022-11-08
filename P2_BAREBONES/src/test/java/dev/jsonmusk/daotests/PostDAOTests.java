package dev.jsonmusk.daotests;

import dev.jsonmusk.entities.Post;
import dev.jsonmusk.repositories.PostDAO;
import dev.jsonmusk.repositories.PostDAOPostgres;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class PostDAOTests {

    static PostDAO postDAO = new PostDAOPostgres();

    @Test
    @Order(1)
    void create_request_test() {
        Post newRequest = new Post(0, 1, 250.00f, "chairs", Post.Type.OTHER);
        Post savedRequest = postDAO.createReimbursementRequest(newRequest);
        System.out.println(savedRequest);
        Assertions.assertNotNull(savedRequest);
        Assertions.assertEquals("chairs", savedRequest.getDescription());
    }

    @Test
    @Order(2)
    void get_request_by_id_test() {
        Post newReimbursement = new Post(0, 1, 250.00f, "chairs", Post.Type.OTHER);
        Post savedRequest = postDAO.createReimbursementRequest(newReimbursement);
        int id = savedRequest.getId();
        System.out.println(id);
        Post gottenRequest = postDAO.getReimbursementRequestById(id);
        System.out.println(gottenRequest.getId());
        Assertions.assertEquals(id, gottenRequest.getId());
    }

    @Test
    @Order(3)
    void get_all_reimbursement_requests_test(){
        List<Post> requestList =  postDAO.getAllReimbursementRequests();
        for (Post r : requestList)
            System.out.println(r);
        Assertions.assertTrue((requestList.size() > 1));
    }

    @Test
    @Order(4)
    void get_pending_reimbursement_requests_test(){
        List<Post> requestList =  postDAO.getAllPendingReimbursementRequests();
        for (Post r : requestList)
            System.out.println(r);
        Assertions.assertTrue((requestList.size() > 0));
    }

    @Test
    @Order(5)
    void get_requests_for_employee_test() {
        List<Post> requestList =  postDAO.getReimbursementRequestsForEmployee(1);
        for (Post r : requestList)
            System.out.println(r);
        Assertions.assertTrue((requestList.size() > 0));
    }

    @Test
    @Order(5)
    void get_requests_for_employee_of_type_test() {
        List<Post> requestList =  postDAO.getReimbursementRequestsForEmployeeOfType(1, Post.Type.OTHER);
        for (Post r : requestList)
            System.out.println(r);
        Assertions.assertTrue((requestList.size() > 0));
    }

    @Test
    @Order(5)
    void get_pending_requests_of_type_test() {
        List<Post> requestList =  postDAO.getPendingReimbursementRequestsOfType(Post.Type.OTHER);
        for (Post r : requestList)
            System.out.println(r);
        Assertions.assertTrue((requestList.size() > 0));
    }

    @Test
    @Order(6)
    void update_request_test() {
        String randomDescr = "";
        Random random = new Random();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < 10; i++) {
            int randNum = random.nextInt(26);
            randomDescr += alphabet[randNum];
        }

        Post request = postDAO.getReimbursementRequestById(1);
        request.setDescription(randomDescr);
        Post updatedRequest = postDAO.updateReimbursementRequest(request);
        System.out.println(updatedRequest);
        Assertions.assertEquals(randomDescr, updatedRequest.getDescription());
    }
    @Test
    @Order(7)
    void append_photo_test() {
        Post request = postDAO.getReimbursementRequestById(1);
        System.out.println(request);
        byte[] bytes = new byte[50];
        postDAO.appendReceiptToReimbursementRequest(request, bytes);
        Post request2 = postDAO.getReimbursementRequestById(1);
        System.out.println(request2);
        byte[] bytes2 =  request2.getReceiptImage();
        Assertions.assertEquals(50, bytes2.length);
    }
    @Test
    @Order(7)
    void delete_request_test(){
        boolean returnValue = postDAO.deleteReimbursementRequestById(2);
        System.out.println(returnValue);
        Assertions.assertTrue(returnValue);
    }

    @Test
    @Order(8)
    void change_request_status_test(){
        //create new
        Post newRequest = new Post(0, 1, 250.00f, "chairs", Post.Type.OTHER);
        Post savedRequest = postDAO.createReimbursementRequest(newRequest);
        System.out.println(savedRequest.getStatus().name());


        boolean returnValue = postDAO.changeReimbursementRequestStatus(savedRequest.getId(), Post.Status.APPROVED);

        Post changedRequest = postDAO.getReimbursementRequestById(savedRequest.getId());

        System.out.println((returnValue?"success":"fail") + " " + changedRequest.getStatus().name());
        Assertions.assertTrue(returnValue);
        Assertions.assertEquals(Post.Status.APPROVED, changedRequest.getStatus());
    }

}
