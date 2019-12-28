package com.medicine.dao.impl;

import com.medicine.dao.inter.FileUploadDaoInter;
import com.medicine.dao.inter.FileUploadDaoInterMember;
import com.medicine.pojo.Commodity;
import com.medicine.pojo.Members;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-12-05-10:31
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.dao.impl
 */
@Repository("fileUploadDaoImplMember")
public class FileUploadDaoImplMember implements FileUploadDaoInterMember {
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactoryBean;

    public void setSqlSessionFactoryBean(SqlSessionFactory sqlSessionFactoryBean) {
        this.sqlSessionFactoryBean = sqlSessionFactoryBean;
    }

    @Override
    public int upLoadDao(List<Members> members) {
        SqlSession sqlSession = null;
        int rows =0;
//        List<Members> list=new ArrayList<Members>();
//        System.out.println("rows==="+list.size());
//        for (Members members1:members){
//
//        }
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)

            String statementKey = "medicinepro.uploadFile.upLoadinsertMember";
            //6、执行查询操作
            rows = sqlSession.insert(statementKey,members);
            //rows的作用：
            System.out.println("rows==="+rows);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (null != sqlSession){
                sqlSession.close();
            }
        }
        return rows;
    }

}
