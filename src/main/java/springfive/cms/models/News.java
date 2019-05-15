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
}
