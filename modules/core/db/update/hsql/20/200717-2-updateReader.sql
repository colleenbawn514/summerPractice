alter table LIBRARY_READER alter column LIBRARY_ID rename to LIBRARY_ID__U40117 ^
alter table LIBRARY_READER alter column LIBRARY_ID__U40117 set null ;
alter table LIBRARY_READER drop constraint FK_LIBRARY_READER_ON_LIBRARY ;
drop index IDX_LIBRARY_READER_ON_LIBRARY ;
