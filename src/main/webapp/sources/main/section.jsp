<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<style>
.rankcard {
margin-left: 70px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    transition: 0.3s;
    width: 15%;
    display: inline-block;
}

.ranking {
	margin-bottom: 100px;
}

</style>


<div class="all">
<div class="bg-img">
<div class=main-writing>
   <h1>Don't be too timid and <br>
   squeamish about your actions.<br>
    All life is an experiment.<br>
     The more experiments you make the better.</h1>
</div>
  <form action="LoginPage" method="post">
    <div class="container">
      <h1>Login</h1>
      <label for="id"><b>ID</b></label>
      <input type="text" placeholder="Enter Email" name="id" id="id" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="password" required>

      <button type="submit" class="btn">Login</button>
      
      </div>
  </form>
</div>
</div>

