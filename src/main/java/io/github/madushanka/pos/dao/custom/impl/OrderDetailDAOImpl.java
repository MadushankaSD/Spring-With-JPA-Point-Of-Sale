package io.github.madushanka.pos.dao.custom.impl;


import io.github.madushanka.pos.dao.CrudDAOImpl;
import io.github.madushanka.pos.dao.custom.OrderDetailDAO;
import io.github.madushanka.pos.entity.OrderDetail;
import io.github.madushanka.pos.entity.OrderDetailPK;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class OrderDetailDAOImpl extends CrudDAOImpl<OrderDetail, OrderDetailPK> implements OrderDetailDAO {

    @Override
    public boolean existsByItemCode(String itemCode) {
        NativeQuery query = (NativeQuery) entityManager.createNativeQuery("SELECT * FROM OrderDetail WHERE Item_id=?").setParameter(1, itemCode);
        return query.getResultList().isEmpty()?false:true;
    }
}
