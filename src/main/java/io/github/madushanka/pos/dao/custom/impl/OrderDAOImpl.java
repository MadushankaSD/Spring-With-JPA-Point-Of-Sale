package io.github.madushanka.pos.dao.custom.impl;


import io.github.madushanka.pos.dao.CrudDAOImpl;
import io.github.madushanka.pos.dao.custom.OrderDAO;
import io.github.madushanka.pos.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class OrderDAOImpl extends CrudDAOImpl<Order,Integer> implements OrderDAO {

    @Override
    public int getLastOrderId() {
        Object object = entityManager.createNativeQuery("SELECT id FROM `order` ORDER BY id DESC LIMIT 1").getSingleResult();
        return object==null?0: (int) object;
    }

    @Override
    public boolean existsByCustomerId(String customerId)  {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM `order` WHERE customerID=?");
        nativeQuery.setParameter(1, customerId);
        return nativeQuery.getResultList().isEmpty()?false:true;

    }
}
