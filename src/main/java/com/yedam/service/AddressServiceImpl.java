package com.yedam.service;

import java.util.List;

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

	@Override
	public List<AddressVO> selectAddress(String id) {
		return mapper.selectAddress(id);
	}

	@Override
	public boolean deleteAddress(AddressVO add) {
		int r = mapper.deleteAddress(add);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean firstAddrChangeTrue(AddressVO add) {
		int r = mapper.firstAddrChangeTrue(add);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean firstAddrChangeFalse(String id) {
		int r = mapper.firstAddrChangeFalse(id);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}
}
