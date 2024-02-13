EXEC sp_helpsrvrole;

--Questão 2 
CREATE LOGIN MatheusEmanoelGdaSilva WITH PASSWORD = 'abc123'
USE PROVA01
CREATE USER MatheusEmanoelGdaSilva FOR LOGIN MatheusEmanoelGdaSilva
WITH DEFAULT_SCHEMA = [PROVA01]

EXEC sp_addsrvrolemember 'MatheusEmanoelGdaSilva' ,'dbcreator'


--Questão 3
EXEC sp_addrolemember 'DB_DATAREADER', 'MatheusEmanoelGdaSilva'
EXEC sp_addrolemember 'DB_DATAWRITER', 'MatheusEmanoelGdaSilva'
 
 --Questão 4
 GRANT SELECT ON USERS TO MatheusEmanoelGdaSilva
 DENY INSERT ON PEOPLE TO MatheusEmanoelGdaSilva