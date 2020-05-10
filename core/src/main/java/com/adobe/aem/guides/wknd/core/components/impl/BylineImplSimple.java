package com.adobe.aem.guides.wknd.core.components.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.adobe.aem.guides.wknd.core.components.Byline;
import com.adobe.cq.wcm.core.components.models.Image;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

// @Model(
//     adaptables = {SlingHttpServletRequest.class},
//     adapters = {Byline.class},
//     resourceType = {BylineImpl.RESOURCE_TYPE},
//     defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
// )
public class BylineImplSimple implements Byline {

    protected static final String RESOURCE_TYPE = "wknd/components/content/byline";

    @Self
    private Image image;

    @ValueMapValue
    private String name;

    @ValueMapValue
    private List<String> occupations;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getOccupations() {
        if(occupations != null) {
            return occupations.stream()
                .sorted()
                .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean isEmpty() {
        if(StringUtils.isBlank(name)) {
            // Name is missing, but required
            return true;
        } else if(occupations == null || occupations.isEmpty()) {
            // At least one occupation is required
            return true;
        } else if(image == null || StringUtils.isBlank(image.getSrc())) {
            // A valid image is required
        return true;
        } else {
            // Everything is populated, so this component is not considered empty
            return false;
        }
    }

}