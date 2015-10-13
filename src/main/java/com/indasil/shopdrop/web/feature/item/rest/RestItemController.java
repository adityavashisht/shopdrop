package com.indasil.shopdrop.web.feature.item.rest;

import com.indasil.shopdrop.domain.Item;
import com.indasil.shopdrop.service.ItemService;
import net.sf.ehcache.hibernate.management.impl.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vashishta on 10/12/15.
 */
@RestController
@RequestMapping(value = "/restItem")
public class RestItemController {


    @Autowired
    private ItemService itemService;


    @RequestMapping(method = RequestMethod.GET, value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Item>> getAll() {

        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }


    /**
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAll(@RequestBody Item item) {
        itemService.save(item);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable("id") Long id) {

        Item item = itemService.getItemById(id);

//        Item returnItem = new Item();
//        returnItem.setId(item.getId());
//        returnItem.setName(item.getName());
//        returnItem.setPrice(item.getPrice());
//        returnItem.setCreateDate(item.getCreateDate());

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
