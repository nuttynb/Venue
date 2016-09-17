package hu.schonherz.training.venue.presentation.filters;

import hu.schonherz.training.landing.service.remote.UserRemoteService;
import hu.schonherz.training.landing.vo.remote.RemoteUserVo;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;


public class CookieFilter implements Filter {


    UserRemoteService userRemoteService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        List<Cookie> cookies = Arrays.asList(req.getCookies());
        String cookieValue = getHashFromCookies(cookies);
        RemoteUserVo remoteUserVo = null;
        if (cookieValue != null) {
            remoteUserVo = userRemoteService.getLoggedInUser(cookieValue);
            req.setAttribute("USER", remoteUserVo);
        }
        if (remoteUserVo == null) {
            ((HttpServletResponse) response).sendRedirect("/../landing");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            final Context context = new InitialContext(jndiProperties);


            final String appName = "landing-ear";
            final String moduleName = "landing-service";
            final String distinctName = "";
            final String beanName = "UserService";

            final String viewClassName = UserRemoteService.class.getName();
            System.out.println("Looking EJB via JNDI ");
            System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);

            userRemoteService = (UserRemoteService) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);


        } catch (NamingException ne) {
            ne.printStackTrace();
        }

    }

    @Override
    public void destroy() {

    }

    private String getHashFromCookies(List<Cookie> cookies) {

        if (!cookies.isEmpty()) {
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("loggedInUser")) {

                    return cookie.getValue();

                }
            }
        }
        return null;
    }

}
