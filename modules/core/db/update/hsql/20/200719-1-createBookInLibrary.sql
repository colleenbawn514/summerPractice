create table LIBRARY_BOOK_IN_LIBRARY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BOOK_ID varchar(36) not null,
    COUNT_ integer not null,
    LIBRARY_ID varchar(36) not null,
    --
    primary key (ID)
);