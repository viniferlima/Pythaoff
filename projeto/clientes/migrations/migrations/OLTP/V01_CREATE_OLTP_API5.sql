CREATE TABLE pessoa 
( 
 id_pessoa INTEGER PRIMARY KEY,  
 nome_pessoa VARCHAR(50),  
 id_permissao Integer,  
 email VARCHAR(50),  
); 

CREATE TABLE acesso 
( 
 id_acesso INTEGER PRIMARY KEY,  
 hora_acesso DATE,  
 id_pessoa Integer,  
); 

CREATE TABLE permissao 
( 
 id_permissao INTEGER PRIMARY KEY,  
 tipo_permissao INTEGER,  
); 


ALTER TABLE pessoa ADD FOREIGN KEY(id_permissao) REFERENCES permissao (id_permissao)
ALTER TABLE acesso ADD FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa)