package io.github.tpalucki.tinyurl.url.adapter.in;

import io.github.tpalucki.tinyurl.url.domain.LinkMapping;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
interface DtoMapper {
    @Mapping(target = "originalUrl", source = "response.originalUrl")
    @Mapping(target = "shortenedUrl", expression = "java(productionUrl + \"/\" + response.alias())")
    ShortenUrlResponse toDto(LinkMapping response, String productionUrl);
}
