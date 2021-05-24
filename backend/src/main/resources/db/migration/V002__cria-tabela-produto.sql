CREATE TABLE produto (
	
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(60) NOT NULL,
	preco DECIMAL(10,2) NOT NULL,	
	quantidade_estoque INT NOT NULL,
	categoria_id BIGINT NOT NULL
	
);

ALTER TABLE produto ADD CONSTRAINT fk_produto_categoria
FOREIGN KEY (categoria_id) REFERENCES categoria (id);