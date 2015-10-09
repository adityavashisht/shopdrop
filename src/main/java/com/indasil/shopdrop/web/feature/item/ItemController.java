package com.indasil.shopdrop.web.feature.item;


import com.indasil.shopdrop.domain.Item;
import com.indasil.shopdrop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by vashishta on 10/8/15.
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemValidator itemValidator;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("name", "hussein");
        model.addAttribute("products", itemService.getAllItems());
        return "item/list";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String show(Model model, @RequestParam(value = "id", required = false) Long id) {

        ItemForm itemForm = new ItemForm();

        Item item = new Item();
        if (id != null) {
            item = itemService.getItemById(id);
        }
        itemForm.setItem(item);


        model.addAttribute("itemForm", itemForm);

        return "item/show";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute("itemForm") ItemForm itemForm, BindingResult result, Model model) {

        itemValidator.validate(itemForm, result);

        String view = "redirect:item/list";

        if (!result.hasErrors()) {

            Item item = itemForm.getItem();

            itemService.save(item);

        } else {

            model.addAttribute("itemForm", itemForm);

            view = "item/show";
        }

        return view;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public String delete(@RequestParam(value = "id") Long id) {

        itemService.delete(id);

        return "redirect:list";
    }


}
