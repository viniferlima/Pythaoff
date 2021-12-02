CREATE TABLE DimPessoa 
( 
 id INTEGER PRIMARY KEY,  
 nome VARCHAR,  
 email VARCHAR(n),  
 permissao VARCHAR(n),  
); 

CREATE TABLE DimTempo 
( 
 id INTEGER PRIMARY KEY,  
 mes INTEGER,  
 semestre INTEGER,  
 ano INTEGER,  
 dia INTEGER,  
); 

CREATE TABLE DimAulas 
( 
 id INTEGER PRIMARY KEY,  
 nome_aula VARCHAR(n),  
 data_inicio DATE,  
 data_fim DATE,  
 qty_aulas INTEGER,  
); 


CREATE TABLE FactAcesso 
( 
 idDimTempo Integer,  
 idDimPerssoa Integer,  
 idDimAula Integer,  
 qty_acesso INTEGER,  
); 

ALTER TABLE FactAcesso ADD FOREIGN KEY(idDimTempo) REFERENCES DimTempo (idDimTempo)
ALTER TABLE FactAcesso ADD FOREIGN KEY(idDimPerssoa) REFERENCES DimPessoa (idDimPerssoa)
ALTER TABLE FactAcesso ADD FOREIGN KEY(idDimAula) REFERENCES DimAulas (idDimAula)