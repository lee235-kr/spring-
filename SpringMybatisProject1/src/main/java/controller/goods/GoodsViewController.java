package controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.goods.GoodsReviewService;


//해당하는 정보가 날라와야하니까 리퀘스트 파람을 사용해서 불러움
@Controller
@RequestMapping("prod")
public class GoodsViewController {
	@Autowired
	GoodsReviewService goodsReviewService;
	@RequestMapping("goodsView")
	public String goodsView(
			@RequestParam(value="prodNum")String prodNum,Model model) {
		goodsReviewService.goodsReviews(prodNum,model);
		return "goods/goodsView";
	}
}
