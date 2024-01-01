package io.github.tpalucki.tinyurl.url.adapter.in;

import io.github.tpalucki.tinyurl.url.application.exception.AliasAlreadyDefinedException;
import io.github.tpalucki.tinyurl.url.application.port.in.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/urls")
@RequiredArgsConstructor
class UrlController {

    private final ShortenLink shortenLink;
    private final GetLink getLink;

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

    @GetMapping("/{alias}")
    ShortenUrlResponse getOriginalUrl(@PathVariable String alias) {
        log.info("Get original URL requested for alias: {}", alias);
        var shortenUrlResponse = getLink.getLink(alias);
        log.info("Get original URL response: {}", shortenUrlResponse);
        return dtoMapper.toDto(shortenUrlResponse, productionUrl);
    }

    @ExceptionHandler(value = {AliasAlreadyDefinedException.class})
    ErrorResponse handleError(AliasAlreadyDefinedException e) {
        log.error("Alias already defined: {}", e.getMessage());
        return ErrorResponse.builder(e, HttpStatus.CONFLICT, e.getMessage()).build();
    }
}
