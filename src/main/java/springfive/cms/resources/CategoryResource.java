package springfive.cms.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfive.cms.models.Category;
import springfive.cms.vo.CategoryRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@Api(tags = "category")
public class CategoryResource {

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find category", notes = "Find the Category by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    public ResponseEntity<Category> findOne(@PathVariable String id) {
        return ResponseEntity.ok(new Category());
    }

    @GetMapping
    @ApiOperation(value = "List categories", notes = "List all categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categories found"),
            @ApiResponse(code = 404, message = "Categories not found")
    })
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new Category(), new Category()));
    }

    @PostMapping
    @ApiOperation(value = "Create category", notes = "Creates a new category")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Category created"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Category> newCategory(CategoryRequest categoryRequest) {
        return new ResponseEntity<>(new Category(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove category", notes = "Remove a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category removed"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    public void removeCategory(@PathVariable String id) {
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update category", notes = "Updates a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category updated"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 400, message = "Invalid request")
    })
    public ResponseEntity<Category> updateCategory(@PathVariable String id,
                                                   CategoryRequest categoryRequest) {
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }
}