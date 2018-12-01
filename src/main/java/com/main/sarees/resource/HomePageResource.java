package com.main.sarees.resource;

import com.additional.models.AllSareeTypes;
import com.additional.models.ImgBanners;
import com.enums.SareeType;
import com.google.inject.Inject;
import com.resouce.helper.interfaces.IHomePageResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/homepage")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HomePageResource {

    private final IHomePageResource homePageResource;

    @Inject
    public HomePageResource(IHomePageResource homePageResource) {
        this.homePageResource = homePageResource;
    }

    @GET
    @Path("/saree-types")
    public AllSareeTypes sareeTypeList() throws Exception {
        return homePageResource.getSareeTypes();
    }

    @GET
    @Path("/image-banners")
    public ImgBanners homePageImgBanners() throws Exception {
        return homePageResource.getImgBannersHomePage();
    }

}
