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

        return (T) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }
}
