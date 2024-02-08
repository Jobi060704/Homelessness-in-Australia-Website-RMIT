CREATE TABLE U_HMLS (
    fname             CHAR (100) NOT NULL,
    phone             INT,
    email             CHAR (255),
    age               INTEGER NOT NULL,
    status            CHAR (10) NOT NULL,
    sex               CHAR (2) NOT NULL
);

CREATE TABLE U_DNTRS (
    fname             CHAR (100) NOT NULL,
    email             CHAR (255) NOT NULL,
    dntn              INTEGER NOT NULL
);