create table LIBRARY_LIBRARY_BOOK_LINK (
    LIBRARY_ID varchar(36) not null,
    BOOK_ID varchar(36) not null,
    primary key (LIBRARY_ID, BOOK_ID)
);
