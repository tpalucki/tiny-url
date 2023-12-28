package io.github.tpalucki.tinyurl.url.application.port.out;

import io.github.tpalucki.tinyurl.url.domain.LinkMapping;

public interface StoreLink {
    LinkMapping store(LinkMapping linkMapping);

    LinkMapping getByAlias(String alias);
}
