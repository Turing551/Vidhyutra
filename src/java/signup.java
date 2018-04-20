import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class signup extends HttpServlet {
 
  // Method to handle GET method request.
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
    String name=request.getParameter("name");
    String email=request.getParameter("email"); 
    String pass=request.getParameter("password");
 
   
  try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");  
  
PreparedStatement ps=con.prepareStatement("insert into vidhyutra values(?,?,?)");
Scanner sc=new Scanner(System.in);


ps.setString(1,name);
ps.setString(2,email);
ps.setString(3,pass);
  
ps.executeUpdate(); 
  
con.close();  
  
}catch(Exception e){ System.out.println(e);}
   out.println(
                "<html>\n" 
                 +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" +" Welcome "+ "</h1>\n" +
               
                "you have been registered sucessfully" + "\n" +
            
               
                "</body></html>");
  }
  
  // Method to handle POST method request.
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
     doGet(request, response);
  }
}