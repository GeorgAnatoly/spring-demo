package springfive.cms.service;

import org.jetbrains.annotations.Contract;
import org.springframework.stereotype.Service;
import springfive.cms.models.Category;
import springfive.cms.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;


    @Contract(pure = true)
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    // FIXME bad call to Optional.get()
    public void delete(String id) {
        final var category = categoryRepository.findOne(id).get();

        categoryRepository.delete(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // FIXME bad get() call on optional - not sure how to describe return/get if present
    public Category findOne(String id) {
        return categoryRepository.findOne(id).get();
    }
}
