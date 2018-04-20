import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class login extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String nam=request.getParameter("name1");
        String password=request.getParameter("password1"); 
  try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","");
 
  
Statement st=con.createStatement();

ResultSet rs=st.executeQuery("select * from vidhyutra where name='"+nam+"' ");
if(rs.next()){
    if(rs.getString(3).equals(password)){
        out.print("You are successfully logged in!"); 
        out.println("<a href=index.html>Home</a></center>");
    }
    else{
        out.print("You have entered incorrect password");
    }                        
}
else{
    out.print("you must register first");
}

  
con.close();  
  
}catch(Exception e){ System.out.println(e);}
          
        
        out.close();  
    }  
  
}  
