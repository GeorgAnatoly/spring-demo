package springfive.cms.models;

import lombok.Data;

import java.util.Set;

@Data
public class News {
    private String id, title, content;
    private User author;
    private Set<User> mandatoryReviewers;
    private Set<Review> reviewers;
    private Set<Category> categories;
    private Set<Tag> tags;

    public Review review(String userId, String status) {
        final var review = new Review(userId, status);

        reviewers.add(review);

        return review;
    }

    public Boolean revised() {
        return mandatoryReviewers.stream().allMatch(user ->
                reviewers.stream().anyMatch(review -> user.getId().equals(review.getUserId()) &&
                        "approved".equals(review.getStatus())));
    }
}
