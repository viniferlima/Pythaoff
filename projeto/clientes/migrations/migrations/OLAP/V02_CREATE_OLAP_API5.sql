CREATE TABLE FactMatricula 
( 
 idDimCurso Integer,  
 idDimAulas Integer,  
 idDimPessoa Integer,  
 qty_ativos INTEGER,  
 qty_inativos INTEGER,  
); 

CREATE TABLE DimCurso 
( 
 id_curso INTEGER PRIMARY KEY,  
 nome_curso VARCHAR,  
); 

CREATE TABLE FactDesempenho 
( 
 idDimPessoa Integer,  
 idDimCurso Integer,  
 idDimAulas Integer,  
 nota FLOAT,  
 media_aluno INTEGER,  
 desempenho INTEGER,  
 tempo_online INT,  
);


ALTER TABLE FactMatricula ADD FOREIGN KEY(idDimCurso) REFERENCES DimCurso (idDimCurso)
ALTER TABLE FactMatricula ADD FOREIGN KEY(idDimAulas) REFERENCES DimAulas (idDimAulas)
ALTER TABLE FactMatricula ADD FOREIGN KEY(idDimPessoa) REFERENCES DimPessoa (idDimPessoa)
ALTER TABLE FactDesempenho ADD FOREIGN KEY(idDimPessoa) REFERENCES DimPessoa (idDimPessoa)
ALTER TABLE FactDesempenho ADD FOREIGN KEY(idDimCurso) REFERENCES DimCurso (idDimCurso)
ALTER TABLE FactDesempenho ADD FOREIGN KEY(idDimAulas) REFERENCES DimAulas (idDimAulas)