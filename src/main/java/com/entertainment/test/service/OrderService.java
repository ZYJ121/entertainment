package com.entertainment.test.service;

import com.entertainment.test.controller.order.OrderCell;
import com.entertainment.test.entity.OrderItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private EntityManager entityManager;


    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    public List<OrderCell> orderDetail(int orderId)  {
String sqlString="select s.name AS spec_name,s.bottom_price AS bottom_price,s.paint_price AS paint_price,s.sum_price AS sum_price,\n" +
                "o.id ,o.cust_id,c.name AS cust_name,o.amount,o.code,o.install,o.urgent,o.state,o.describe,o.order_time ,o.finish_time,o.create_time,o.update_time FROM order_item o \n" +
                "LEFT JOIN order_spec o_s ON o.id=o_s.order_id \n" +
                "LEFT JOIN specifications s ON o_s.spec_id=s.id\n" +
                "LEFT JOIN customer c ON o.cust_id=c.id\n" +
                (orderId>0?"WHERE o.id=:orderId":"");
        System.out.print(sqlString);

        Query query = entityManager.createNativeQuery(sqlString,OrderCell.class);
        if(orderId>0){
            query.setParameter("orderId",orderId);
        }
        List<OrderCell> orderCellList = query.getResultList();
//        List<OrderCell> orderCellList = query.getResultList();

        return orderCellList;
    }


}
