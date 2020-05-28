package com.chenghui.ticket.services.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.chenghui.ticket.services.uploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Devil
 * @date 2020/3/13 21:22
 */
@Service
public class uploadServiceImpl implements uploadService {
    @Override
    public String upload(MultipartFile files) {
        try {
            InputStream inputStream = files.getInputStream();
            String uuid = IdUtil.simpleUUID();
            String name = files.getOriginalFilename();
            String suffix = name.substring(name.lastIndexOf(".") + 1);
            String filename=uuid+"."+suffix;
            String url="F:/赚钱/项目/售票系统/前端/ticket/images/"+filename;
            FileUtil.writeFromStream(inputStream,url);
            return filename;
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }
}
