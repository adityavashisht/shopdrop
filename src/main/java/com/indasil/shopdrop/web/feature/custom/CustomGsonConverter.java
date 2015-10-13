package com.indasil.shopdrop.web.feature.custom;

/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.gson.*;


import org.springframework.http.converter.json.GsonHttpMessageConverter;




import java.text.DateFormat;
import java.util.Date;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class CustomGsonConverter extends GsonHttpMessageConverter {

   @PostConstruct
   public void init() {
       Gson gson = new GsonBuilder()
               .registerTypeAdapter(Date.class, new ISODateAdapter()).create();
       setGson(gson);
   }





}

