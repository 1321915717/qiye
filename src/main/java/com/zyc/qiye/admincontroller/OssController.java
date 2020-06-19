package com.zyc.qiye.admincontroller;

import com.zyc.qiye.dto.ResultOssInfo;
import com.zyc.qiye.setvice.OssService;
import com.zyc.qiye.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    @RequestMapping("/lun")
    public  Object uploadLunbo(
            @RequestParam(value = "file") MultipartFile file
    ){
        ResultOssInfo resultOssInfo =ossService.uploadlunbo(file,"lun");
        if(null!=resultOssInfo){

            return ResponseUtil.ok(resultOssInfo);
        }
        return  ResponseUtil.fail();
    }

}
