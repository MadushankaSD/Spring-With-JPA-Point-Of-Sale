package io.github.madushanka.pos.dao;



import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {

    public abstract List<T> findAll() ;

    public abstract T find(ID id);

    public abstract void save(T entity);

    public abstract void update(T entity);

    public abstract void delete(ID id);

}
