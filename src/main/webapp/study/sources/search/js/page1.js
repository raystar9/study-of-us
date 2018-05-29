

     

     $(document).ready(function(){
    	 $(document).on("click",".atag1",function(e){
     		e.preventDefault();
     		var page = $(this).text()
     		
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
      
      $(document).on("click","#atagNext",function(e){
  		e.preventDefault();
  		//var page=${page+1};
  		var page2=$("#page").val();
  		page2=parseInt(page2)+1;
  	
  		$.ajax({
  				type : "get",
  				data : {"page" : page2, "check" : '${place}' , "state" : "ajax"},
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
  
  		var page2=$("#page").val();
  		page2=parseInt(page2)-1;
  		$.ajax({
  				type : "get",
  				data : {"page" : page2, "check" : '${place}' , "state" : "ajax"},
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
   		var page = $("#totalpage");
   		$.ajax({
   				type : "get",
   				data : {"page" : page, "check" : '${place}' , "state" : "ajax"},
   				url  : "/study-of-us/study/search",	
   			   cache: false, 
   			    headers : {"cache-control" : "no-cache", 
   			    	       "pragma" : "no-cache"},
   				success : function(rdata){
   					$(".project").empty().append(rdata);
   				}
   			
   			})

   	});
     })
