package com.medicine.service.inter;

import com.medicine.pojo.Members;

import java.util.List;

/**
 * @author 夏盖文
 */
public interface MemberServiceInter {
    /**
     * 查询会员信息
     * @return
     */
    List<Members> searcMembersInter(Members members);

    /**
     * 新增会员信息
     * @param members
     * @return
     */
    int insertMembers(Members members);

    /**
     * 删除会员信息
     * @param members
     * @return
     */
    int deleteMembers(Members members);

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
     * 查询总条数
     * @return
     */
    int searchSize();

    /**
     * 按条件查询
     * @param members
     * @return
     */
    List<Members> selectWhereMembers(Members members);

}
