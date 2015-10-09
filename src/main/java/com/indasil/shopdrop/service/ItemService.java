package com.indasil.shopdrop.service;

import com.indasil.shopdrop.domain.Item;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    public Item getItemById(Long id) {
        Item item = sessionFactory.getCurrentSession().load(Item.class, id);
        Hibernate.initialize(item);
        return item;
    }

    /**
     *
     * @param item
     */
    public void save(Item item) {
        Session session = sessionFactory.getCurrentSession();
        if (item.getId() != null) {
            Item itemInDB = session.load(Item.class, item.getId());
            itemInDB.setName(item.getName());
            itemInDB.setPrice(item.getPrice());
            session.update(itemInDB);
        }
        else {
            // A transient instance is being sent because there is no id
            item.setCreateDate(new Date());
            sessionFactory.getCurrentSession().save(item);
        }
    }

}
