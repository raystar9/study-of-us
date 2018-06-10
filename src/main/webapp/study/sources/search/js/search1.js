$(document).ready(function() {


					var secondArray_0 = new Array("Java", "c언어", "Python", "c++","c#");
					var secondArray_1 = new Array("영어", "불어", "중국어", "일본어","한국어");
					var secondArray_2 = new Array("정보처리기사", "컴퓨터활용", "ccna","ccnp", "네트워크관리사");

					

					$("#firstArray").change(function() { // 대분류 선택시 소분류의 값을 선택할수 있도록
										// 한다.
										var selectVal = $("#firstArray").val();
										var inner = "";

										if (selectVal == 1) {
											for (var i = 0; i < secondArray_0.length; i++) {
												inner += "<option value="
														+ secondArray_0[i]
														+ ">";
												inner += secondArray_0[i];
												inner += "</option>";
											}
											$("#secondArray option").remove();
											$("#secondArray").append(inner);
											$('.category').val($("#secondArray").val())
										}
										if (selectVal == 2) {
											for (var i = 0; i < secondArray_1.length; i++) {
												inner += "<option value="
														+ secondArray_1[i]
														+ ">";
												inner += secondArray_1[i];
												inner += "</option>";
											}
											$("#secondArray option").remove();
											$("#secondArray").append(inner);
											$('.category').val($("#secondArray").val())
										}
										if (selectVal == 3) {
											for (var i = 0; i < secondArray_2.length; i++) {
												inner += "<option value="
														+ secondArray_1[i]
														+ ">";
												inner += secondArray_2[i];
												inner += "</option>";
											}
											$("#secondArray option").remove();
											$("#secondArray").append(inner);
											$('.category').val($("#secondArray").val())
										}
									});
					
					
					
					
					$("#location").change(function(){
						$('.location').val($(this).val())
					})
					
						$("#day-select").change(function(){
						$('.day').val($(this).val())
					})
					
						$("#stime").change(function(){
						$('.time').val($(this).val())
					})
					
			
					
					// 스터디를 클릭하면 참여할수 있도록 함

					$(document).on("click",".projectcontainer",function() {
										var index = $(this).children('#index')
										// 자식의 값을 가져오기 위해서 children('선택자')를 사용
										location.href = "/study-of-us/study/each/participate?index="
												+ index.val();
									})

					$("input[type=checkbox]").each(function() {

						$("input[value=checkbox]").prop("checked", true)
						a = $(this).val()
					});

				});

