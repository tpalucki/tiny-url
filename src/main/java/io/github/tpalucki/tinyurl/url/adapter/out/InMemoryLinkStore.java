package io.github.tpalucki.tinyurl.url.adapter.out;

import io.github.tpalucki.tinyurl.url.application.port.out.StoreLink;
import io.github.tpalucki.tinyurl.url.domain.LinkMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;

import java.util.HashMap;

@Slf4j
@Component
public class InMemoryLinkStore implements StoreLink {

    private final HashMap<String, LinkMapping> store = new HashMap<>();

    @Override
    public LinkMapping store(LinkMapping linkMapping) {
        log.info("Storing link mapping: {}", linkMapping);
        store.put(linkMapping.alias(), linkMapping);
        log.info("Link mapping stored: {}", linkMapping);
        return linkMapping;
    }
}
