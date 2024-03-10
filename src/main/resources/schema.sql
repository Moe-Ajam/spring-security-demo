CREATE TABLE users
(
    id       Number      NOT NULL,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    enabled  INT         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE authorities
(
    id
              NUMBER
                          NOT
                              NULL,
    username
              VARCHAR(45) NOT NULL,
    authority VARCHAR2 ( 45
        ) NOT NULL,
    PRIMARY KEY
        (
         id
            )
);
