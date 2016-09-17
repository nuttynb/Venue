package hu.schonherz.training.venue.presentation.filters;

import hu.schonherz.training.venue.vo.remote.RemoteUserVo;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class CookieFilter implements Filter {


    @EJB
    UserRemoteService userRemoteService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        List<Cookie> cookies = Arrays.asList(req.getCookies());

        RemoteUserVo remoteUserVo = userRemoteService.getLoggedInUser(getHashFromCookies(cookies));

        req.setAttribute("USER",remoteUserVo);
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    private String getHashFromCookies(List<Cookie> cookies) {

        if(!cookies.isEmpty()) {
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("loggedInUser")) {

                    return cookie.getValue();

                }
            }
        }
        return null;
    }

}
