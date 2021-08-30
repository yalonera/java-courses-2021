package by.part8.internal.example5.repository;

import by.part8.internal.example5.AbstractEntity;

public interface Repository<T extends AbstractEntity> {

  void save(T entity);
}
