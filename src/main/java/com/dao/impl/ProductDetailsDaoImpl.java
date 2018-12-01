package com.dao.impl;

import com.dao.interfaces.IProductDetailsDao;
import com.enums.SareeType;
import com.google.inject.Inject;
import com.models.db.ProductDetails;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class ProductDetailsDaoImpl extends AbstractDAO<ProductDetails> implements IProductDetailsDao {

    private final SessionFactory sessionFactory;

    @Inject
    public ProductDetailsDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public ProductDetails getProductDetails(String productId) throws Exception {
        return get(productId);
    }

    public List<ProductDetails> getProductDetailsBySareeType(SareeType sareeType, int offset, int batchSize) throws Exception {
        Criteria criteria = currentSession().createCriteria(ProductDetails.class).
                add(Restrictions.eq("sareeType", sareeType)).
                setFirstResult(offset).setMaxResults(batchSize);
        return criteria.list();
    }
}
