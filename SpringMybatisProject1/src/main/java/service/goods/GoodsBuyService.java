package service.goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.CartDTO;
import Model.ProductCartDTO;
import repository.GoodsRepository;
public class GoodsBuyService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsBuy(String [] prodNums,HttpSession session
			,Model model) {
		AuthInfoDTO authInfo=(AuthInfoDTO)session.getAttribute("authInfo");
		String memId =authInfo.getUserId();    
		List<ProductCartDTO> list = new ArrayList<ProductCartDTO>();
		for(String prodNum : prodNums )  {
					CartDTO dto =new CartDTO();
					dto.setMemId(memId);
					dto.setProdNum(prodNum);
	//카트리스트서 사용했던 정보를 사용 코드 그대로 적용.				
					ProductCartDTO productCartDTO=goodsRepository.cartList(dto);
					list.add(productCartDTO);
		}
		model.addAttribute("lists",list);   
	}
}
