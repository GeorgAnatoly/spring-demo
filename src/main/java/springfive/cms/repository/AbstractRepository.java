package springfive.cms.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T> {
    private final List<T> elements = new ArrayList<>();

    // TODO create the delete method - right now uses iterator hasNext()/while loop - think there must be a better way
    public void delete(T entity) {
        elements.forEach();
    }
}
