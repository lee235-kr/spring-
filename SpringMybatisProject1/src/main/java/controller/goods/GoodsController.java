 package controller.goods;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsCommand;
import service.goods.CartProdDeleteService;
import service.goods.GoodsDeleteService;
import service.goods.GoodsDetailService;
import service.goods.GoodsListService;
import service.goods.GoodsNumberService;
import service.goods.GoodsUpdateService;
import service.goods.GoodsWriteService;
import validator.GoodsCommandValidate;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	GoodsNumberService goodsNumberService;
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsUpdateService goodsUpdateService;
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@Autowired
	CartProdDeleteService cartProdDeleteService;
	@RequestMapping("goodsDel")
	public String goodsDel(@RequestParam(value="prodNum")String prodNum,HttpSession session) {
		goodsDeleteService.goodsDel(prodNum,session);
		return "redirect:goodsList";
	}
	@RequestMapping("goodsUpdate")
	public String goodsUpdate(GoodsCommand goodsCommand,Errors errors ,HttpSession session) {
		new GoodsCommandValidate().validate(goodsCommand,errors);
		if(errors.hasErrors()) {
			return "goods/goodsModify";
		}
		goodsUpdateService.goodsUpdate(goodsCommand,session);
		return  "redirect:/goods/goodsList";
	}
	@RequestMapping("prodModify")//수정을 하려면 인풋타입이 있어야한다 
		public String prodModify(@RequestParam(value="prodNum")String prodNum,Model model) {
		goodsDetailService.goodsDetail( prodNum, model);
		return "goods/goodsModify";
		}
	@RequestMapping("prodDetail")
	public String prodDetail(@RequestParam(value="prodNum")String prodNum ,Model model) {
		goodsDetailService.goodsDetail( prodNum, model);
		return "goods/goodsDetail";
	}
	@RequestMapping(value="goodsJoin",method=RequestMethod.POST)
	public String join(GoodsCommand goodsCommand,Errors errors,HttpSession session) {
		new GoodsCommandValidate().validate(goodsCommand,errors);
		if(errors.hasErrors()) {
			return "goods/goodsJoin";
		}
		goodsWriteService.goodsWrite(goodsCommand,session);
		return"redirect:goodsList";
	}
	@RequestMapping("goodsList")
	public String list(Model model) {
		goodsListService.goodsList(model);
		return "goods/goodsList";
	}
@RequestMapping("goodsRegist")
	public String regist(Model model) {
	goodsNumberService.goodsNum(model);
	return "goods/goodsJoin";
}

}
