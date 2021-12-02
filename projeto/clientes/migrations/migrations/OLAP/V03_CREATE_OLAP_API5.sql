CREATE TABLE FactReacao 
( 
 idDimPessoa Integer,  
 idDimAulas Integer,  
 tempo_presente FLOAT,  
 nota_reacao INTEGER,  
 data_reacao INTEGER,  
 media_reacao INTEGER,  
); 

CREATE TABLE FactPerformance 
( 
 desempenho FLOAT,  
 performance INT,  
 conclusao INT,  
 idDimCurso Integer,  
 idDimAulas Integer,  
); 

ALTER TABLE FactReacao ADD FOREIGN KEY(idDimPessoa) REFERENCES DimPessoa (idDimPessoa)
ALTER TABLE FactReacao ADD FOREIGN KEY(idDimAulas) REFERENCES DimAulas (idDimAulas)
ALTER TABLE FactPerformance ADD FOREIGN KEY(idDimCurso) REFERENCES DimCurso (idDimCurso)
ALTER TABLE FactPerformance ADD FOREIGN KEY(idDimAulas) REFERENCES DimAulas (idDimAulas)