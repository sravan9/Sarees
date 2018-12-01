package com.main.sarees.resource;

import com.enums.SareeType;
import com.google.inject.Inject;
import com.models.db.ProductDetails;
import com.resouce.helper.interfaces.IProductDetailsHelperResource;
import io.dropwizard.hibernate.UnitOfWork;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/productDetails")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductDetailsPageResource {
    private final IProductDetailsHelperResource productDetailsHelperResource;

    @Inject
    public ProductDetailsPageResource(IProductDetailsHelperResource productDetailsHelperResource) {
        this.productDetailsHelperResource = productDetailsHelperResource;
    }

    @GET
    public String sample(){
        return "Hello world";
    }

    @GET
    @Path("/list")
    @UnitOfWork
    public List<ProductDetails> getProductDetailsForHomePage(@QueryParam("sareeType")SareeType sareeType,
                                                             @QueryParam("offset") int offset,
                                                             @QueryParam("batchSize") int batchSize) throws Exception{
        return productDetailsHelperResource.getProductDetailsList(sareeType, offset, batchSize);
    }
}
