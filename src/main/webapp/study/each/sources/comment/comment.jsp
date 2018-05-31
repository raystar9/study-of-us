<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	var pandan = 0; //댓글 열고 접는 판단 변수
	$(function() {
		$('#commentInsertBtn').click(function() {
			var insertData = $('[name=commentInsertForm]').serialize();
			commentInsert(insertData);
		});
		
		$('#commentListBtn').click(function() {
			if($('#commentListBtn').val() == '답글보기▲'){
				$(".commentList").empty();
				$('#commentListBtn').val('답글보기▼');
			}else{
			$('#commentListBtn').val('답글보기▲');
			commentList();
			}
		});
	});

	function commentList() {
		var bno = $("#bno").val();
			$.ajax({
						url : '/study-of-us/commentlist',
						type : 'post',
						data : {
							"bno" : bno
						},
						success : function(data) {
							var a = '';
							$.each(JSON.parse(data), function(value) {
								a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
								a += '작성자 : ' + this.name + '  날짜: ' + this.date;
								a += '<a onclick="commentUpdate('+ this.cno + ',\'' + this.content + '\');"> 수정 </a>';
								a += '<a onclick="commentDelete('+ this.cno + ');"> 삭제 </a> </div>';
								a += '<div class="commentContent' + this.cno+'"> <p> 내용 : '+ this.content + '</p>';
								a += '</div></div><br>';
							});

							$(".commentList").html(a);
						}
					});
			}
	

	//댓글 등록
	function commentInsert(insertData) {
		$.ajax({
			url : '/study-of-us/commentinsert',
			type : 'post',
			data : insertData,
			success : function(data) {
				if (data == 1) {
					commentList(); //댓글 작성 후 댓글 목록 reload
					$('[name=content]').val('');
				}
			}
		});
		
	}

	//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
	function commentUpdate(cno, content) {
		alert(cno);
		alert(content);
		var a = '';
		a += '<div class="input-group">';
		a += '<input type="text" class="form-control" name="content_'+cno+'" value="'+content+'"/>';
		a += '<input type="hidden" name="bno" value="${b.index}" id="bno" />';
		a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('
				+ cno + ');">수정</button> </span>';
		a += '</div>';

		$('.commentContent' + cno).html(a);
	}

	//댓글 수정
	function commentUpdateProc(cno) {
		var updateContent = $('[name=content_' + cno + ']').val();
		var bno = $('#bno').val();
		$.ajax({
			url : '/study-of-us/commentupdate',
			type : 'post',
			data : {
				'content' : updateContent,
				'cno' : cno,
				'bno' : bno
			},
			success : function(data) {
				if (data == 1)
					commentList(bno); //댓글 수정후 목록 출력 
			}
		});
	}

	//댓글 삭제 
	function commentDelete(cno) {
		var c = cno;
		$.ajax({
			url : '/study-of-us/commentdelete',
			type : 'post',
			data : {
				"cno" : c
			},
			success : function(data) {
				if (data == 1)
					commentList(bno); //댓글 삭제후 목록 출력 
			}
		});
	}
</script>