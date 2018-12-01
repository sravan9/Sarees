package com.main.sarees;


import com.google.inject.Singleton;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.models.db.Campaign;
import com.models.db.ProductDetails;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * author
 * sravan.ks 1/12/2018
 */

@Singleton
public class App extends Application<CoreConfiguration>
{
    // Hibernate bundle.
    private static final HibernateBundle<CoreConfiguration> hibernateBundle = new HibernateBundle<CoreConfiguration>(ProductDetails.class) {

        public PooledDataSourceFactory getDataSourceFactory(CoreConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }

        @Override
        protected void configure(Configuration configuration) {
            configuration.setNamingStrategy(new ImprovedNamingStrategy());
        }
    };
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<CoreConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(GuiceBundle.<CoreConfiguration>newBuilder().
                enableAutoConfig(getClass().getPackage().getName()).
                addModule(new SareesModule(hibernateBundle)).
                setConfigClass(CoreConfiguration.class).
                build(Stage.DEVELOPMENT));

    }

    public void run(CoreConfiguration coreConfiguration, Environment environment) throws Exception {
    }
}
