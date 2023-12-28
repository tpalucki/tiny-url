package io.github.tpalucki.tinyurl.url.application.port.in;

import io.github.tpalucki.tinyurl.url.domain.LinkMapping;

public interface GetLink {

    LinkMapping getLink(String alias);
}
