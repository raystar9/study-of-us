<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>

	$(document).ready(function(){
    	commentList(); //페이지 로딩시 댓글 목록 출력 
	});
	
	
	//var bno = '${detail.bno}';	//게시글 번호
	
	$('[name=commentInsertBtn]').click(function(){
		var insertData = $('[name=commentInsertForm]').serialize();
		commentInsert(insertData);
	});

	function commentList(){
		var num = params.split('&').map(function(i) { 
		    return i.split('=');
		}).reduce(function(memo, i) { 
		    memo[i[0]] = i[1] == +i[1] ? parseFloat(i[1],10) : decodeURIComponent(i[1]); 
		    return memo;
		}, {});
		
	    $.ajax({
	        url : '/study-of-us/commentlist',
	        type : 'post',
	        data: num,
	        success : function(data){
	            var a =''; 
	            $.each(data, function(value){ 
	                a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
	                a += '작성자 : '+value.name + '날짜: ' + value.date;
	                a += '<a onclick="commentUpdate('+value.cno+',\''+value.content+'\');"> 수정 </a>';
	                a += '<a onclick="commentDelete('+value.cno+');"> 삭제 </a> </div>';
	                a += '<div class="commentContent'+value.cno+'"> <p> 내용 : '+value.content +'</p>';
	                a += '</div></div>';
	            });
	            
	            $(".commentList").html(a);
	        }
	    });
	}
	 
	//댓글 등록
	function commentInsert(insertData){
	    $.ajax({
	        url : '/commentinsert',
	        type : 'post',
	        data : insertData,
	        success : function(data){
	            if(data == 1) {
	                commentList(); //댓글 작성 후 댓글 목록 reload
	                $('[name=content]').val('');
	            }
	        }
	    });
	}
	 
	//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
	function commentUpdate(cno, content){
	    var a ='';
	    a += '<div class="input-group">';
	    a += '<input type="text" class="form-control" name="content_'+cno+'" value="'+content+'"/>';
	    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+cno+');">수정</button> </span>';
	    a += '</div>';
	    
	    $('.commentContent'+cno).html(a);
	    
	}
	 
	//댓글 수정
	function commentUpdateProc(cno){
	    var updateContent = $('[name=content_'+cno+']').val();
	    
	    $.ajax({
	        url : '/commentupdate',
	        type : 'post',
	        data : {'content' : updateContent, 'cno' : cno},
	        success : function(data){
	            if(data == 1) commentList(bno); //댓글 수정후 목록 출력 
	        }
	    });
	}
	 
	//댓글 삭제 
	function commentDelete(cno){
	    $.ajax({
	        url : '/commentsdelete',
	        type : 'post',
	        success : function(data){
	            if(data == 1) commentList(bno); //댓글 삭제후 목록 출력 
	        }
	    });
	}

</script>


