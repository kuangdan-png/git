package com.medicine.service.impl;

/**
 * Auther:刘双
 * DATE: 2019-12-05-9:40
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.service.impl
 */

import com.medicine.dao.inter.FileUploadDaoInter;
import com.medicine.dao.inter.FileUploadDaoInterMember;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.Members;
import com.medicine.util.ReadExcel;
import com.medicine.util.ReadExcelRMember;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UploadServiceMember {
    @Resource(name = "fileUploadDaoImplMember")
    private FileUploadDaoInterMember fileUploadDaoImpl;

    public void setFileUploadDaoImpl(FileUploadDaoInterMember fileUploadDaoImpl) {
        this.fileUploadDaoImpl = fileUploadDaoImpl;
    }

    //批量导入客户
    public int batchImport(String name,MultipartFile file){
        //的作用：
        System.out.println("===rtyuioghj");
        boolean b = false;
        //创建处理EXCEL
        ReadExcelRMember readExcel=new ReadExcelRMember();
        //解析excel，获取客户信息集合。
        List<Members> customerList = readExcel.getExcelInfo(name ,file);
        System.out.println(customerList);

        int rows=fileUploadDaoImpl.upLoadDao(customerList);
        //迭代添加客户信息（注：实际上这里也可以直接将customerList集合作为参数，在Mybatis的相应映射文件中使用foreach标签进行批量添加。）
        for(Members member:customerList){
            System.out.println(member.toString());
            //Dao层根据实际情况编写
        }

        return rows;
    }
}
