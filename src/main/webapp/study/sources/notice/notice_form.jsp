<!-- 해당 스터디 안에 들어왔을 때 처음으로 보이는 공지사항 페이지 -->
<!-- 스터디 안의 게시판 리스트 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 페이지</title>
</head>
<body>
   <!-- 게시판 리스트 -->
   <table border='1'>
   <!-- 레코드가 있으면 -->
      
      <tr>
         <th width="8%"><div>번호</div></th>
         <th width="50%"><div>제목</div></th>
         <th width="14%"><div>작성자</div></th>
         <th width="17%"><div>날짜</div></th>
         <th width="11%"><div>조회수</div></th>
      </tr>
      <c:set var="num" value="${listcount-(page-1)*10 }"/>
       <c:forEach var ="b" items="${boardlist}">
         <tr>
            <td>
               <c:out value="${num }"></c:out>
               <c:set var="num" value = "${num-1}"/>
            </td>
            <td>
               <div>
               <%--답변글 제목앞에 여백 처리 부분
                     BOARD_RE_LEV, BOARD_RE_LEV, BOARD_NUM, BOARD_SUBJECT, BOARD_NAME,
                      BOARD_DATE, BOARD_RE_READCOUNT,BOARD_DATE --%>
               <c:if test = "${b.BOARD_RE_LEV != 0 }" >
                    <!-- 답글인 경우 -->
                    
                  <c:forEach var ="a" begin = "0" end= "${b.BOARD_RE_LEV*2 }" step = "1">
                  &nbsp;
                  </c:forEach>
                        ▶   
               </c:if>
               
               <c:if test="${b.BOARD_RE_LEV == 0}">
               <!-- 원문인 경우 -->
                  &nbsp; ▶
               </c:if>
               <a href="./BoardDetailAction.bo?num=${b.BOARD_NUM}">
                  ${b.BOARD_SUBJECT}
               </a>
               </div>
            </td>
            <td>
               <div>${b.BOARD_NAME}</div>
            </td>
            <td>
               <div>${b.BOARD_DATE}</div>
            </td>
            <td>
               <div>${b.BOARD_READCOUNT}</div>
            </td>
         </tr>
      </c:forEach>
      
      <tr class="h30 lime center btn">
      	<td colspan='5'>
      		<c:if test="${page <= 1 }">
      		이전&nbsp;
      		</c:if>
      		<c:if test="${page > 1 }">
      			<a href="./BoardList.bo?page=${page-1}">이전</a>&nbsp;
      		</c:if>
      		
      		<c:forEach var="a" begin="${startpage }" end="${endpage }">
      			<c:if test = "${a == page}">
      				${a}
      			</c:if>
      			<c:if test = "${a != page }">
      				<a href="./BoardList.bo?page=${a}">${a}</a>
      			</c:if>
      		</c:forEach>
      		
      		<c:if test="${page >= maxpage}">
      			&nbsp;다음
      		</c:if>
      		<c:if test="${page < maxpage }">
      			<a href="./BoardList.bo?page=${page+1}">&nbsp;다음</a>
      		</c:if>
      	</td>
      </tr>
      
   
   <!-- 레코드가 없으면 -->
      <c:if test="${listcount == 0 }">
         <tr>
            <td colspan="4">MVC 게시판</td>
            <td style = "test-align:right">
               <font size=2>등록된 글이 없습니다.</font>
            </td>
         </tr>
      </c:if>
      
   </table>
</body>
</html>
