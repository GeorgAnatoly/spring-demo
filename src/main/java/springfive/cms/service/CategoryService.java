package springfive.cms.service;

import org.springframework.stereotype.Service;
import springfive.cms.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
}
