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
 *
 * CRUD operations on an item
 * List all items that are active via the active flag

 * Create a new item
 * Read an item
 * Update an existing item
 * Delete an item
 *
 *
 * Created by vashishta on 10/8/15.
 */
@Component
@Transactional
public class ItemService {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Item> getAllItems() {
        List<Item> items = sessionFactory.getCurrentSession().createQuery("select new Item(i.id, i.name, i.price, i.createDate) from Item i where i.active = true").list();
        return items;
    }

    public Item getItemById(Long id) {
        Item item = sessionFactory.getCurrentSession().load(Item.class, id);
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
            item.setActive(true);
            sessionFactory.getCurrentSession().save(item);
        }
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Item itemDB = session.load(Item.class, id);
        itemDB.setActive(false);

        session.update(itemDB);

    }

}
