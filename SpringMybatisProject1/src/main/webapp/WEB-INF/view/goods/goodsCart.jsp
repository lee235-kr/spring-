<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
  function checkQty(prodNum ,prodPrice , cartQty){
 		if(cartQty > 1){
			location.href="goodsCartQtyDown?prodNum="+prodNum+"&prodPrice="+prodPrice;
		}else{
			alert("최소 수량이1이어야합니다.");
			return false;	
		}
	}
  	function prodChk(){
  		var prodTot=0;
  		var chk=document.getElementsByName("prodCk");//check를 배열로 만들어줌 !!~!
  		var hddchk = document.getElementsByName("cartPrice");
  		var cnt = 0;
  		for(var i=0;i< chk.length;i++){
  			if(chk[i].checked==true){
  				prodTot +=Number(hddchk[i].value);
  				cnt ++;
  			}
  		}	
  		document.getElementById("totalPrice").innerHTML=prodTot;
  		document.getElementById("prodCnt").innerHTML=cnt;
  	}
  	function selectedDel(){
  		var chk = document.getElementsByName("prodCk");
  		var prodNums='';
  		for(var i = 0;i < chk.length ; i++){
  			if(chk[i].checked){
  			prodNums += chk[i].value+",";
  
  			}
    	}	
  	  location.href="goodsCartRemove?prodNums="+prodNums;
  	}		
  	function goodsCheck(){
		var chk = document.getElementsByName("prodCk");
		var cnt = 0;
		for(var i = 0; i < chk.length ; i ++){
			if(chk[i].checked){
				cnt++;
			}
		}
		if(cnt <= 0){
			alert("구매하시려면 적어도 하나 이상 상품을 선택하셔야 합니다.");
			return false;
		}
	}
</script>
</head>
<body>
카트페이지입니다.
<form action="goodsBuy" method="post" onsubmit="return goodsCheck();">
	<tr><td colspan="8">
	<button type="button" id = "cartDel" onclick="selectedDel()">선택항목 삭제</button></td> <!-- 추가적으로 선생님이 알려주는 부분  -->
	</tr>
	
<c:set var="price" value="0"/><!-- 자바변수 생성 -->
<c:set var="cnt" value="0" />
<c:forEach items="${lists }" var="dto">


<table border=1 width =800 align="center">
	<tr><td colspan="4">
		<input type="checkbox" value="${dto.cartDTO.prodNum }"		
		name="prodCk" onchange="prodChk();" checked/>
		<input type="hidden" name="cartPrice" 
			value="${dto.cartDTO.cartPrice + dto.productDTO.prodDelFee}"/>
		${dto.productDTO.prodSupplyer }</td>
		<td>적용금액</td>
		<td>배송비</td>
		<td>총 적용금액</td>
		<td rowspan="2"><input type="button" value="삭제"
		 onclick="javascript:location.href='cartProdDel?prodNum=${dto.cartDTO.prodNum }'"/>
						
		</td>
		</tr>
	<tr><td>
		<img src="../goods/upload/${dto.productDTO.prodImage.split(',')[0] }" 
			 width="200"/>
		</td><td>${dto.productDTO.prodName }</td>
	    <td >
	    <a href="javascript:checkQty('${dto.cartDTO.prodNum }','${dto.productDTO.prodPrice }',' ${dto.cartDTO.cartQty }')">-</a>
	     &nbsp;&nbsp; ${dto.cartDTO.cartQty }&nbsp;&nbsp;
	    	<a href="goodsCartAdd?prodNum=${dto.cartDTO.prodNum }&cartQty=1&&prodPrice=${dto.productDTO.prodPrice }">+</a>
	    </td>
	   <td><fmt:formatNumber value="${dto.productDTO.prodPrice }" type="currency"/>원
   </td>
   <td><fmt:formatNumber value="${dto.cartDTO.cartPrice }" type="currency"/>원
   </td>
   <td><fmt:formatNumber value="${dto.productDTO.prodDelFee }" type="currency"/>원
   </td>   
   <td><fmt:formatNumber value="${dto.cartDTO.cartPrice + dto.productDTO.prodDelFee}" type="currency"/>원</td>   
   </tr>
</table>
<c:set var="cnt" value="${cnt= cnt+1 }" />
<c:set var="price" value="${dto.cartDTO.cartPrice + dto.productDTO.prodDelFee + price }" />
</c:forEach>
<span id="prodCnt">${cnt }</span>개의 상품<br />
총금액 : <span id="totalPrice"><fmt:formatNumber value="${price }" type="currency"/>원</span>
<input type="submit" value="구매하기"/> 
</form>
</body>
</html>