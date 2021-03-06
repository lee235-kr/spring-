package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsOrderCommand;
import command.ReviewCommand;
import service.goods.CartProdDeleteService;
import service.goods.DoPaymentService;
import service.goods.GoodsBuyService;
import service.goods.GoodsCartAddService;
import service.goods.GoodsCartListService;
import service.goods.GoodsCartQtyDownService;
import service.goods.GoodsCartRemove;
import service.goods.GoodsOrderService;
import service.goods.GoodsReviewUpdateService;
import service.goods.OrderProcessListService;
import service.goods.ReviewWriteService;

@Controller
@RequestMapping("cart")
public class GoodsCartController {
	@Autowired
	GoodsCartAddService goodsCartAddService;
	@Autowired
	GoodsCartListService goodsCartListService;
	@Autowired
	GoodsCartQtyDownService goodsCartQtyDownService;
	@Autowired
	GoodsBuyService goodsBuyService;
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	OrderProcessListService orderProcessListService;
	@Autowired
	DoPaymentService doPaymentService;
	@Autowired
	ReviewWriteService reviewWriteService;
	@Autowired
	GoodsReviewUpdateService goodsReviewUpdateService;
	@Autowired
	CartProdDeleteService cartProdDeleteService;
	@Autowired
	GoodsCartRemove goodsCartRemove;
	@RequestMapping("goodsCartRemove")
	public String goodsCartRemove(@RequestParam(value="prodNums")String prodNums,HttpSession session) {
		goodsCartRemove.cartRemove(prodNums, session);
		return "redirect:goodsCartList";
	}
	@RequestMapping("cartProdDel")
	public String cartProdDel(@RequestParam(value="prodNum")String prodNum ,HttpSession session) {
		cartProdDeleteService.cartProdDel(prodNum,session);	
		return "redirect:goodsCartList";
	}
	@RequestMapping("reviewUpdate")
	public String reviewUpdate(ReviewCommand reviewCommand) {	
		goodsReviewUpdateService.reviewUpdate(reviewCommand);
		return "redirect:OrderProcessList";
	}
	@RequestMapping("goodsReviewUpdate")
	public String reviewUpdate(
			@RequestParam(value="purchaseNum")String purchaseNum,
			@RequestParam(value="prodNum")String prodNum,
			HttpSession session,Model model) {
		goodsReviewUpdateService.reviewInfo(purchaseNum, prodNum, session, model);
			return "goods/goodsReviewModify";
	}
	@RequestMapping(value="reviewWrite",method=RequestMethod.POST )
	public String reviewWrite(ReviewCommand reviewCommand,HttpSession session) {
		reviewWriteService.reviewWrite(reviewCommand,session);
		return "redirect:OrderProcessList";
	}
	@RequestMapping("goodsReview")
	public String goodsReview(
			@ModelAttribute(value="purchaseNum")String purchaseNum,
			@ModelAttribute(value="prodNum")String prodNum) {
		
		return "goods/goodsReview";
	}
	@RequestMapping("aaa")
	public String aaa() {
	
		return "main/main";
	}
	@RequestMapping(value="doPayment",  method = RequestMethod.POST)
	public String doPayment(
			@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value = "paymentApprPrice") String paymentApprPrice,
			@RequestParam(value = "paymentNumber") String paymentNumber,
			HttpSession session,Model model) {
		doPaymentService.payment(purchaseNum,paymentApprPrice,
				paymentNumber, session, model);
		return "goods/buyfinish";
	}
	
	@RequestMapping("OrderProcessList")
	public String OrderProcessList(HttpSession session,Model model) {
		orderProcessListService.orderList(session,model);
		return "goods/purchaseCon";
	}
	@RequestMapping("goodsOrder")
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand,
			HttpSession session) {
		//GoodsOrderCommand??? ??????????????? ?????? ?????? ???????????? ???????????????
		String purchaseNum = 
				goodsOrderService.goodsOrder(goodsOrderCommand, session);
		return "redirect:paymentOk?purchaseNum="+purchaseNum 
						+"&payPrice="+goodsOrderCommand.getPurchaseTotPrice();
	}
	@RequestMapping("paymentOk")
	public String paymentOk(
			@ModelAttribute(value="purchaseNum") String purchaseNum,
			@ModelAttribute(value="payPrice") String payPrice) {
		return "goods/payment";
	}
	@RequestMapping(value="goodsBuy",method = RequestMethod.POST)
		public String goodsBuy(
				@RequestParam(value="prodCk")String [] prodNums,
				HttpSession session,Model model) {
		goodsBuyService.goodsBuy(prodNums, session, model);	
		return "goods/order";
		}
	
	@RequestMapping("goodsCartList")
	public String goodsCartList(HttpSession session,Model model) {
		goodsCartListService.cartList(session, model);
		return "goods/goodsCart";
	}
	@RequestMapping(value="goodsCartQtyDown",method = RequestMethod.GET)
	public String goodsCartQtyDown( 
			@RequestParam(value="prodNum") String prodNum,
			@RequestParam(value="prodPrice") int prodPrice,
			HttpSession session)
	{
		goodsCartQtyDownService.goodsQtyDown(prodNum, prodPrice,session);
		return "redirect:goodsCartList";	
	}
	@RequestMapping(value = "goodsCartAdd" ,method = RequestMethod.GET)
	public String goodsCartQtyAdd(
			@RequestParam(value="cartQty") int cartQty,
			@RequestParam(value="prodNum") String prodNum,
			@RequestParam(value="prodPrice") int prodPrice,
			Model model,HttpSession session)  {
		goodsCartAddService.cartAdd(cartQty, prodNum,prodPrice,session,model);
		return "redirect:goodsCartList";
		
	}
	@RequestMapping(value = "goodsCartAdd" ,method = RequestMethod.POST)
	public String goodsCartAdd(
			@RequestParam(value="cartQty") int cartQty,
			@RequestParam(value="prodNum") String prodNum,
			@RequestParam(value="prodPrice") int prodPrice,
			Model model,HttpSession session) {
		goodsCartAddService.cartAdd(cartQty, prodNum,prodPrice,session,model);
		return "goods/cartAdd";
	}

}
