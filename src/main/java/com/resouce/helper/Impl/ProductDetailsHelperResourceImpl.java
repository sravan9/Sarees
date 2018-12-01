package com.resouce.helper.Impl;

import com.dao.interfaces.IProductDetailsDao;
import com.enums.SareeType;
import com.google.inject.Inject;
import com.models.db.ProductDetails;
import com.resouce.helper.interfaces.IProductDetailsHelperResource;

import java.util.List;

public class ProductDetailsHelperResourceImpl implements IProductDetailsHelperResource {
    private final IProductDetailsDao productDetailsDao;

    @Inject
    public ProductDetailsHelperResourceImpl(IProductDetailsDao productDetailsDao) {
        this.productDetailsDao = productDetailsDao;
    }

    public List<ProductDetails> getProductDetailsList(SareeType sareeType, int offset, int batchSize) throws Exception {
        return productDetailsDao.getProductDetailsBySareeType(sareeType, offset, batchSize);
    }
}
