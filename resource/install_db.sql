drop tablespace NOZOWNIK_DATA including contents cascade constraints;
drop tablespace NOZOWNIK_INDEX including contents cascade constraints;
create tablespace NOZOWNIK_DATA datafile 'c:\oraclexe\app\oracle\oradata\XE\noz_data.dbf' size 100 M REUSE AUTOEXTEND ON;
create tablespace NOZOWNIK_INDEX datafile 'c:\oraclexe\app\oracle\oradata\XE\noz_index.dbf' size 100 M REUSE AUTOEXTEND ON;
drop user noz cascade;
create user noz identified by noz123 DEFAULT TABLESPACE NOZOWNIK_DATA;
grant all privileges to noz;