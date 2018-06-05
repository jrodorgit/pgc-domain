CREATE TABLE Domains(
appdomain char(20) NOT NULL  COMMENT 'Aplicacion a la que pertenece del dominio. Si valor ALL se aplicará a todas las aplicaciones' ,
namedomain char(20) NOT NULL COMMENT 'Nombre del dominio',
code char(20) NOT NULL COMMENT 'Codigo del elemento del dominio',
description varchar(80) NOT NULL COMMENT 'Descripcion del elemento del dominio',
descriptionXL varchar(256) NOT NULL COMMENT 'Descripcion larga del elemento del dominio',
descriptionXS varchar(30) NOT NULL COMMENT 'Descripcion corta del elemento del dominio',
startdate datetime NOT NULL COMMENT 'fecha de inicio de validez del elemento del dominio',
enddate datetime NOT NULL COMMENT 'fecha de fin de validez del elemento del dominio'
);

--REM INSERTING into Domains
Insert into Domains (APPDOMAIN,NAMEDOMAIN, code,description,descriptionXL,descriptionXS,startdate,enddate) values ('SICOSS','CONCEPTOS GASTO','36','GASTOS FSE','GASTOS IMPUTABLES AL FONDO SOCIAL EUROPEO','GASTOS FSE',"2017/01/01 00:00:00.000000000","2018/12/31 00:00:00.000000000");
Insert into Domains (APPDOMAIN,NAMEDOMAIN,code,description,descriptionXL,descriptionXS,startdate,enddate) values ('SICOSS','CONCEPTOS GASTO','37','GASTOS FROB','GASTOS IMPUTABLES AL FROB','GASTOS FROB',"2017/01/01 00:00:00.000000000","2018/12/31 00:00:00.000000000");
Insert into Domains (APPDOMAIN,NAMEDOMAIN,code,description,descriptionXL,descriptionXS,startdate,enddate) values ('SICOSS','CONCEPTOS FACT','01','FACTURACION FROB','FACTURACION RELATIVA AL FROB','FACTURACION FROB',"2017/01/01 00:00:00.000000000","2018/12/31 00:00:00.000000000");
Insert into Domains (APPDOMAIN,NAMEDOMAIN,code,description,descriptionXL,descriptionXS,startdate,enddate) values ('SICOSS','CONCEPTOS FACT','02','FACTURACION FSE','FACTURACION RELATIVA AL FSE','FACTURACION FSE',"2017/01/01 00:00:00.000000000","2018/12/31 00:00:00.000000000");


COMMIT;
