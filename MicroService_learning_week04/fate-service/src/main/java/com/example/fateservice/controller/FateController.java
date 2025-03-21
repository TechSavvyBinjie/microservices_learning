package com.example.fateservice.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FateController {
    @GetMapping("/fate")
    public String fate(@RequestParam String date)throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet=new HttpGet("http://v.juhe.cn/laohuangli/d?date="+date+"&key=3b9a2b70bb129cd771c054cab30b490e");
        CloseableHttpResponse response = null;
        try{
            response=httpClient.execute(httpGet);
            String content= EntityUtils.toString(response.getEntity(),"UTF-8");
            return content;
        }finally {
            if(response!=null){
                response.close();
            }
            httpClient.close();
        }

    }
}
