package calculator.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter
{

    private String encoding = "uft-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        String encodingParam = filterConfig.getInitParameter("encoding");
        if(encodingParam != null)
        {
            encoding = encodingParam;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException,
            ServletException
    {

        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);

    }

}
