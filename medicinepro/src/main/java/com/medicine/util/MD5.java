package com.medicine.util;

import com.medicine.pojo.Employees;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Auther: 刘涵
 * @Date: 2019/11/15 0015 09:02
 * @Description:
 */
public class MD5 {

    public static String md5(Employees employees) {
//        加密的方式
        String hashAlgorithmName = "MD5";
//      加密的密码
        String credentials = employees.getUserPass();
//      盐值
        Object salt = ByteSource.Util.bytes(employees.getUserName());
//      加密的次数
        int hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(simpleHash);
        return simpleHash.toString();
    }

}
