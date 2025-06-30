package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.AddressVO;

public interface AddressMapper {
	public int insertAdd(AddressVO add);
	
	// 주소 조회
	public List<AddressVO> selectAddress(String id);
	// 기본배송지가 true인지 false인지 조회
	public int firstAddrUpdate(String id);
	// 주소 삭제
	public int deleteAddress(AddressVO add);

	// 기본 배송지 변경
	public int firstAddrChangeTrue(AddressVO add);
	public int firstAddrChangeFalse(String id);

	// 주소조최 by 시퀀스
	public AddressVO selectAddrBySeq(int addrNo);

}
