package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class AddProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// 1. 임시 저장 경로
	    String tempPath = req.getServletContext().getRealPath("img/productList/temp");

	    // 2. MultipartRequest로 먼저 요청 처리 (임시 저장소에)
	    MultipartRequest mr = new MultipartRequest(
	        req,
	        tempPath,
	        1024 * 1024 * 5,
	        "UTF-8",
	        new DefaultFileRenamePolicy()
	    );

	    // 3. 파라미터 추출
	    String category = mr.getParameter("pCategory");
	    String pName = mr.getParameter("pName");
	    String pContent = mr.getParameter("pContent");
	    String price = mr.getParameter("pPrice");
	    String img = mr.getFilesystemName("pFile");

	    // 4. 실제 경로로 파일 이동
	    String realPath = req.getServletContext().getRealPath("img/productList/" + category);
	    java.io.File folder = new java.io.File(realPath);
	    if (!folder.exists()) {
	        folder.mkdirs(); // 없으면 디렉토리 생성
	    }
  
	    java.io.File oldFile = new java.io.File(tempPath, img);
	    java.io.File newFile = new java.io.File(realPath, img);
	    oldFile.renameTo(newFile); // 이동

		ProductVO product = new ProductVO();
		product.setPrdName(pName);
		product.setPrdContent(pContent);
		product.setPrdPrice(Integer.parseInt(price));
		product.setPrdSort(category);
		product.setPrdImage(img);
		
		ProductService svc = new ProductServiceImpl();
			
		if (svc.addProduct(product) && svc.firstStock(0)) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}		
	}

}
