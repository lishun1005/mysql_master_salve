package com.lishun.service;

import com.lishun.entity.WmIpInfo;

/**
 * @author lishun
 * @Description: TODO
 * @date 2018/2/7
 */
public interface WmIpInfoService {
	WmIpInfo findOneById(String id);

	int insert(WmIpInfo wmIpInfo);
}
