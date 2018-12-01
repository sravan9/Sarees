package com.resouce.helper.Impl;

import com.additional.models.AllSareeTypes;
import com.additional.models.ImgBanners;
import com.enums.SareeType;
import com.google.inject.Inject;
import com.resouce.helper.interfaces.IHomePageResource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class HomePageResourceImpl implements IHomePageResource {
    private ImgBanners imgBanners;

    @Inject
    public HomePageResourceImpl(ImgBanners imgBanners) {
        this.imgBanners = imgBanners;
    }

    public AllSareeTypes getSareeTypes() throws Exception {
        List<SareeType> sareeTypes = Arrays.asList(SareeType.values());
        AllSareeTypes allSareeTypes = new AllSareeTypes(sareeTypes);

        return allSareeTypes;
    }

    public ImgBanners getImgBannersHomePage() throws Exception {
        return imgBanners;
    }
}
