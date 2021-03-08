package com.kirylshreyter.hotel.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.hotel.daoapi.ICommon;
import com.kirylshreyter.hotel.services.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Inject
	private ICommon iCommon;

	@Override
	public <T> Object get(Object obj, Long id) {
		return iCommon.get(obj, id);
	}

	@Override
	public Boolean delete(Object obj, Long id) {
		return iCommon.delete(obj, id);
	}

	@Override
	public <T> List<T> getAll(Object obj) {
		return iCommon.getAll(obj);
	}

}
