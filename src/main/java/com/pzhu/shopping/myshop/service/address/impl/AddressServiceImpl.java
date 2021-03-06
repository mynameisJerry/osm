package com.pzhu.shopping.myshop.service.address.impl;

import com.pzhu.shopping.myshop.mapper.AddressMapper;
import com.pzhu.shopping.myshop.pojo.address.Address;
import com.pzhu.shopping.myshop.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @Date 2018/10/17 22:30
 * @Classname AddressServiceImpl
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddressList(int uid) {
        return addressMapper.getAddressList(uid);
    }

    @Override
    public void defautAdd(Integer id,Integer level) {
        addressMapper.defautAdd(id,level);
    }

    @Override
    public void addAddress(Address address) {

       // address.setUid(32);
        //address.setLevel(0);
        addressMapper.addAddress(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressMapper.updateAddress(address);
    }

    @Override
    public void deleteAddress(String id) {
        addressMapper.deleteAddress(id);
    }

    @Override
    public List<Address> findByUserId(int id) {
        return addressMapper.findByUserId(id);
    }

    @Override
    public Address findByAid(int aid) {
        return addressMapper.findByAid(aid);
    }
}
