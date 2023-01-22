package dev.mattroski.movieapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {//first look for the movie with the imdbId, then create new review and associate that review with the found movie
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class) //using a template to perform an update call on the movie class.
                .matching(Criteria.where("imdbId").is(imdbId)) //.matching to find which movie we are updating, updating movie that matches the imdbId in db and imdbId from user
                .apply(new Update().push("reviewIds").value(review)) //then apply this update, create a new update definition which does the job making the change in the db
                .first();                                                            //then push to the array of reviewIds in a movie object

        return review;
    }
}

