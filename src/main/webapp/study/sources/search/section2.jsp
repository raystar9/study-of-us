<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	

     
     <script>
     $(document).ready(function(){
    	 $(document).on("click",".atag1",function(e){
     		e.preventDefault();
     		var page = $(this).text()
     		var place = $("#place").val();
     		
     		$.ajax({
     				type : "get",
     				data : {"page" : page, "check" : place , "state" : "ajax"},
     				url  : "/study-of-us/study/search",	
     			   cache: false, 
     				success : function(rdata){
     					
     					$(".project").empty().append(rdata);
     				}
     			
     			})

     	});
      
      $(document).on("click","#atagNext",function(e){
  		e.preventDefault();
  		//var page=${page+1};
  		var page2=$("#page").val();
  		page2=parseInt(page2)+1;
  		var place = $("#place").val();
  		
  		$.ajax({
  				type : "get",
  				data : {"page" : page2, "check" : place, "state" : "ajax"},
  				url  : "/study-of-us/study/search",	
  			  headers : {"cache-control" : "no-cache", 
		    	       "pragma" : "no-cache"},
  				success : function(rdata){
  					$(".project").empty().append(rdata);
  				}
  			
  			})

  	});
      
      
      $(document).on("click","#atagPrevious",function(e){
  		e.preventDefault();
  		var place = $("#place").val();
  		var page2=$("#page").val();
  		page2=parseInt(page2)-1;
  		$.ajax({
  				type : "get",
  				data : {"page" : page2, "check" : place , "state" : "ajax"},
  				url  : "/study-of-us/study/search",	
  			   cache: false, 
  				success : function(rdata){
  					$(".project").empty().append(rdata);
  				}
  			
  			})

  	});
      
      
      $(document).on("click","#atagFirst",function(e){
  		e.preventDefault();
  		var page = 1
  		alert(page)
  		$.ajax({
  				type : "get",
  				data : {"page" : page, "check" : '${place}' , "state" : "ajax"},
  				url  : "/study-of-us/study/search",	
  			   cache: false, 
  				success : function(rdata){
  					$(".project").empty().append(rdata);
  				}
  			
  			})

  	});
      
      $(document).on("click","#atagLast",function(e){
   		e.preventDefault();
   		var page2 = $("#totalpage").val();

   		$.ajax({
   				type : "get",
   				data : {"page" : page2, "check" : '${place}' , "state" : "ajax"},
   				url  : "/study-of-us/study/search",	
   			   cache: false, 
   			    headers : {"cache-control" : "no-cache", 
   			    	       "pragma" : "no-cache"},
   				success : function(rdata){
   					$(".project").empty().append(rdata);
   				}
   			
   			})

   	});
      
      $(".projectcontainer").hover(
    			function(){
    				$(this).css('background','#333333bd')
    			},
    			function(){
    				$(this).css('background','#eee')
    			}
    			);
    			
    			$(".projectcontainer").click(function(){
    				location.href = "이동할 주소"
    			})
     })
     
     </script>
     <%@ taglib prefix="c"
 				uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="project">
		<c:forEach var="study" items="${studies }">
		<div class="projectcontainer">
		
  			<img src="/study-of-us/resources/images/open-book.png" alt="Avatar" style="width:90px">
 			 <H3>스터디 : ${study.name }</H3>
  			<p>목표 :  </p>
  			 <span>스터디 기간 :  스터디 위치 ${study.place}</span>
		</div>
	</c:forEach>
			<div class="paging"  style="text-align:center; margin-bottom:100px">
		<c:if test="${startpage > 1}">
			<a href="callFunctionFirst()"id=atagFirst>처음</a>
		</c:if>
		
		<c:if test="${page > 1}">
			<a href="javascript:callFunctionPrevious()"id=atagPrevious>이전</a>
		</c:if>
		
		<c:forEach var="i" begin= "${startpage }" end="${endpage }">
			<a href="" class=atag1>${i }</a>
		</c:forEach>
		
		<c:if test="${page < totalpage}">
			<a href="javascript:callFunctionNext()"id=atagNext>다음</a>
		</c:if>
		
		<c:if test="${endpage < totalpage}">
			<a href="javascript:callFunctionLast()"id=atagLast>끝</a>
		</c:if>
		</div>
		<input type="hidden" id="page" value="${page}"/>
		<input type="hidden" id="totalpage" value="${totalpage}"/>
		<input type="hidden" id="place" name="place2" value="${place}"/>
	</div>