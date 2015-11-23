<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<%@ page import="javax.portlet.PortletURL" %>
<sj:head jqueryui="true" jquerytheme="flick" />

<portlet:defineObjects />

<!--table>
   <s:iterator value="%{bookmarks}" var="bookmark">
      <tr>
         <td width = "40%"><s:property value="%{name}"/></td>
         <td width = "60%">
         	<a href="<s:property value="%{url}"/>" target="_blank"><s:property value="%{url}"/></a>
         </td>
      </tr>
   </s:iterator>
</table-->

<s:url id="remoteurl" value="/student/studentTable.action"/>
<sjg:grid id="gridtable"
    	caption="Students"
    	dataType="json"
    	href="%{remoteurl}"
    	pager="true"
    	gridModel="gridModel"
    	rowList="5,10,15,20"
    	rowNum="5"
    	rownumbers="true"
    >
	<sjg:gridColumn name="studentId" title="Student Id" formatter="integer" sortable="false"/>
    <sjg:gridColumn name="studentName" index="studentName" title="Student Name" sortable="true"/>
    <sjg:gridColumn name="studentPlece" index="studentPlace" title="Student Place" sortable="false"/>
</sjg:grid>
<br/>
<p><a href="<s:url action='index'/>">Home</a></p>
