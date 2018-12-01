package com.main.sarees;

import com.additional.models.ImgBanners;
import com.dao.impl.ProductDetailsDaoImpl;
import com.dao.interfaces.IProductDetailsDao;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.ProvisionException;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.resouce.helper.Impl.HomePageResourceImpl;
import com.resouce.helper.Impl.ProductDetailsHelperResourceImpl;
import com.resouce.helper.interfaces.IHomePageResource;
import com.resouce.helper.interfaces.IProductDetailsHelperResource;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Environment;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SareesModule extends AbstractModule {

    private SessionFactory sessionFactory;
    private HibernateBundle<CoreConfiguration> hibernateBundle;
    private Logger LOGGER = LoggerFactory.getLogger(SareesModule.class);

    public SareesModule(HibernateBundle<CoreConfiguration> hibernateBundle) {
        this.hibernateBundle = hibernateBundle;
    }

    protected void configure() {
        bind(IProductDetailsDao.class).to(ProductDetailsDaoImpl.class).in(Scopes.SINGLETON);
        bind(IHomePageResource.class).to(HomePageResourceImpl.class).in(Scopes.SINGLETON);
        bind(IProductDetailsHelperResource.class).to(ProductDetailsHelperResourceImpl.class).in(Scopes.SINGLETON);
    }

    @Provides
    @Singleton
    public SessionFactory getSessionFactory() {
        sessionFactory = hibernateBundle.getSessionFactory();

        if(sessionFactory == null) {
            LOGGER.error("Session factory set to null");
            throw new ProvisionException("The Hibernate session factory has not yet been set.");
        }

        return sessionFactory;
    }

    @Provides
    @Singleton
    public ImgBanners getImgBanners(CoreConfiguration coreConfiguration, Environment environment) {
        return new ImgBanners(coreConfiguration.getHomePageImgBanners().values());
    }
}
