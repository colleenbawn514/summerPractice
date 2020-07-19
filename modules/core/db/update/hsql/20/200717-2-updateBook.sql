alter table LIBRARY_BOOK alter column LIBRARY_ID rename to LIBRARY_ID__U63416 ^
alter table LIBRARY_BOOK alter column LIBRARY_ID__U63416 set null ;
alter table LIBRARY_BOOK drop constraint FK_LIBRARY_BOOK_ON_LIBRARY ;
drop index IDX_LIBRARY_BOOK_ON_LIBRARY ;
