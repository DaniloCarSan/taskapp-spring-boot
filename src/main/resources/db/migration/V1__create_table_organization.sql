-- CREATE TABLE ORGANIZATION

CREATE TYPE ACTIVE_STATUS AS ENUM ('Y', 'N');

CREATE TABLE IF NOT EXISTS ORGANIZATION (
    ID UUID NOT NULL UNIQUE,
    NAME VARCHAR(255) NOT NULL,
    ACTIVE ACTIVE_STATUS NOT NULL,
    PRIMARY KEY (ID)
);