	$(function() {
		
		$('#boardSearchBtn').click(function() {
			var searchData = $('[name=boardSearchForm]').serialize();
			Search(searchData);
		});
		
		
	});	//end ready

	function Search(searchData) {
		var studyNum = 3; //나중에 파라미터로 스터디번호 가져올 것임
			$.ajax({ url : '/study-of-us/boardsearch',
					 type : 'get',
					 data : {
						 "studyNum" : studyNum,
						 "searchData" : searchData
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
			}//end commentList()
	
