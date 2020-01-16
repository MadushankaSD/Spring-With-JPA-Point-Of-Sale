package io.github.madushanka.pos.dao;

import javax.persistence.EntityManager;

public interface SuperDAO {
    void setEntityManager(EntityManager entityManager);

}
