package com.zyc.qiye.setvice;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.zyc.qiye.dto.ResultOssInfo;
import com.zyc.qiye.pojo.Lunbo;
import com.zyc.qiye.util.OssFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 * sevice 用于图片上传到oss
 * */

@Service
public class OssServiceImpl implements OssService {



    /*oss属性，yml里面配置 oss密钥*/
    @Autowired
    private OSSClient ossClient;
    @Value(("${aliyun.oss.maxSize}"))
    private int ALIYUN_OSS_MAX_SIZE;
    @Value("${aliyun.oss.callback}")
    private String ALIYUN_OSS_CALLBACK;
    @Value("${aliyun.oss.bucketName}")
    private String ALIYUN_OSS_BUCKET_NAME;
    @Value("${aliyun.oss.endpoint}")
    private String ALIYUN_OSS_ENDPOINT;
    @Value("${aliyun.oss.dir.avatar}")
    private String ALIYUN_OSS_DIR_AVATAR;
    @Value("${aliyun.oss.dir.content}")
    private String ALIYUN_OSS_DIR_IMG;
    @Value("${aliyun.oss.dir.lun}")
    private   String LUN_BO;



    // 下面三个都是上传到oss的方法
    public ResultOssInfo  uploadlunbo(MultipartFile file,String type){
        InputStream inputStream =null;

        try {
            inputStream=file.getInputStream();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String dateStr = format.format(new Date());
            String fileName=dateStr+ UUID.randomUUID().toString().replace("-","")+ OssFileUtil.filterOssEnd(file.getOriginalFilename());
        //    System.out.println(fileName);
            String url="";
            String imgUrl="";

              url=LUN_BO+"/"+fileName;
             imgUrl="https://ppt-download.oss-cn-beijing.aliyuncs.com/"+ LUN_BO +"/"+fileName;

            PutObjectResult result =ossClient.putObject(new PutObjectRequest(ALIYUN_OSS_BUCKET_NAME, url, inputStream));

            if(null!=result){

                ResultOssInfo resultOssInfo =new ResultOssInfo();
                    resultOssInfo.setFileDownLoadUrl(imgUrl);
                    resultOssInfo.setFileName(url);
                    return  resultOssInfo;



            }
            return  null;

        }catch (IOException ioEx){
            return  null;
        }
    }

    @Override
    public ResultOssInfo uploadbuffer(String buffer) {

        byte []content =buffer.getBytes();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String dateStr = format.format(new Date());
        String fileName=dateStr+ UUID.randomUUID().toString().replace("-","")+ ".png";
     //   System.out.println(fileName);
        String url="";
        String imgUrl="";

        url=LUN_BO+"/"+fileName;
        imgUrl="https://ppt-download.oss-cn-beijing.aliyuncs.com/"+ LUN_BO +"/"+fileName;

        PutObjectResult result =ossClient.putObject(new PutObjectRequest(ALIYUN_OSS_BUCKET_NAME, url, new ByteArrayInputStream(content)));
        if(null!=result){

            ResultOssInfo resultOssInfo =new ResultOssInfo();
            resultOssInfo.setFileDownLoadUrl(imgUrl);
            resultOssInfo.setFileName(url);
            return  resultOssInfo;



        }
        return  null;
    }

    public ResultOssInfo  uploaderweima(InputStream  inputStream){


        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String dateStr = format.format(new Date());
            String fileName=dateStr+ UUID.randomUUID().toString().replace("-","")+".png";
          //  System.out.println(fileName);
            String url="";
            String imgUrl="";

            url=LUN_BO+"/"+fileName;
            imgUrl="https://ppt-download.oss-cn-beijing.aliyuncs.com/"+ LUN_BO +"/"+fileName;

            PutObjectResult result =ossClient.putObject(new PutObjectRequest(ALIYUN_OSS_BUCKET_NAME, url, inputStream));

            if(null!=result){

                ResultOssInfo resultOssInfo =new ResultOssInfo();
                resultOssInfo.setFileDownLoadUrl(imgUrl);
                resultOssInfo.setFileName(url);
                return  resultOssInfo;



            }
            return  null;

        }catch (Exception e){
            return  null;
        }
    }
}
