package com.shop.ordering.infrastructure.persistence.beans;

import com.shop.ordering.domain.model.utility.DomainService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = "com.shop.ordering.domain.model",
    includeFilters = @ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = DomainService.class
    )
)
public class DomainServiceScanConfig {
}
