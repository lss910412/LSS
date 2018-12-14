<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <!-- 헤더 css / jquery cdn -->
  <%@ include file="/include/header.jsp" %>
  

</head>

<script>
$(document).ready(function(){
	
		//url 에서 parameter 추출
		currentPage = getParam("currentPage");
		if(currentPage == "") currentPage = 1;
		console.log("-" + currentPage + "-");
		
		//페이지 로드 시 바로 실행
		goPaging(currentPage);
}); 


function goPaging(currentPage) {
	if (navigator.geolocation) { 
	   	navigator.geolocation.getCurrentPosition(
	    		function(position) {
		    					mylat = position.coords.latitude;
	    		    		mylng = position.coords.longitude;
	    		    		
	    		    		var sendData = {"lat":mylat , "lng":mylng, "topn":-1, "currentPage":currentPage};
	    		    		listDefaultLatLng(sendData);
		    					
	    		} , 
				  function(error) {
		    			//alert('위치 정보를 받는 중 에러가 발생했습니다. 시청 위경도 기준으로 거리계산합니다. ');
					  	mylat = 37.335887; 
							mylng = 126.584063;
							sendData = {"lat":mylat , "lng":mylng, "topn":-1,  "currentPage":currentPage};		
		    			listDefaultLatLng(sendData);
				  } , 
				  {
				      enableHighAccuracy: false,
				      maximumAge: 0,
				      timeout: Infinity
				  }
	    );
  } else {
	  	alert('GPS를 지원하지 않습니다 . 시청 위경도 기준으로 거리계산합니다.');
	  	mylat = 37.335887; 
			mylng = 126.584063;
			sendData = {"lat":mylat , "lng":mylng, "topn":-1,  "currentPage":currentPage};		
			listDefaultLatLng(sendData);
  } 
}



//url 에서 parameter 추출
function getParam(sname) {
		var params = location.search.substr(location.search.indexOf("?") + 1);
		var sval = "";
		params = params.split("&");
		for (var i = 0; i < params.length; i++) {
		temp = params[i].split("=");
		if ([temp[0]] == sname) { sval = temp[1]; }
		}
		return sval;
}

function listDefaultLatLng(sendData) {
		$.ajax({ 
			url:"/shop",   
			type:"post",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: "MYKEY="+JSON.stringify(sendData),
			resultType:"json",
			success:function(resMap){
					console.log(resMap);		//객체
					var htmlStr = "";
					var pagingStr = resMap.MAP_PAGING;
					var maplist 	= resMap.MAP_LIST;
		 			$.map(maplist, function(vv, idx){
			  		htmlStr += "<li class='media'>";
		 				htmlStr += "<img class='mr-3 rounded-circle' width='50' src='/cdir/" + vv.shopPicVO.pname + "' alt='"+vv.shopPicVO.pname+"'>";
		 				htmlStr += "<div class='media-body'>";
		 				htmlStr += "<div class='float-right'><small>" + vv.distance +  " km </small></div>";
		 				htmlStr += "<div class='media-title'><a href='/shop_detail?sseq="+vv.sseq+"'>" + vv.sname + "</a></div>";
		 				htmlStr += "<small>" + vv.sinfo + "</small>";
		 				htmlStr += "</div>";
		 				htmlStr += "</li>";
			  	});
		 			htmlStr += pagingStr;
		 			
		 			//div는 남겨두고 기존 내용만 지우기
				  $(".list-unstyled.list-unstyled-border").empty();
		 			$(".list-unstyled.list-unstyled-border").html(htmlStr);
			} //end of success
		}); 
}

</script>

<body>
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>
      
      <!-- 상단 검색창 -->
      <%@ include file="/include/top.jsp" %>
      
      <!-- 레프트 메뉴 영역 -->
      <%@ include file="/include/left.jsp" %>
      
      <!-- 컨텐츠 영영 -->
      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>맛집 전체목록 보기--- <a href="/shop_form.jsp">[글쓰기]</a></div>
          </h1>

          <div class="section-body">
            <div class="row">
             <div class="col-12">
              <div class="card">
               
                <div class="card-body" >             
 <ul class="list-unstyled list-unstyled-border">
 
 <!-- ----------- jQuery에서 완성될 html 영역 --------------------------------------------------------------------------------------- -->
 </ul>
                </div>
              </div>
            </div>
              
            </div> 	<!-- end of row -->
          </div>		<!-- end of section-body -->
          
        </section>
      </div>				<!-- end of main-content -->
      
    	<!-- 푸터 영역 -->
      <%@ include file="/include/footer.jsp" %>
      
    </div>
  </div>

  <!-- 스크립트 영역 -->
  <%@ include file="/include/script.jsp" %>
  
</body>
</html>