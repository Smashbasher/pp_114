package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory = null;
        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration();
                    Properties settings = new Properties();

                    settings.put(Environment.DRIVER, "org.postgresql.Driver");
                    settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
                    settings.put(Environment.USER, "postgres");
                    settings.put(Environment.PASS, "postgres");
                    settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
                    settings.put(Environment.SHOW_SQL, "true");
                    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                    settings.put(Environment.HBM2DDL_AUTO, "none");

                    configuration.setProperties(settings);
                    configuration.addAnnotatedClass(User.class);

                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();

                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                } catch (HibernateException e) {
                    System.out.println("Problem creating session factory");
                    e.printStackTrace();
                }
            }
        return sessionFactory;
    }
}
