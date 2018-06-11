<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
h1 {
  text-align: center;
  padding: 20px 0;
}

.table-bordered {
  border: 1px solid #ddd !important;
}

table caption {
	padding: .5em 0;
}

@media screen and (max-width: 767px) {
  table caption {
    display: none;
  }
}

.p {
  text-align: center;
  padding-top: 140px;
  font-size: 14px;
}

</style>

<head>
  <title>Harvest vase</title>
  
</head>

<body>
<h1>${study[0].name }</h1>

<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <div class="table-responsive" data-pattern="priority-columns">
        <table summary="This table shows how to create responsive tables using RWD-Table-Patterns' functionality" class="table table-bordered table-hover">
          <thead>
      
          </thead>
          <tbody>
            <tr>
              <th>스터디 개요</th>
              <td colspan="3">${study[0].explain }</td>
            </tr>
            
             <tr>
              <th>스터디 기대 및 효과</th>
              <td colspan="3">${study[0].effect }</td>
            </tr>
            
             <tr>
              <th>교재 및 준비물</th>
              <td colspan="3">${study[0].material }</td>
            </tr>
            
            <tr>
              <th>모집인원</th>
              <td colspan="3">${study[0].maxmember } 명</td>
            </tr>
            
            <tr>
              <th>활동시간</th>
              <td colspan="3">${study[0].time}</td>
            </tr>
            
            <tr>
              <th>활동시간</th>
              <td colspan="3">${study[0].time}</td>
            </tr>
             <tr>
              <th>요일</th>
              <td colspan="3">${study[0].day }</td>
            </tr>
             <tr>
              <th>스터디 지역</th>
              <td colspan="3">${study[0].place }</td>
            </tr>
          </tbody>
          <tfoot>
            <tr>
              <td colspan="5" class="text-center">	<input type=submit value='스터디 참여하기'></td>
            </tr>
          </tfoot>
        </table>
      </div><!--end of .table-responsive-->
    </div>
  </div>
</div>

<p class="p">Study-of-us SOUP. <a href="=/study-of-us/study/home" target="_blank">See article</a>.</p>
</body>

</html>