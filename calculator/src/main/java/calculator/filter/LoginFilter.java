package calculator.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter
public class LoginFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException,
            ServletException
    {
        final HttpServletRequest request = (HttpServletRequest)req;
        final HttpServletResponse response = (HttpServletResponse)res;
        final HttpSession session = request.getSession(false);
        final String loginURI = request.getContextPath() + "/login.xhtml";
        
        // redirect to requested url after login
        String from = request.getRequestURI();
        if(request.getQueryString() != null)
        {
            from += "?" + request.getQueryString();
        }

        boolean isLoggedIn = session != null && session.getAttribute("user") != null;
        boolean isLoginRequested = request.getRequestURI().equals(loginURI);

        if(isLoggedIn || isLoginRequested)
        {
            chain.doFilter(request, response);
        }

        else
        {
            request.getSession().setAttribute("from", from);
            response.sendRedirect(loginURI);
        }

    }

}
