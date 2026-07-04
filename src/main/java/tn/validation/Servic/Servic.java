package tn.validation.Servic;

import java.util.List;

public interface Servic <T>{
    T add(T entity);

    T retrieve(Long id);
    List<T> retrieveAll();

    void remove(Long id);
}
