//댓글 개수
	function commentCount(bno) {
	var count;
	$.ajax({
		url : '/study-of-us/commentcount',
		type : 'post',
		async : false,
		data : {
			"bno" : bno
		},
		success : function(data) {
			count = data;
		}
	});
		return count;
	}	

$(function() {
		var bno = $('#bno').val();
		$('#boarddelete').click(function() {
			var result = confirm("게시글을 삭제하시겠습니까?");
			if(result == true){
				location.href="./boarddelete?num=" + bno;
			}else{
				return false;
			}
			
		});// click end
		
		$('#back').click(function() {
			var result = confirm("목록으로 돌아가시겠습니까?");
			if(result == true){
				location.href="./board";
			}else{
				return false;
			}
		});// click end
		
	
		var bno = $('#bno').val();
		var commentcount = commentCount(bno);
		$('#commentListBtn').val('답글보기(' + commentcount + ')▼');
		
		//댓글 버튼 눌렀을 때
		$('#commentInsertBtn').click(function() {
			var insertData = $('[name=commentInsertForm]').serialize();
			commentInsert(insertData);
		});
		
		//댓글 등록 버튼 눌었을 때
		$('#commentListBtn').click(function() {
			if($('#commentListBtn').val() == '답글보기(' + commentcount + ')▲'){
				$(".commentList").empty();
				$('#commentListBtn').val('답글보기(' + commentcount + ')▼');
			}else{
			$('#commentListBtn').val('답글보기(' + commentcount + ')▲');
				commentList();
			}
		});
	});
	
	//댓글 목록 출력
	function commentList() {
		var bno = $("#bno").val();
			$.ajax({ url : '/study-of-us/commentlist',
					 type : 'post',
					 data : {"bno" : bno},
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
				$('#commentListBtn').val('답글보기(' + data + ')▲');
					$('[name=content]').val('');
					 commentList(bno);
				}
			
		});
		
	}

	//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
	function commentUpdate(cno, content) {
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
		var bno = $("#bno").val();
		$.ajax({
			url : '/study-of-us/commentdelete',
			type : 'post',
			data : {
				"cno" : cno,
				"bno" : bno
			},
			success : function(data) {
				$('#commentListBtn').val('답글보기(' + data + ')▲');
					commentList(bno); //댓글 삭제후 목록 출력 
			}
		});
	}