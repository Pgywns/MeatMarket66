package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.AddressMapper;
import com.yedam.vo.AddressVO;

public class AddressServiceImpl implements AddressService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
	
	@Override
	public boolean insertAdd(AddressVO add) {
		int r = mapper.insertAdd(add);
		
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

}
