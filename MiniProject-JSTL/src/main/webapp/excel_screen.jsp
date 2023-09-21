<%@page import="java.util.*,com.nit.model.*" %>
 
 
<% //read request scope 
    List<Employee> list = (List<Employee>)request.getAttribute("empDetails");
    String desg = request.getParameter("job");
    
    //set response content type
    response.setContentType("application/ms-excel");
    //specify the content disposition
    response.addHeader("Content-Disposition", "attachment;fileName=emps.xls");
    
%>

<% if(list !=null && list.size()!=0) { %>
       int i = 1;
  <h1 style="color:red; text-align:center"> Employee Belonging to <%=desg%> </h1>
  
  <table>
  <tr>
    <th>Sno</th>
    <th>EMPNO</th>
    <th>ENAME</th>
    <th>DESG</th>
    <th>SALARY</th>
    <th>GROSSSALARY</th>
    <th>NETSALARY</th>
  </tr>

    <% for(Employee emp:list) { %>
	 <tr>
	    <td><%=1%> </td>
	    <td><%=emp.getEno() %> </td>
	    <td><%=emp.getEname() %> </td>
	    <td><%=emp.getDesg() %> </td>
	    <td><%=emp.getSalary() %> </td>
	    <td><%=emp.getGrossSalary() %> </td>
	    <td><%=emp.getNetSalary() %> </td>
	 </tr>
<%} %>
</table>
<% }
    else { %>
       <h1 style="color:red; text-align:center"> Records Not Found </h1>
       
   <% } %>   
   