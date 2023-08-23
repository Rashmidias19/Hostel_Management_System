package lk.ijse.D24.config;

import lk.ijse.D24.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private final SessionFactory sessionFactory;

    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig(){

//
//      sessionFactory=new MetadataSources(new StandardServiceRegistryBuilder()
//               .configure()
//                .build()).addAnnotatedClass(Customer.class).getMetadataBuilder()
//              .applyImplicitNamingStrategy(ImplicitNamingStrategyLegacyJpaImpl.INSTANCE)
//              .build().buildSessionFactory();

        sessionFactory=new Configuration().configure().addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return(null==factoryConfig)
                ?factoryConfig=new SessionFactoryConfig()
                :factoryConfig;
    }

    public Session getSession(){


        return sessionFactory.openSession();
    }
}