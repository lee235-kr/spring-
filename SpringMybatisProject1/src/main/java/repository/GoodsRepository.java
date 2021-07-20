package repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.CartDTO;
import Model.GoodsDTO;
import Model.GoodsReviewsDTO;
import Model.OrderListDTO;
import Model.PaymentDTO;
import Model.ProductCartDTO;
import Model.PurchaseDTO;
import Model.ReviewDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	String namesapce="mapers.goodsMapper";
	String statement;
	public void cartRemove(Map<String, Object> condition) {
		statement = namesapce+ ".cartRemove";
		 sqlSession.delete(statement, condition);
	}
	public void cartProdDel(CartDTO dto) {
		statement = namesapce+ ".cartProdDel";
		 sqlSession.delete(statement, dto);
	}
	public GoodsReviewsDTO goodsReviews(String prodNum) {
		statement=namesapce+".goodsReviews";
		return sqlSession.selectOne(statement,prodNum);
	}
	public void reviewUpdate(ReviewDTO dto) {
		statement=namesapce+".reviewUpdate";
		sqlSession.update(statement,dto);
	}
	public ReviewDTO reviewInfo(ReviewDTO dto) {
		statement = namesapce	 + ".reviewInfo";
		return sqlSession.selectOne(statement, dto);
	}
	public void reviewWrite(ReviewDTO dto) {
		statement=namesapce+".reviewWrite";
		sqlSession.insert(statement,dto);
	}
	public void payment(PaymentDTO dto) {
		statement=namesapce+".payment";
		sqlSession.insert(statement,dto);
	}
	public List<OrderListDTO>baseOrderList(String memId){
		statement = namesapce	 + ".baseOrderList";
		return sqlSession.selectList(statement, memId);
	}
	public void cartDelete(CartDTO dto) {
		statement=namesapce+".cartDelete";
		sqlSession.delete(statement,dto);
	}
	public int purchaseListInsert(CartDTO dto) {
		statement = namesapce	 + ".purchaseListInsert";
		return sqlSession.insert(statement, dto);
	}
	public void purchaseInsert(PurchaseDTO dto) {
		statement=namesapce+".purchaseInsert";
		sqlSession.update(statement,dto);
	}
	public void goodsQtyDown(CartDTO dto) {
		statement=namesapce+".goodsQtyDown";
		sqlSession.update(statement,dto);
	}
	public  ProductCartDTO cartList(CartDTO dto) {
		statement=namesapce+".cartList";
		return sqlSession.selectOne(statement, dto);
	}
	public List<String> memProdNum(String memId){
		statement=namesapce+".memProdNum";
		return sqlSession.selectList(statement,memId);
	}
		
	public int cartAdd(CartDTO dto) {
		statement=namesapce+".cartAdd";
		return sqlSession.insert(statement, dto);
	}
	public void goodsDel(String prodNum) {
		statement=namesapce+".goodsDel";
		sqlSession.update(statement,prodNum);
		
	}
	public  void goodsUpdate(GoodsDTO dto) {
		statement=namesapce+".goodsUpdate";
		sqlSession.update(statement,dto);
	}
	public GoodsDTO goodsDetail(String prodNum) {
		statement=namesapce+".goodsDetail";
		return sqlSession.selectOne(statement,prodNum);
	}
	public void goodsWrite(GoodsDTO dto) {
		statement=namesapce+".goodsWrite";
		sqlSession.insert(statement,dto);
		
	}
	public int goodsNum() {
		statement=namesapce+".goodsNum";
		return sqlSession.selectOne(statement);
	}
	public List<GoodsDTO> goodsList() {
		statement=namesapce+".goodsList";
		return sqlSession.selectList(statement);
	}
}
