CREATE TABLE avaliacao_curso 
( 
 idmatricula Integer,  
 sugestao VARCHAR(150),  
 nota_organizacao INTEGER,  
 nota_ambiente INTEGER,  
 nota_conteudo INTEGER,  
 nota_material INTEGER,  
 id_aval INT PRIMARY KEY,  
); 

CREATE TABLE TempoOn 
( 
 idaulas Integer,  
 idmatricula Integer,  
 horaLogin DATE,  
 horaLogout DATE,  
 id_tempoon INT PRIMARY KEY,  
); 

ALTER TABLE TempoOn ADD FOREIGN KEY(idaulas) REFERENCES aulas (idaulas)
ALTER TABLE TempoOn ADD FOREIGN KEY(idmatricula) REFERENCES matricula (idmatricula)