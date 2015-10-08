package com.indasil.shopdrop;

import com.indasil.shopdrop.domain.Item;
import com.indasil.shopdrop.domain.Order;
import com.indasil.shopdrop.domain.OrderItem;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by vashishta on 10/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-config.xml"})
@Transactional
public class DomainTest {

    @Autowired
    private SessionFactory sessionFactory;


    @Test
    @Rollback(false)
    public void testSessionFactory() {

        Session session = sessionFactory.getCurrentSession();
        Assert.notNull(session);

    }

    @Test
    @Rollback(false)
    public void newOrder() {
        Order order = new Order();
        order.setCreateDate(new Date());


        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);


        Item item = new Item();
        item.setId(1L);

        orderItem.setItem(item);

        orderItem.setPrice(new BigDecimal(10.00));

        order.addOrderItem(orderItem);

        Session session = sessionFactory.getCurrentSession();
        session.setFlushMode(FlushMode.MANUAL);

        session.save(order);
        session.flush();


    }

}
