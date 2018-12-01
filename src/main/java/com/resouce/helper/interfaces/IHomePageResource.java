package com.resouce.helper.interfaces;

import com.additional.models.AllSareeTypes;
import com.additional.models.ImgBanners;

public interface IHomePageResource {

    AllSareeTypes getSareeTypes() throws Exception;

    ImgBanners getImgBannersHomePage() throws Exception;
}
