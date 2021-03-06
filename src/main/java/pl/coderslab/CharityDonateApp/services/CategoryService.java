package pl.coderslab.CharityDonateApp.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.CharityDonateApp.entities.Category;
import pl.coderslab.CharityDonateApp.repositories.CategoryRepository;

import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        categories.sort(Comparator.comparing(Category::getId));
        return categories;

    }
}
