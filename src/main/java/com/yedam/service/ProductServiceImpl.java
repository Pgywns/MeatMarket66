package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ProductMapper;
import com.yedam.vo.ProductVO;

public class ProductServiceImpl implements ProductService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
	
	@Override
	public List<ProductVO> productList() {
		
		return mapper.selectList();
	}

}
