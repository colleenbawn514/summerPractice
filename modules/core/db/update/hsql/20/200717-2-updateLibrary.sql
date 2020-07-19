alter table LIBRARY_LIBRARY add column NAME varchar(255) ^
update LIBRARY_LIBRARY set NAME = '' where NAME is null ;
alter table LIBRARY_LIBRARY alter column NAME set not null ;
