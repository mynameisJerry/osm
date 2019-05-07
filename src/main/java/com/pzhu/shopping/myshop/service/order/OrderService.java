package com.pzhu.shopping.myshop.service.order;
/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2018/10/19 16:47
 * @Created by Administrator
 */




import com.pzhu.shopping.myshop.pojo.cart.Cart;
import com.pzhu.shopping.myshop.pojo.order.Order;
import com.pzhu.shopping.myshop.pojo.order.OrderDetail;
import com.pzhu.shopping.myshop.vo.OrderVo;

import java.util.List;

/**
 * @author Administrator
 * @Date 2018/10/19 16:47
 * @Classname OrderService
 */
public interface OrderService {

    Order submitOrder(List<Cart> carts, int addid, int uid);

    List<Order> findOrderByUserId(int id);

    List<OrderDetail> findByOid(String oid);

    Order findByOrderid(String oid);

    void updateStatus(String orderId, String status);

    List<OrderVo> getAllOrder();

    List<OrderVo> findOrderByUseridOrStatus(String username, String status);
}
