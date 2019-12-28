package com.medicine.dao.inter;


import com.medicine.pojo.Members;

import java.util.List;

/**
 * 会员信息数据访问层的接口
 * @author 夏盖文
 */
public interface MemberDaoInter {
    /**
     * 查询会员信息
     * @return
     */
    List<Members> searchMembersInter(Members members);

    /**
     * 新增会员信息
     * @param members
     * @return
     */
    int insertMembers(Members members);

    /**
     * 删除会员信息
     * @param memberNo
     * @return
     */
    int deleteMembers(String[] memberNo);

    /**
     * 编辑会员信息
     * @param members
     * @return
     */
    int updateMembers(Members members);

    /**
     * 查询会员的最大编号
     * @return
     */
    String selectMembersId();

    /**
     *查询总条数
     * @return
     */
    int searchSize();

    /**
     * 条件查询会员
     * @param members
     * @return
     */
    List<Members> selectWhereMembers(Members members);

}
