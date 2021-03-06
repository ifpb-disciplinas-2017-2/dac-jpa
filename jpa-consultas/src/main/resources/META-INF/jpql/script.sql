CREATE TABLE DEPENDENTE (ID INTEGER NOT NULL, NOME VARCHAR(255), Chave_Emp INTEGER, PRIMARY KEY (ID))
CREATE TABLE EMPREGADO (ID INTEGER NOT NULL, NOME VARCHAR(255), chave_emp BIGINT, PRIMARY KEY (ID))
CREATE TABLE ENDERECO (ID INTEGER NOT NULL, BAIRRO VARCHAR(255), RUA VARCHAR(255), EMPREGADO_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE FACULDADE (ID BIGINT NOT NULL, DESCRICAO VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PROJETO (ID INTEGER NOT NULL, DESCRICAO VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE emp_proj (empregados_ID INTEGER NOT NULL, projetos_ID INTEGER NOT NULL, PRIMARY KEY (empregados_ID, projetos_ID))
ALTER TABLE DEPENDENTE ADD CONSTRAINT FK_DEPENDENTE_Chave_Emp FOREIGN KEY (Chave_Emp) REFERENCES EMPREGADO (ID)
ALTER TABLE EMPREGADO ADD CONSTRAINT FK_EMPREGADO_chave_emp FOREIGN KEY (chave_emp) REFERENCES FACULDADE (ID)
ALTER TABLE ENDERECO ADD CONSTRAINT FK_ENDERECO_EMPREGADO_ID FOREIGN KEY (EMPREGADO_ID) REFERENCES EMPREGADO (ID)
ALTER TABLE emp_proj ADD CONSTRAINT FK_emp_proj_empregados_ID FOREIGN KEY (empregados_ID) REFERENCES EMPREGADO (ID)
ALTER TABLE emp_proj ADD CONSTRAINT FK_emp_proj_projetos_ID FOREIGN KEY (projetos_ID) REFERENCES PROJETO (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
