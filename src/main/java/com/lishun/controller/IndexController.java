package com.lishun.controller;

import com.lishun.entity.WmIpInfo;
import com.lishun.service.WmIpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lishun
 * @Description: TODO
 * @date 2018/2/7
 */

@RestController
public class IndexController {
	@Autowired
	public WmIpInfoService wmIpInfoService;
	@GetMapping("/index/{id}")
	public WmIpInfo index(@PathVariable(value = "id") String id){
		WmIpInfo wmIpInfo = new WmIpInfo();
		wmIpInfo.setId(UUID.randomUUID().toString());
		wmIpInfoService.insert(wmIpInfo);
		wmIpInfoService.findOneById(id);
		String s = new String("");
		System.out.println(s.getClass() == String.class);
		return null;
	}
}
