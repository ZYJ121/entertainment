package com.entertainment.test.controller.order;

import com.entertainment.test.base.RespEntity;
import com.entertainment.test.controller.BaseWebController;
import com.entertainment.test.entity.OrderItemEntity;
import com.entertainment.test.repo.OrderRepo;
import com.entertainment.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseWebController {
    @Autowired
    public OrderService orderService;
    @Autowired
    public OrderRepo orderRepo;

//    order/orderDetail?orderId=1
    @RequestMapping(value = "/orderDetail",method = RequestMethod.GET)
    public RespEntity<List<OrderCell>> orderDetail(int orderId){
        RespEntity<List<OrderCell>> respEntity=RespEntity.One();
        try {
            respEntity.data = orderService.orderDetail(orderId);
        }catch (Exception e){
            error(e,respEntity);
        }

//        List<OrderItemEntity> orderCellList =orderRepo.findAll();
        return respEntity;
    }

}
