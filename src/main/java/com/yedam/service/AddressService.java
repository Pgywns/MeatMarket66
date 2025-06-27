package com.yedam.service;

import java.util.List;

import com.yedam.vo.AddressVO;

public interface AddressService {
	// 회원가입
	public boolean insertAdd(AddressVO add);
	
	// 주소 조회
	public List<AddressVO> selectAddress(String id);
	// 주소 삭제
	public boolean deleteAddress(AddressVO add);
}
