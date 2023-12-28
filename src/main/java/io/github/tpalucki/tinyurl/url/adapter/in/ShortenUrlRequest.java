package io.github.tpalucki.tinyurl.url.adapter.in;

public record ShortenUrlRequest(String originalUrl,
                                String alias) {
}
