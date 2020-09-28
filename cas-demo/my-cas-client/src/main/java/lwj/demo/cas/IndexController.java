package lwj.demo.cas;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping(value = { "/", "/index" })
    @ResponseBody
    public String index(HttpServletRequest request, HttpServletResponse response) {
        MyAttributePrincipal principal = new MyAttributePrincipalImpl((AttributePrincipal) request.getUserPrincipal());

        String result = "sessionId:" + request.getSession().getId() + "</br>";
        result += "request.getRemoteUser():" + request.getRemoteUser() + "</br>";
        result += "request.getUserPrincipal():" + request.getUserPrincipal() + "</br>";
        result += "principal.getName():" + principal.getName() + "</br>";
        result += "principal.getUserid():" + principal.getUserid() + "</br>";
        if (principal != null) {
            Map<String, Object> map = principal.getAttributes();
            for (String key : map.keySet()) {
                result += key + "  :  " + map.get(key) + "</br>";
            }
        }
        result += "<a href='http://192.168.89.69:8082/logout'>退出</a></br>";
        return "execute index method </br>" + result;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response) {
        MyAttributePrincipal principal = new MyAttributePrincipalImpl((AttributePrincipal) request.getUserPrincipal());
        String result = "sessionId:" + request.getSession().getId() + "</br>";
        result += "request.getRemoteUser():" + request.getRemoteUser() + "</br>";
        result += "request.getUserPrincipal():" + request.getUserPrincipal() + "</br>";
        result += "principal.getName():" + principal.getName() + "</br>";
        result += "principal.getUserid():" + principal.getUserid() + "</br>";
        if (principal != null) {
            Map<String, Object> map = principal.getAttributes();
            for (String key : map.keySet()) {
                result += key + "  :  " + map.get(key) + "</br>";
            }
        }
        return "execute test method </br>" + result;
    }

    @RequestMapping(path = { "/logout" }, method = RequestMethod.GET)
    public void logout(HttpServletResponse response, HttpSession session,HttpServletRequest httpServletRequest) throws IOException {
        // 清除Session
        session.invalidate();
        String url = "http://192.168.89.69:8090/logout?service=http://192.168.89.69:8082";
        response.sendRedirect(url);
    }
}
