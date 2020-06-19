package com.zyc.qiye.setvice;

import com.zyc.qiye.dto.ResultOssInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface OssService {

    ResultOssInfo uploadlunbo(MultipartFile file, String type);
    ResultOssInfo uploadbuffer(String buffer);
    ResultOssInfo  uploaderweima(InputStream inputStream);
}
