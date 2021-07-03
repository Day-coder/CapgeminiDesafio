CREATE DATABASE DesafioC;

USE DesafioC;

CREATE TABLE ANUNCIOC(
  Id int NOT NULL AUTO_INCREMENT,
  Investimento int not null,
  Nome_Anuncio varchar(255) NOT NULL,
  Nome_Cliente varchar(255) NOT NULL,
  Dia_Inicio int not NULL,
  Mes_Inicio int not NULL,
  Ano_Inicio int not NULL,
  Dia_Fim int not NULL,
  Mes_Fim int not NULL,
  Ano_Fim int not NULL,
  PRIMARY KEY (Id) );




SELECT * FROM ANUNCIOC;