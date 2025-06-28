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
		int s = mapper.firstAddrUpdate(add.getUserId());
		int r = mapper.insertAdd(add);
		
		// 아래 작업해야 하는 것: s가 true로 들어오면 그거 false로 바꾸고 새로운 배송지 insert하면서 true넣기
		// mapper where res = true 인걸로 조회하는 걸로 바꾸기
//		if (s "true")
		
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
}
