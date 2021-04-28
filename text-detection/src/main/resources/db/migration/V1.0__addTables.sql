CREATE TABLE sensitive_word
(
    id                BIGSERIAL PRIMARY KEY,
    content           varchar  NOT NULL
);

CREATE TABLE tag
(
    id                BIGSERIAL PRIMARY KEY,
    name              varchar  NOT NULL
);