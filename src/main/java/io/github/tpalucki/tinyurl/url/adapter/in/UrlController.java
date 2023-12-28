package io.github.tpalucki.tinyurl.url.adapter.in;

import io.github.tpalucki.tinyurl.url.application.port.in.ShortenLink;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/urls")
@RequiredArgsConstructor
class UrlController {

    private final ShortenLink shortenLink;
    private final DtoMapper dtoMapper;
    @Value("${production.url}")
    private final String productionUrl;

    @PostMapping
    ShortenUrlResponse shortenUrl(@RequestBody ShortenUrlRequest shortenUrlRequest) {
        log.info("Shorten URL requested: {}", shortenUrlRequest);
        var shortenUrlResponse = shortenLink.performForRequest(shortenUrlRequest);
        log.info("Shorten URL generated: {}", shortenUrlResponse);
        return dtoMapper.toDto(shortenUrlResponse, productionUrl);
    }
}
