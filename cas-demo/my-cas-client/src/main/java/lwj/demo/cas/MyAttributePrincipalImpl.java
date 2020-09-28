package lwj.demo.cas;

import java.util.Map;

import org.jasig.cas.client.authentication.AttributePrincipal;

public class MyAttributePrincipalImpl implements MyAttributePrincipal {

    private static final long serialVersionUID = 2462531194060119065L;

    private AttributePrincipal attributePrincipal;

    public MyAttributePrincipalImpl(AttributePrincipal attributePrincipal) {
        super();
        this.attributePrincipal = attributePrincipal;
    }

    @Override
    public Long getUserid() {
        return Long.valueOf(this.getName());
    }

    @Override
    public String getProxyTicketFor(String service) {
        return attributePrincipal.getProxyTicketFor(service);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributePrincipal.getAttributes();
    }

    @Override
    public String getName() {
        return attributePrincipal.getName();
    }

}
