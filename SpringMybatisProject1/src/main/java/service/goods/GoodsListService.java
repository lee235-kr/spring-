package service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.GoodsDTO;
import Model.StartEndPageDTO;
import repository.GoodsRepository;

public class GoodsListService {
	@Autowired
	GoodsRepository goodsRepository;
	public void goodsList(Model model) {
		
		/*int limit=5;//페이지당 몇개 보여줄지 정해준다
		int limitPage=10;//페이지 개수를 정의해줌 
		
	//	Long startRow=((long)page-1)*limit+1;
		Long endRow=startRow+limit-1;
		StartEndPageDTO sep=new StartEndPageDTO();
		sep.setStartRow(startRow);
		sep.setEndRow(endRow);
		*/
		
		List<GoodsDTO> list=goodsRepository.goodsList();
		model.addAttribute("lists",list);
	}
}
