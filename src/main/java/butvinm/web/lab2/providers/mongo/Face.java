package butvinm.web.lab2.providers.mongo;

import lombok.NonNull;

public record Face(
    @NonNull String name,
    @NonNull String content
) {
}
