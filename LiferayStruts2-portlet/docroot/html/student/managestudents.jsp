<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<sj:head jqueryui="true" jquerytheme="flick" />
<script type="text/javascript">
	var context_path = '<%=request.getContextPath()%>';
</script>

<s:debug />
	
<h2>Manage bookmarks</h2>

<s:if test="hasActionMessages()">
   <div class="message">
      <s:actionmessage/>
   </div>
</s:if>
<portlet:defineObjects />
<s:url id="remoteurl" value="/student/studentTable.action"/>
<s:url id="editUrl" value="/student/updatestudent.action"/>
<sjg:grid id="gridtable"
    	caption="Manage Students"
    	dataType="json"
    	href="%{remoteurl}"
    	pager="true"
    	gridModel="gridModel"
    	rowList="5,10,15,20"
    	rowNum="5"
    	rownumbers="true"
    	multiselect="true"
    	navigator="true"
    	navigatorView="false"
    	navigatorDelete="false"
    	navigatorAdd="false"
    	navigatorRefresh="false"
    	navigatorSearch="false"
		navigatorEditOptions="{height:180,reloadAfterSubmit:false}"
    	navigatorEdit="true"
    	editurl="%{editurl}"
    >
	<sjg:gridColumn name="studentId" title="Student Id" formatter="integer" sortable="false"/>
    <sjg:gridColumn name="studentName" index="studentName" title="Student Name" editable="true" edittype="text" sortable="true"/>
    <sjg:gridColumn name="studentPlece" index="studentPlace" title="Student Place" editable="true" edittype="text" sortable="false"/>
    <sjg:gridColumn name="studentState" index="studentState" title="Student State" editable="true" edittype="text" sortable="false"/>
  
    <sjg:gridColumn name="studentId" 
    				title="Actions" 
    				editable="false" 
    				sortable="false"
    				align="center"
    				formatter="formatImage"
    				onclick="$.publish('edit_bookmark');"
    />
    
</sjg:grid>
<br/>
<p><a href="<s:url action='index'/>">Home</a></p>
<script>
/*
 * Format a Column as Link
 */
function formatLink(cellvalue, options, row) {
	return "<a href='#' onClick='javascript:openDialog("+cellvalue+")'>" + cellvalue + "</a>";
}

/*
 * Format a Column as Image
 */
function formatImage(cellvalue, options, row) {
	return "<img src='"+ context_path +"/images/page_edit.png' onClick='$.publish("+"&apos;edit_bookmark&apos;, {old_name:" +"&apos;"+cellvalue+"&apos;"+ "})' />";
}


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
			$('#success_message').html("Bookmark Added Successfully"); 
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
function newBookmark() {
	AUI().use('liferay-portlet-url', 'aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
		//generate struts action url
		var addBookmarkAction = Liferay.PortletURL.createActionURL();
		addBookmarkAction.setWindowState("exclusive");
		addBookmarkAction.setPortletId("liferayStruts2Student_WAR_LiferayStruts2portlet");
		addBookmarkAction.setParameter("struts.portlet.action", "/student/addstudents");
		//alert(addBookmarkAction.toString());
	    var dialog = new A.Dialog({
		    	title: 'New Bookmark', 
		        centered: true, 
		        modal: true, 
		        width: 400, 
	        }).plug(A.Plugin.IO, {
	        		uri: addBookmarkAction.toString()
	        	}).render();
       
        dialog.show();
       
	});
}

function editBookmark(old_name) {
	AUI().use('liferay-portlet-url', 'aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
		//alert("=============="+A);
		var editBookmarkAction = Liferay.PortletURL.createActionURL();
		editBookmarkAction.setWindowState("exclusive");
		editBookmarkAction.setPortletId("liferayStruts2Student_WAR_LiferayStruts2portlet");
		
		editBookmarkAction.setParameter("struts.portlet.action","/student/getupdatestudent");
		editBookmarkAction.setParameter("oldName", old_name);
		//alert("=============="+editBookmarkAction);
		var dialog = new A.Dialog({
				title: 'Edit Bookmark', 
		        centered: true, 
		        modal: true, 
		        width: 400, 
	        }).plug(A.Plugin.IO, {
	        		uri: editBookmarkAction.toString()
	        	}).render();
	       
		dialog.show();
	       
	 });

}
</script> 

