package io.github.tpalucki.tinyurl.url.application.port.in;

import io.github.tpalucki.tinyurl.url.adapter.in.*;
import io.github.tpalucki.tinyurl.url.domain.LinkMapping;

public interface ShortenLink {

    LinkMapping performForRequest(ShortenUrlRequest shortenUrlRequest);
}
