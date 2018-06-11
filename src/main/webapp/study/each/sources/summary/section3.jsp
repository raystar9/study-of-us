<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
    box-sizing: border-box;
}

body {
    background-color: #474e5d;
    font-family: Helvetica, sans-serif;
}

/* The actual timeline (the vertical ruler) */
.timeline {
    position: relative;
    max-width: 1200px;
    margin: 0 auto;
}

/* The actual timeline (the vertical ruler) */
.timeline::after {
    content: '';
    position: absolute;
    width: 6px;
    background-color: white;
    top: 0;
    bottom: 0;
    left: 50%;
    margin-left: -3px;
}

/* Container around content */
.container {
    padding: 10px 40px;
    position: relative;
    background-color: inherit;
    width: 50%;
}

/* The circles on the timeline */
.container::after {
    content: '';
    position: absolute;
    width: 25px;
    height: 25px;
    right: -17px;
    background-color: white;
    border: 4px solid #FF9F55;
    top: 15px;
    border-radius: 50%;
    z-index: 1;
}

/* Place the container to the left */
.left {
    left: 0;
}

/* Place the container to the right */
.right {
    left: 50%;
}

/* Add arrows to the left container (pointing right) */
.left::before {
    content: " ";
    height: 0;
    position: absolute;
    top: 22px;
    width: 0;
    z-index: 1;
    right: 30px;
    border: medium solid white;
    border-width: 10px 0 10px 10px;
    border-color: transparent transparent transparent white;
}

/* Add arrows to the right container (pointing left) */
.right::before {
    content: " ";
    height: 0;
    position: absolute;
    top: 22px;
    width: 0;
    z-index: 1;
    left: 30px;
    border: medium solid white;
    border-width: 10px 10px 10px 0;
    border-color: transparent white transparent transparent;
}

/* Fix the circle for containers on the right side */
.right::after {
    left: -16px;
}

/* The actual content */
.content {
    padding: 20px 30px;
    background-color: white;
    position: relative;
    border-radius: 6px;
}

/* Media queries - Responsive timeline on screens less than 600px wide */
@media screen and (max-width: 600px) {
  /* Place the timelime to the left */
  .timeline::after {
    left: 31px;
  }
  
  /* Full-width containers */
  .container {
    width: 100%;
    padding-left: 70px;
    padding-right: 25px;
  }
  
  /* Make sure that all arrows are pointing leftwards */
  .container::before {
    left: 60px;
    border: medium solid white;
    border-width: 10px 10px 10px 0;
    border-color: transparent white transparent transparent;
  }

  /* Make sure all circles are at the same spot */
  .left::after, .right::after {
    left: 15px;
  }
  
  /* Make all right containers behave like the left ones */
  .right {
    left: 0%;
  }
}
</style>
</head>
<body>
	<form action="/study-of-us/study/Studylist" method="get">
		
			<div class="timeline">
  <div class="container left">
    <div class="content">
      <h2>스터디 이름</h2>
      <p>${study[0].name }</p>
    </div>
  </div>
  <div class="container right">
    <div class="content">
      <h2>스터디 기간</h2>
      <p>${study[0].start } - ${study[0].end }</p>
    </div>
  </div>
  <div class="container left">
    <div class="content">
      <h2>스터디 개요</h2>
      <p>${study[0].explain }</p>
    </div>
  </div>
  <div class="container right">
    <div class="content">
      <h2>스터디 기대 및 효과</h2>
      <p>${study[0].effect }</p>
    </div>
  </div>
  <div class="container left">
    <div class="content">
      <h2>교재 및 준비물</h2>
      <p>${study[0].material }</p>
    </div>
  </div>
  <div class="container right">
    <div class="content">
      <h2>모집인원</h2>
      <p>${study[0].maxmember } 명</p>
    </div>
  </div>
</div>
	


		<input type="hidden" name="s_index" value=${study[0].index }>
		<input type="hidden" name="m_index" value=${index }> 
		<input type="hidden" name="s_m_index" value=${study[0].s_m_index }>
		<input type="hidden" name="s_name" value="${study[0].name }">

	</form>
</body>
</html>