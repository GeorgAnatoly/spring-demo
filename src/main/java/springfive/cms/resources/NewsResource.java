package springfive.cms.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfive.cms.models.News;
import springfive.cms.models.Review;
import springfive.cms.vo.NewsRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsResource {

    @GetMapping("/{id}")
    public ResponseEntity<News> findOne(@PathVariable String id) {
        return ResponseEntity.ok(new News());
    }

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }

    @PostMapping
    public ResponseEntity<News> newNews(NewsRequest newsRequest) {
        return new ResponseEntity<>(new News(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNews(@PathVariable String id) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable String id,
                                           NewsRequest newsRequest) {
        return new ResponseEntity<>(new News(), HttpStatus.OK);
    }

    @GetMapping("/{id}/review/{userId}")
    public ResponseEntity<Review> review(@PathVariable("id") String id,
                                         @PathVariable("userId") String userId) {
        return ResponseEntity.ok(new Review());
    }

    @GetMapping("/revised")
    public ResponseEntity<List<News>> revisedNews() {
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }
}
