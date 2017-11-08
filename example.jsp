<html>
  <head>
    <title>La Jsp de Nico</title>
  </head>
  <body bgcolor=white>
    <%
      for (int i=5; i<=20; i++){
    %>
    <span style="color:red; font-size:<%=i%>"> [<%=i%>] </span>
    <%
      }
    %>

<!--      <%= new String("Hello!") %>
-->

  </body>
</html>
