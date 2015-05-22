package com.ethercamp.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PhonesController {

    @Autowired
    private ApplicationContext ctx;


    @RequestMapping(value = "/phones/{phone}" , produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public String phoneDetails(@PathVariable String phone) throws IOException {

        InputStream is = ctx.getResource("classpath:phones/" + phone + ".json").getInputStream();

        String line;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();

        return sb.toString();
    }

}
