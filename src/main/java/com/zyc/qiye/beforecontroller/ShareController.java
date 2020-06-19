package com.zyc.qiye.beforecontroller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.zyc.qiye.setvice.OssService;
import com.zyc.qiye.util.ResponseUtil;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.io.*;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/wx/share")
public class ShareController {

    @Autowired
    private OssService ossService;

    private  final String APP_ID="wx225afaa7c036f80d";    //微信小程序的密钥和APP_SECRET
    private  final  String APP_SECRET="28f877afe6752868746a2c4e681654b9";
    @RequestMapping("getToken")   //获取微信小程序token方法
    public  Object getToken(){
        String wexinapiurl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APP_ID+"&secret="+APP_SECRET;
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpGet=new HttpGet(wexinapiurl);
        InputStream inputStream=null;
        CloseableHttpResponse httpResponse=null;
        StringBuilder result=new StringBuilder();
        String accessToken="";
        try {
            httpResponse=httpClient.execute(httpGet);
            org.apache.http.HttpEntity entity=httpResponse.getEntity();
            inputStream=entity.getContent();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                JSONObject jsonObject= JSON.parseObject(line);
                accessToken=jsonObject.getString("access_token");

            }
            return  ResponseUtil.ok(accessToken);

        }catch (Exception e){
            System.out.println(e);

            return ResponseUtil.fail();

        }

    }
    @RequestMapping("/lun")  //获取微信小程序token方法 获取分享二维码
    public  Object uploadLunbo(
            @RequestParam("token") String token,
            @RequestParam("id") int id
    ){
        RestTemplate rest = new RestTemplate();
        InputStream inputStream = null;
        OutputStream outputStream = null;

        System.out.println(token);
        try {
            String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+token;
            Map<String,Object> param = new HashMap<>();
            param.put("page", "pages/product/product");
           param.put("scene","id="+id);


            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Content-Type","application/json");
            HttpEntity requestEntity = new HttpEntity(param, headers);
            ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);

            byte[] result = entity.getBody();


            inputStream = new ByteArrayInputStream(result);

          return ResponseUtil.ok( ossService.uploaderweima(inputStream));


        }catch ( Exception e){
                return  ResponseUtil.fail();
        }

    }

}
