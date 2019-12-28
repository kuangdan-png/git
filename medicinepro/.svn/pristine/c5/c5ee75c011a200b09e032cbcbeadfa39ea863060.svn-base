package com.medicine.handler;

import com.medicine.pojo.MaxNo;
import com.medicine.pojo.Members;
import com.medicine.service.inter.MemberServiceInter;
import com.medicine.util.CommandMethod;
import com.medicine.util.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 夏盖文
 */
@Controller
@RequestMapping(value = "/member")
public class MemberHandler {
    //依赖业务逻辑的接口引用
    @Resource(name = "memberServiceImpl")
    private MemberServiceInter memberServiceImpl;
    //提供setter方式完成注入

    public void setMemberServiceImpl(MemberServiceInter memberServiceImpl) {
        this.memberServiceImpl = memberServiceImpl;
    }

    @Resource(name = "commandMethod")
    private CommandMethod commandMethod = null;

    public void setCommandMethod(CommandMethod commandMethod) {
        this.commandMethod = commandMethod;
    }

    /**
     * 查询会员信息
     * @param members
     * @return
     */

    @RequestMapping(value = "/searchMembersInter.action")
    public @ResponseBody ResultMap<List<Members>> searchMembersInter(Members members){
        //调用业务逻辑实现类
        int row =  memberServiceImpl.searchSize();

        List<Members> membersList=memberServiceImpl.searcMembersInter(members);

        ResultMap<List<Members>> listResultMap=new ResultMap<List<Members>>("",membersList, 200,row);

        return listResultMap;
    }


    /**
     * 新增会员信息
     * @param members
     * @return
     */
    @RequestMapping(value = "/insertMembers.action")
    public String insertMembers(Members members){
        //调用业务逻辑实现类
        int row=memberServiceImpl.insertMembers(members);
        if(0!=row){
            return "successed";
        }else{
            return "failed";
        }
    }

    /**
     * 删除会员信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteMembers.action")
    public String deleteMembers(Members members){
        System.out.println("invoke deleteMembers method");
        //调用业务逻辑实现类
        int row=memberServiceImpl.deleteMembers(members);
        if(0!=row){
            return "successed";
        }else{
            return "failed";
        }
    }

    /**
     * 编辑会员信息
     * @param members
     * @return
     */
    @RequestMapping(value = "/updateMembers.action")
    public @ResponseBody
    String updateMembers(Members members){
        int rows=memberServiceImpl.updateMembers(members);
        System.out.println("编辑"+rows);
        System.out.println("编辑"+members);
        if(0!=rows){
            return "successed";
        }else{
            return "failed";
        }
    }

    /**
     * 查询最大值
     * @return
     */
    @RequestMapping(value = "/selectMembersId.action")
    public @ResponseBody String selectMembersId(){
        MaxNo maxNo=new MaxNo();
        maxNo.setManName("members");
        String puMaxNo = commandMethod.getPuMaxNo(maxNo);
        return puMaxNo;
    }

    /**
     * 按条件查询
     * @param members
     * @return
     */
    @RequestMapping(value = "/selectWhereMembers.action")
    public @ResponseBody ResultMap<List<Members>> selectWhereMembers(Members members){
        //调用业务逻辑实现类
        int row = memberServiceImpl.searchSize();

        List<Members> membersList=memberServiceImpl.selectWhereMembers(members);

        ResultMap<List<Members>> listResultMap=new ResultMap<List<Members>>("",membersList, 200,row);

        return listResultMap;
    }

}

