package com.lishun.service.impl;

import com.lishun.annotation.ReadDataSource;
import com.lishun.annotation.WriteDataSource;
import com.lishun.entity.WmIpInfo;
import com.lishun.mapper.WmIpInfoMapper;
import com.lishun.service.WmIpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lishun
 * @Description: TODO
 * @date 2018/2/7
 */
@Service
@Transactional
public class WmIpInfoServiceImpl implements WmIpInfoService {
	@Autowired
	public WmIpInfoMapper wmIpInfoMapper;

	@Override
	@ReadDataSource
	public WmIpInfo findOneById(String id) {
		//wmIpInfoMapper.selectByPrimaryKey(id);
		return wmIpInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	@WriteDataSource
	public int insert(WmIpInfo wmIpInfo) {
		int result = wmIpInfoMapper.insert(wmIpInfo);
		return result;
	}
}
