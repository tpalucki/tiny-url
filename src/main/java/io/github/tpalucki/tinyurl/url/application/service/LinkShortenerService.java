package io.github.tpalucki.tinyurl.url.application.service;

import io.github.tpalucki.tinyurl.url.adapter.in.*;
import io.github.tpalucki.tinyurl.url.application.port.in.ShortenLink;
import io.github.tpalucki.tinyurl.url.application.port.out.StoreLink;
import io.github.tpalucki.tinyurl.url.domain.LinkMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkShortenerService implements ShortenLink {

    private final StoreLink storeLink;

    @Override
    public LinkMapping performForRequest(ShortenUrlRequest shortenUrlRequest) {
        var mapping = new LinkMapping(shortenUrlRequest.originalUrl(), shortenUrlRequest.alias());
        return storeLink.store(mapping);
    }
}
