package service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Model.AuthInfoDTO;
import Model.GoodsDTO;
import command.GoodsCommand;
import repository.GoodsRepository;

public class GoodsWriteService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsWrite(GoodsCommand goodsCommand,HttpSession session) {
	GoodsDTO dto=new GoodsDTO();
	dto.setCtgr(goodsCommand.getCtgr());
	dto.setProdCapacity(goodsCommand.getProdCapacity());
	dto.setProdDetail(goodsCommand.getProdDetail());
	dto.setProdDelFee(goodsCommand.getProdDelFee());
	dto.setProdName(goodsCommand.getProdName());
	dto.setProdNum(goodsCommand.getProdNum());
	dto.setProdPrice(goodsCommand.getProdPrice());
	dto.setProdSupplyer(goodsCommand.getProdSupplyer());
	dto.setRecommend(goodsCommand.getRecommend());
	
	AuthInfoDTO authInfo=(AuthInfoDTO)session.getAttribute("authInfo");
	String employeeId = authInfo.getGrade();
	dto.setEmployeeId(employeeId);
	
	// 디비에 파일명만 저장하기 위해 OriginalFilename을 가져와서 확장자를 추출 
	String prodImage="";
	if(!goodsCommand.getProdImage()[0].getOriginalFilename().equals("")) {
	for(MultipartFile mf:goodsCommand.getProdImage()) {
		//확자를 알기위해서 
		String original=mf.getOriginalFilename();
		//original에서 확장자만 추출
		String originalExt=original.substring(original.lastIndexOf("."));
		String store=UUID.randomUUID().toString().replace("-", "")+originalExt ;
		//디비에 저장할 파일명을 추출하여 prodImage에 저장
		prodImage+= store +  ",";
		//파일을 시스템에 저장
		String filePath=
				session.getServletContext().getRealPath("WEB-INF/view/goods/upload");
		File file =new File(filePath+"/"+store);
		try {mf.transferTo(file);
		} catch (Exception e) {	e.printStackTrace();}
	}
	dto.setProdImage(prodImage);
	}
	goodsRepository.goodsWrite(dto);
	}
}
