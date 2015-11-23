<%@ include file="/html/init.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<s:form action="addstudenrecord">
      <s:textfield name="name" label="Student Name" value=""/>
      <s:textfield name="place" label="Student Place" value=""/>
      <s:textfield name="state" label="Student State" value=""/>
      <s:submit value="Add Student" align="center"/>
</s:form>

<br/>
<p><a href="<s:url action='index'/>">Home</a></p>
