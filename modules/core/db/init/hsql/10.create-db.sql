-- begin LIBRARY_FORM
create table LIBRARY_FORM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    START_DATE date not null,
    READER_ID varchar(36) not null,
    BOOK_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    END_DATE date,
    --
    primary key (ID)
)^
-- end LIBRARY_FORM
-- begin LIBRARY_BOOK
create table LIBRARY_BOOK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    AUTHOR varchar(255) not null,
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end LIBRARY_BOOK
-- begin LIBRARY_LIBRARY
create table LIBRARY_LIBRARY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end LIBRARY_LIBRARY
-- begin LIBRARY_READER
create table LIBRARY_READER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end LIBRARY_READER
-- begin LIBRARY_EMPLOYEE
create table LIBRARY_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME varchar(255),
    LIBRARY_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end LIBRARY_EMPLOYEE

-- begin LIBRARY_LIBRARY_READER_LINK
create table LIBRARY_LIBRARY_READER_LINK (
    READER_ID varchar(36) not null,
    LIBRARY_ID varchar(36) not null,
    primary key (READER_ID, LIBRARY_ID)
)^
-- end LIBRARY_LIBRARY_READER_LINK

-- begin LIBRARY_BOOK_IN_LIBRARY
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
)^
-- end LIBRARY_BOOK_IN_LIBRARY
