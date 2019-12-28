package com.medicine.dao.inter;

import com.medicine.pojo.Commodity;

import java.util.List;

/**
 * Auther:刘双
 * DATE: 2019-12-05-10:29
 * PROJECT: Medicine management
 * PACKAGE: com.medicine.dao.inter
 */
public interface FileUploadDaoInter {
    public int upLoadDao(List<Commodity> commodityList);
}
