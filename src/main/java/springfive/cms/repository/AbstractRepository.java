package springfive.cms.repository;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<T> {
    private final List<T> elements = new ArrayList<>();

    public void delete(T entity) {

        elements.removeIf(next -> next.equals(entity));
    }

    public List<T> findAll() {
        return elements;
    }

    public T save(T entity) {
        elements.add(entity);

        return entity;
    }

    // FIXME this use of Optional is poor
    public Optional<T> findOne(@NotNull String id) {
        return elements.stream().filter(id::equals).findFirst();
    }
}
