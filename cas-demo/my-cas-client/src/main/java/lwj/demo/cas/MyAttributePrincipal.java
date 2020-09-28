package lwj.demo.cas;

import org.jasig.cas.client.authentication.AttributePrincipal;

public interface MyAttributePrincipal extends AttributePrincipal {
    
    Long getUserid();

}
