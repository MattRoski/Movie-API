package dev.mattroski.movieapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){//whatever we get as the request body we would like to convert it to a map key,value: String
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
