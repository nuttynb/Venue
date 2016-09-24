package hu.schonherz.training.venue.presentation.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class RemoteEJBClientLookup {
    private RemoteEJBClientLookup() {
    }

    public static <T> T lookup(Class<T> ejbClass, String appName, String moduleName, String distinctName, String beanName) throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        final Context context = new InitialContext(jndiProperties);

        final String viewClassName = ejbClass.getName();
        String slash = "/";
        StringBuilder name = new StringBuilder("ejb:");
        name.append(appName).append(slash)
                .append(moduleName).append(slash)
                .append(distinctName).append(slash)
                .append(beanName).append("!")
                .append(viewClassName);

        return (T) context.lookup(name.toString());
    }
}
