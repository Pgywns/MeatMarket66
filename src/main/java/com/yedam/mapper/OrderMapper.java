package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.AddressVO;
import com.yedam.vo.CartVO;
import com.yedam.vo.OrderVO;

public interface OrderMapper {
	//기본주소
	public List<AddressVO> selectFirstAddress(String userId);
	//주문테이블등록
	public int insesrtOrderForm(OrderVO form);
	//주문번호 추출
	public int selectOrderNo(String userId);
	//주문목록 출력
	public List<CartVO> selectOrderList(String userId);
	//주문상세등록
	public int insertOrderInfo(@Param("odNo")int odNo, @Param("prdNo")int prdNo, @Param("orderQty")int orderQty);
	//출고재고등록
	public int insertOutStock(@Param("prdNo")int prdNo, @Param("orderQty")int orderQty);
	//포인트적립
	public int insertAddPoint(@Param("userId")String userId, @Param("addPoint")int addPoint);
	
}
