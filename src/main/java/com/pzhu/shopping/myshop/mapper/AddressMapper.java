package com.pzhu.shopping.myshop.mapper;
/**
 * @Classname AddressMapper
 * @Description TODO
 * @Date 2018/10/17 22:31
 * @Created by Administrator
 */

import com.pzhu.shopping.myshop.pojo.address.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @Date 2018/10/17 22:31
 * @Classname AddressMapper
 */
@Repository
public interface AddressMapper {

    List<Address> getAddressList(int uid);

    void defautAdd(@Param("id") Integer id, @Param("level") Integer level);

    void addAddress(Address address);

    void updateAddress(Address address);

    void deleteAddress(String id);

    List<Address> findByUserId(int id);

    Address findByAid(int aid);
}
