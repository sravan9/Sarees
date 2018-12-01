package com.dao.interfaces;

import com.enums.SareeType;
import com.models.db.ProductDetails;

import java.util.List;

public interface IProductDetailsDao {

    ProductDetails getProductDetails(String productId) throws Exception;

    List<ProductDetails> getProductDetailsBySareeType(SareeType sareeType, int offset, int batchSize) throws Exception;


}
