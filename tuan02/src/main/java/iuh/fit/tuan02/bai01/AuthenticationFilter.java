package iuh.fit.tuan02.bai01;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationFilter extends HttpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        String usernameConfig=this.getInitParameter("username");
        String passwordConfig=this.getInitParameter("password");

        if(username.equals(usernameConfig) && password.equals(passwordConfig)){
            chain.doFilter(req,res);
        }else {
            PrintWriter writer=res.getWriter();
            writer.println("username or password is not valid");
            writer.close();
        }
    }
}
