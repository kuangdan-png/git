package com.medicine.dao.impl;


import com.medicine.dao.inter.MemberDaoInter;
import com.medicine.pojo.Members;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 夏盖文
 */
@Repository("memberDaoImpl")
public class MemberDaoImpl implements MemberDaoInter {
    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactory;
    //2、提供setter方式完成注入
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 查询会员信息
     * @return
     */
    public List<Members> searchMembersInter(Members members) {
        SqlSession sqlSession = null;
        List<Members> membersList=new ArrayList<Members>();

        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="member.crud.searchMember";
            membersList=sqlSession.selectList(statementKey,members);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return membersList;
    }

    /**
     * 查询总条数
     * @return
     */
    public int searchSize() {
        SqlSession sqlSession = null;
        int row=0;
        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="member.crud.searchSize";

            row=sqlSession.selectOne(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

        return row;
    }

    /**
     * 条件查询会员信息
     * @param members
     * @return
     */
    @Override
    public List<Members> selectWhereMembers(Members members) {
        SqlSession sqlSession = null;
        List<Members> membersList=new ArrayList<Members>();
        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="member.crud.selectWhereMembers";
            membersList=sqlSession.selectList(statementKey,members);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return membersList;
    }

    /**
     * 新增会员信息
     * @param members
     * @return
     */
    @Override
    public int insertMembers(Members members) {
        SqlSession sqlSession = null;
        int row = 0;
        try {
            sqlSession = sqlSessionFactory.openSession();
            String statementKey = "member.crud.insertMember";
            System.out.println("daoImplInsert="+members.getMemNo());
            row = sqlSession.insert(statementKey,members);
            System.out.println("daoImplInsertRow="+row);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return row;
    }

    /**
     * 删除会员信息
     * @param memberNo
     * @return
     */
    @Override
    public int deleteMembers(String[] memberNo) {
        SqlSession sqlSession=null;
        int row=0;
        try{
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="member.crud.deleteMember";
            row=sqlSession.update(statementKey,memberNo);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return row;
    }

    /**
     * 编辑会员信息
     * @param members
     * @return
     */
    @Override
    public int updateMembers(Members members) {
        SqlSession sqlSession = null;
        int rows =0;
        try {

            sqlSession = sqlSessionFactory.openSession();
            //3、定义待执行statementKey(jdbc:编写待执行的SQL,交由statement)
            String statementKey = "member.crud.updateMember";
            //4、执行查询操作
            rows=sqlSession.update(statementKey,members);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.关闭sqlSession
            sqlSession.close();
        }
        return rows;
    }

    /**
     * 查询会员最大编号
     * @return
     */
    @Override
    public String selectMembersId() {
        SqlSession sqlSession = null;
        String membersId=null;
        try {
            sqlSession=sqlSessionFactory.openSession();
            String statementKey="member.crud.selectMaxMember";
            membersId=sqlSession.selectOne(statementKey);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return membersId;
    }


}
