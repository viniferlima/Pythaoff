CREATE TABLE curso 
( 
 id_curso INTEGER PRIMARY KEY,  
 nome_curso VARCHAR(50),  
 descricao VARCHAR(50),  
); 

CREATE TABLE matricula 
( 
 id_matricula INTEGER PRIMARY KEY,  
 idpessoa Integer,  
 idaula Integer,  
 status INTEGER,  
); 

CREATE TABLE notas 
( 
 id_nota INTEGER PRIMARY KEY,  
 nota FLOAT,  
 idmatricula Integer,  
); 

CREATE TABLE aulas 
( 
 id_aulas INTEGER,  
 idcurso Integer,  
 nome_aula VARCHAR(50),  
 data_inicio DATE,  
 data_fim DATE,  
 qty_aulas INTEGER,  
); 

CREATE TABLE chamada 
( 
 id_chamada INTEGER,  
 idaulas Integer,  
 idmatricula Integer,  
 presenca INTEGER,  
); 

ALTER TABLE matricula ADD FOREIGN KEY(idpessoa) REFERENCES pessoa (idpessoa)
ALTER TABLE matricula ADD FOREIGN KEY(idaula) REFERENCES aulas (idaula)
ALTER TABLE notas ADD FOREIGN KEY(idmatricula) REFERENCES matricula (idmatricula)
ALTER TABLE aulas ADD FOREIGN KEY(idcurso) REFERENCES curso (idcurso)
ALTER TABLE chamada ADD FOREIGN KEY(idaulas) REFERENCES aulas (idaulas)
ALTER TABLE chamada ADD FOREIGN KEY(idmatricula) REFERENCES matricula (idmatricula)
ALTER TABLE avaliacao_curso ADD FOREIGN KEY(idmatricula) REFERENCES matricula (idmatricula)