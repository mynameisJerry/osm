package com.pzhu.shopping.myshop.mapper;
/**
 * @Classname CartMapper
 * @Description TODO
 * @Date 2018/10/19 13:07
 * @Created by Administrator
 */

import com.pzhu.shopping.myshop.pojo.cart.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @Date 2018/10/19 13:07
 * @Classname CartMapper
 */
@Repository
public interface CartMapper {
    Cart findByUserIdAndGoodsId(@Param("id") int id, @Param("pid") int pid);

    void add(Cart cart);

    void update(Cart cart);

    List<Cart> getCartById(int id);

    void remove(@Param("id") int id, @Param("pid") int pid);

    void clear(int id);

    void deleteByUserId(int uid);
}
