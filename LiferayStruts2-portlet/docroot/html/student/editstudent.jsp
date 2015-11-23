
<%@ include file="/html/init.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<h2>Add Student</h2>
<s:if test="hasActionMessages()">
   <div class="message">
      <s:actionmessage/>
   </div>
</s:if>
<s:if test="hasFieldErrors()">
   <div class="errors">
      <s:fielderror />
   </div>
</s:if>
<s:url id="insert_action" value="/student/updatestudent.action"/>
<s:form action="updatestudent">
		<s:textfield name="id" label="Student Id" value="%{#session.student1.studentId}" />
    	 <s:textfield name="name" label="Student Name" value="%{#session.student1.studentName}" />
    	  <s:textfield name="place" label="Student State" value="%{#session.student1.studentPlece}"/>
     	 <s:textfield name="state" label="Student State" value="%{#session.student1.studentState}"/>
     
	<sj:submit targets="success_message"
							href="%{insert_action}"
				           	value="Update" 
				           	button="true"
			            	dataType="json"                
			            	onSuccessTopics="bookmark_added"
			           	/>
</s:form>

<br/>
<p><a href="<s:url action='index'/>">Home</a></p>
<script>
$(document).ready( function() {  
	$.subscribe('handleJsonResult', function(event, data) { 
		var errorMessages = event.originalEvent.data.validateErrors;
		
		if(errorMessages.length > 0) {
			$('#add_button').attr("disabled", true); 
			
			$('#validationErrors').addClass('errors');
			$('#validationErrors').html("<ul id='jsonMessage'></ul>");  
			var list = $('#jsonMessage');
			$.each(errorMessages, function(index, value) {                         
				list.append('<li>'+value+'</li>\n');    
//				console.log("value " + value); 
			});  
		}
		else {
			$('#validationErrors').removeClass('errors');
			$('#validationErrors').html(""); 
			
			$('#add_button').attr("disabled", false); 
		}
		
		return false;
	});
});    

$(document).ready( function() {  
	$.subscribe('bookmark_added', function(event, data) { 
		var errorMessages = event.originalEvent.data.validateErrors;
		
		if(errorMessages.length > 0) {
			$('#success_message').addClass('errors');
			$('#success_message').html("<ul id='jsonMessage'></ul>");  
			var list = $('#jsonMessage');
			$.each(errorMessages, function(index, value) {                         
				list.append('<li>'+value+'</li>\n');    
			});  
		}
		else {
			$('#success_message').addClass('message');
			$('#success_message').html("Student Added Successfully"); 
		}
		
		return false;
	});
});    

$(document).ready( function() {  
	$.subscribe('edit_bookmark', function(event, data) { 
		
		editBookmark(data.old_name);
		
		return false;
	});
});   
</script>
