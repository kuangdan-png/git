package com.medicine.dao.impl;

import com.medicine.dao.inter.FileUploadDaoInter;
import com.medicine.pojo.Commodity;
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
@Repository("fileUploadDaoImpl")
public class FileUploadDaoImpl implements FileUploadDaoInter{
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactoryBean;

    public void setSqlSessionFactoryBean(SqlSessionFactory sqlSessionFactoryBean) {
        this.sqlSessionFactoryBean = sqlSessionFactoryBean;
    }

    @Override
    public int upLoadDao(List<Commodity> commodityList) {
        SqlSession sqlSession = null;
        int rows =0;
        List<Commodity> list=new ArrayList<Commodity>();
        for(Commodity lists:commodityList){
            //lists.getComId()的作用：
            System.out.println("==="+lists.getComId());
            if(lists.getComId() != null){
                list.add(lists);
            }
        }
        try {
            sqlSession = sqlSessionFactoryBean.openSession();
            //5、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            //list.size()的作用：
            for (Commodity commodity:list){
                //commodity.getComId的作用：
                System.out.println("commodity.getComId==="+commodity.getComId());
            }
            String statementKey = "medicinepro.uploadFile.upLoadinsert";
            //6、执行查询操作
            rows = sqlSession.insert(statementKey,list);
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
