create table LIBRARY_LIBRARY_READER_LINK (
    READER_ID varchar(36) not null,
    LIBRARY_ID varchar(36) not null,
    primary key (READER_ID, LIBRARY_ID)
);
