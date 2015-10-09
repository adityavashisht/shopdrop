package com.indasil.shopdrop.service;

import com.indasil.shopdrop.domain.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vashishta on 10/8/15.
 */
@Component
@Transactional
public class ItemService {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Item> getAllItems() {
        List<Item> items = sessionFactory.getCurrentSession().createQuery("from Item").list();
        return items;
    }

}
