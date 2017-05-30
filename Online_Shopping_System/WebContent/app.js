
$(document).ready(function() { 	
		add2cart(0,0);
		
		var all = document.getElementsByTagName("input");
		for (var i=0, max=all.length; i < max; i++) {
			if (all[i].id.substring(0, 5) == 'start') {
				all[i].click();
			}
		}
	})

	function chgImg(prodid, ar, direction){
		elid = 'ctlimg1';
		el = document.getElementById(elid);
		ImgNum = el.value;
		if (ImgNum == null)
			ImgNum = 0;
		ImgNum = ImgNum + direction;
		if (ImgNum >= ar.length) { ImgNum = 0; }
		if (ImgNum < 0) { ImgNum = ar.length - 1; }
		el.value = ImgNum;
		el.src = ar[ImgNum];
	}
    //Stops the submit request
//    $("#myAjaxRequestForm").submit(function(e){
//           e.preventDefault();
//    });
   
    //checks for the button click event
    function add2cart(prodid, maxqty){
    	if ($("#qty"+prodid).val() > maxqty) {
    		if (maxqty == 0)
    			alert('Not available');
    		else
    			alert('you can buy only '+maxqty+' items');
    		return;
    	}
    	
    	//get the form data and then serialize that
    	dataString = $("#ajax"+prodid).serialize();

    	//make the AJAX request, dataType is set to text
    	//meaning we are expecting PlainText data in response from the server
    	$.ajax({
    		type: "POST",
    		url: "add2cart",
    		data: dataString,
    		dataType: "text",
    		
    		
    		//if received a response from the server
    		success: function( data, textStatus, jqXHR) {
    			if(textStatus == 'success'){
    				$("#cart").html("<a href=\"tarik\"><b>Your Cart has items: " + jqXHR.responseText + "</b></a>");
    				}
    			//display error message
    			else {
    				$("#cart").html("<b>Invalid!</b>");
    				}
    			},
    			
			//If there was no resonse from the server
			error: function(jqXHR, textStatus, errorThrown){
    			//alert('error jqXHR='+jqXHR + ' ' + textStatus);
				$("#cart").html('error: ' + jqXHR.responseText);
				},
				
			//capture the request before it was sent to server
			beforeSend: function(jqXHR, settings){
				//adding some Dummy data to the request
				//settings.data += "&dummyData=whatever";
				//disable the button until we get the response
				//$('#myButton').attr("disabled", true);
				},
				
			//this is called after the response or error functions are finsihed
			//so that we can take some action
			complete: function(jqXHR, textStatus){
    			//alert('jqXHR='+jqXHR.responseText + ' ' + textStatus);
				//enable the button 
				//$('#myButton').attr("disabled", false);
				}
		});
    };
//});