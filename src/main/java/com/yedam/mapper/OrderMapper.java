package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.AddressVO;

public interface OrderMapper {
	//기본주소
	public List<AddressVO> selectFirstAddress(String userId);
}
