-- alter table LIBRARY_LIBRARY add column LIBRARY_SISTEM_ID varchar(36) ^
-- update LIBRARY_LIBRARY set LIBRARY_SISTEM_ID = <default_value> ;
-- alter table LIBRARY_LIBRARY alter column LIBRARY_SISTEM_ID set not null ;
alter table LIBRARY_LIBRARY add column LIBRARY_SISTEM_ID varchar(36) not null ;
