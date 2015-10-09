package com.indasil.shopdrop.web.feature.item;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by vashishta on 10/9/15.
 */
@Component
public class ItemValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(ItemForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {



        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"item.name","","Please enter a value");

    }


}
