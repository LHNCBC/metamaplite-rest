package au.com.ninthavenue.web.webcore.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This filter ensures that all requests and responses are encoded and 
 * decoded with UTF-8. It must appear first in the filter chain, because
 * as soon as you call request.getParameter(), the request encoding cannot
 * be changed.
 */
public class UTF8Filter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(UTF8Filter.class);

    @Override
    public void init(FilterConfig fc) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
	try {
	  chain.doFilter(request, response);
	} catch (Exception e) {
	  logger.error("exception during chain.doFilter(request, response)" +
		       e.toString());
	  logger.error("stack trace", e);
	  // attempt to send a custom error response
	  if (!response.isCommitted()) {
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	    httpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
				   "An internal error occurred.");
	  }
	}
    }

    @Override
    public void destroy() {}
}
