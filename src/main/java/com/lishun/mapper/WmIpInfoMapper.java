package com.lishun.mapper;

import com.lishun.entity.WmIpInfo;

public interface WmIpInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(WmIpInfo record);

    int insertSelective(WmIpInfo record);

    WmIpInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WmIpInfo record);

    int updateByPrimaryKey(WmIpInfo record);
}