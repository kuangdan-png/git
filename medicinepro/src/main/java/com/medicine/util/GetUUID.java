package com.medicine.util;

import java.util.UUID;

/**
 * Auther:刘双
 * DATE: 2019-11-25-16:37
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.util
 */
public class GetUUID {
    public String getUUid(String[] args) {
        String uuid = UUID.randomUUID().toString();	//获取UUID并转化为String对象
        uuid = uuid.replace("-", "");				//因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
        return uuid;
    }
}
