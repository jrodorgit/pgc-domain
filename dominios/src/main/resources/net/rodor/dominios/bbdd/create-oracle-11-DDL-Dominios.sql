CREATE TABLE ZZDomains(
appdomain VARCHAR2(20) NOT NULL ,
namedomain VARCHAR2(20) NOT NULL ,
code VARCHAR2(20) NOT NULL ,
description VARCHAR2(80) NOT NULL ,
descriptionXL VARCHAR2(256) NOT NULL ,
descriptionXS VARCHAR2(30) NOT NULL ,
startdate TIMESTAMP NOT NULL ,
enddate TIMESTAMP NOT NULL 
) 
LOGGING;
COMMENT ON TABLE ZZDomains IS 'Dominios de valores';
COMMENT ON COLUMN ZZDomains.appdomain IS 'Aplicacion a la que pertenece del dominio. Si valor ALL se aplicará a todas las aplicaciones';
COMMENT ON COLUMN ZZDomains.namedomain IS 'Nombre del dominio';
COMMENT ON COLUMN ZZDomains.code IS 'Codigo del elemento del dominio';
COMMENT ON COLUMN ZZDomains.description IS 'Descripcion del elemento  del dominio';
COMMENT ON COLUMN ZZDomains.descriptionXL IS 'Descripcion larga del elemento  del dominio';
COMMENT ON COLUMN ZZDomains.descriptionXS IS 'Descripcion corta del elemento  del dominio';
COMMENT ON COLUMN ZZDomains.startdate IS 'fecha de inicio de validez del elemento  del dominio';
COMMENT ON COLUMN ZZDomains.enddate IS 'fecha de fin de validez del elemento del dominio';


--REM INSERTING into ZZDOMAINS
Insert into ZZDOMAINS (APPDOMAIN,NAMEDOMAIN,parentcode, code,description,descriptionXL,descriptionXS,startdate,enddate) values ('SICOSS','CONCEPTOS GASTO',NULL,'36','GASTOS FSE','GASTOS IMPUTABLES AL FONDO SOCIAL EUROPEO','GASTOS FSE',to_timestamp('01/01/2017 00:00:00,000000000','DD/MM/RR HH24:MI:SS,FF'),to_timestamp('31/12/2018 00:00:00,000000000','DD/MM/RR HH24:MI:SS,FF'));
Insert into ZZDOMAINS (APPDOMAIN,NAMEDOMAIN,parentcode,code,description,descriptionXL,descriptionXS,startdate,enddate) values ('SICOSS','CONCEPTOS GASTO',NULL,'37','GASTOS FROB','GASTOS IMPUTABLES AL FROB','GASTOS FROB',to_timestamp('01/01/2017 00:00:00,000000000','DD/MM/RR HH24:MI:SS,FF'),to_timestamp('31/12/2018 00:00:00,000000000','DD/MM/RR HH24:MI:SS,FF'));
Insert into ZZDOMAINS (APPDOMAIN,NAMEDOMAIN,parentcode,code,description,descriptionXL,descriptionXS,startdate,enddate) values ('SICOSS','CONCEPTOS FACT',NULL,'01','FACTURACION FROB','FACTURACION RELATIVA AL FROB','FACTURACION FROB',to_timestamp('01/01/2017 00:00:00,000000000','DD/MM/RR HH24:MI:SS,FF'),to_timestamp('31/12/2018 00:00:00,000000000','DD/MM/RR HH24:MI:SS,FF'));
Insert into ZZDOMAINS (APPDOMAIN,NAMEDOMAIN,parentcode,code,description,descriptionXL,descriptionXS,startdate,enddate) values ('SICOSS','CONCEPTOS FACT',NULL,'02','FACTURACION FSE','FACTURACION RELATIVA AL FSE','FACTURACION FSE',to_timestamp('01/01/2017 00:00:00,000000000','DD/MM/RR HH24:MI:SS,FF'),to_timestamp('31/12/2018 00:00:00,000000000','DD/MM/RR HH24:MI:SS,FF'));

COMMIT;