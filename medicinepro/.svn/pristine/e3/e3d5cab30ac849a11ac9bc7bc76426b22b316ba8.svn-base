package com.medicine.handler;

/**
 * Auther:刘双
 * DATE: 2019-12-05-9:41
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.handler
 */


import com.medicine.service.impl.UploadService;
import com.medicine.service.impl.UploadServiceMember;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/addController")
public class FileUploadControllerMember {

    private static Log log = LogFactory.getLog(FileUploadControllerMember.class);
    @Autowired
    private UploadServiceMember customerServiceMember;

    @RequestMapping(value = "/batchimportMember.action", method = RequestMethod.POST)
    public @ResponseBody int batchimport(@RequestParam MultipartFile file) throws IOException {
        log.info("AddController ..batchimport() start");
        //判断文件是否为空
        if(file==null) return 0;
        //获取文件名
        String name=file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) return 0;

        //批量导入。参数：文件名，文件。
         int b = customerServiceMember.batchImport(name,file);

        return b;
    }

}