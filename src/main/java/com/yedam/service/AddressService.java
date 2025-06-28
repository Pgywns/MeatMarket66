package com.yedam.service;

import java.util.List;

import com.yedam.vo.AddressVO;

public interface AddressService {
	// 회원가입, 배송지추가
	public boolean insertAdd(AddressVO add);
	// 주소 조회
	public List<AddressVO> selectAddress(String id);
	// 주소 삭제
	public boolean deleteAddress(AddressVO add);

	// 기본 배송지 변경
	public boolean firstAddrChangeTrue(AddressVO add);
	public boolean firstAddrChangeFalse(String id);

	// sequence 주소조회
	public AddressVO selectAddrBySeq (int addrNo);

}
