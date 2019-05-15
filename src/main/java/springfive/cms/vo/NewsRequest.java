package springfive.cms.vo;

import lombok.Data;
import springfive.cms.models.Category;
import springfive.cms.models.Tag;

import java.util.Set;

@Data
public class NewsRequest {
    private String title, content;
    private Set<Category> categories;
    private Set<Tag> tags;
}
