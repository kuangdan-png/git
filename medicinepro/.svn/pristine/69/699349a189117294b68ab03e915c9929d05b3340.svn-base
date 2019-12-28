package com.medicine.service.impl;


import com.medicine.dao.inter.MemberDaoInter;
import com.medicine.pojo.MaxNo;
import com.medicine.pojo.Members;
import com.medicine.service.inter.MemberServiceInter;
import com.medicine.util.CommandMethod;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
/**
 * 业务逻辑层实现类
 * @author 夏盖文
 */
@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberServiceInter {

    //1、依赖数据访问的接口引用
    @Resource(name = "memberDaoImpl")
    private MemberDaoInter memberDaoImpl;
    //2、提供setter方式完成注入
    public void setEmployeesInfoDaoImpl(MemberDaoInter memberDaoImpl) {
        this.memberDaoImpl = memberDaoImpl;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询会员信息
     * @return
     */
    public List<Members> searcMembersInter(Members members) {
        members.setPage((members.getPage() - 1) * members.getLimit());
        return memberDaoImpl.searchMembersInter(members);
    }

    /**
     * 新增会员信息
     * @param members
     * @return
     */
    @Override
    public int insertMembers(Members members) {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        String memJoinDate = members.getMemJoinDateStr();
        String memExpireDate = members.getMemExpireDateStr();
        try {
            members.setMemJoinDate(formatter.parse(memJoinDate));
            members.setMemExpireDate(formatter.parse(memExpireDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MaxNo maxNo = new MaxNo();
        maxNo.setManName("members");
        maxNo.setManSort(members.getMemNo());
        commandMethod.updateMax(maxNo);
        return memberDaoImpl.insertMembers(members);
    }

    /**
     *删除会员信息
     * @param members
     * @return
     */
    @Override
    public int deleteMembers(Members members) {
        String[] memberNoArray = members.getMemNo().split(",");
        return memberDaoImpl.deleteMembers( memberNoArray);
    }

    /**
     * 编辑会员信息
     * @param members
     * @return
     */
    @Override
    public int updateMembers(Members members) {
        return memberDaoImpl.updateMembers(members);
    }

    /**
     * 查询会员最大编号
     * @return
     */
    @Override
    public String selectMembersId() {
        //取到最大值
        String key = memberDaoImpl.selectMembersId();
        //保存截取的最后四位的字符串
        String subKey = "";
        //保存截取的最后四位的数值
        int number = 0;
        StringBuffer sb = new StringBuffer("s");
        if ("".equals(key) || key == null) {//如果为空，也就是主键列没有数据
            //例如：DD_20190808162030+0001
            sb.append("0001");
        } else {//不为空
            subKey = key.substring(1);
            number = Integer.valueOf(subKey);
            number++;
            if (number >= 0 && number <= 9) {
                sb.append("000");
            } else if (number >= 10 && number <= 99) {
                sb.append("00");
            } else if (number >= 100 && number <= 999) {
                sb.append("0");
            }
            sb.append(number);
        }
        return sb.toString();
    }

    /**
     * 总页数
     *
     * @return
     */
    public int searchSize() {
        return memberDaoImpl.searchSize();
    }

    /**
     * 条件查询
     * @param members
     * @return
     */
    @Override
    public List<Members> selectWhereMembers(Members members) {
        members.setPage((members.getPage() - 1) * members.getLimit());
        return memberDaoImpl.selectWhereMembers(members);
    }

}
