
package imse.SS2017.team1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/customer/private/*")
public class AuthenticationFilterCustomer implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        
        boolean loggedIn=false;
        Object usertype=null;
        
        if(session != null){
        	loggedIn = session.getAttribute("email") != null;
        	usertype = session.getAttribute("usertype");
        }
        
        if (loggedIn && usertype=="customer") {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/Online_Shopping_System/customer/customerlogin.jsp");
        }		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

