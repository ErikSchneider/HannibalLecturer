package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

/**
 * Created by Erik on 7/1/16.
 */
@Controller
public class HannibalLecturerController {

    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    @PostConstruct
    public void init() throws SQLException {
        Server.createWebServer().start();
    }

    @RequestMapping(path="/lecturers", method= RequestMethod.POST)
    public String newLecturer (String name, String topic, String image) {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
        return "redirect:/";
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public String newReview (String author, String text, int lecturerId, boolean isGood) {
        Lecturer lecturer = lecturers.findOne(lecturerId);
        Review review = new Review(author, text, isGood, lecturer);
        reviews.save(review);
        return "redirect:/";
    }

}
