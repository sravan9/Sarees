package com.resouce.helper.interfaces;

import com.enums.SareeType;
import com.models.db.ProductDetails;

import java.util.List;

public interface IProductDetailsHelperResource {
    List<ProductDetails> getProductDetailsList(SareeType sareeType, int offset, int batchSize) throws Exception;

}
