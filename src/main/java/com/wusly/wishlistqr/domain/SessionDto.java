package com.wusly.wishlistqr.domain;

import java.util.UUID;

public record SessionDto(
        UUID id,
        String name
) {
}
