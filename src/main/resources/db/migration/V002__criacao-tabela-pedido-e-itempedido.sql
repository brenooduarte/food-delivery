create table pedido (
	id bigserial not null,
	data_cancelamento timestamp(6),
	data_confirmacao timestamp(6),
	data_criacao timestamp(6) not null,
	data_entrega timestamp(6),
	endereco_bairro varchar(80),
  	endereco_cep varchar(20),
  	endereco_complemento varchar(80),
  	endereco_logradouro varchar(80),
  	endereco_numero varchar(8),
	status_pedido smallint not null,
	subtotal numeric(38,2) not null,
	taxa_frete numeric(38,2) not null,
	valor_total numeric(38,2) not null,
	usuario_cliente_id bigint not null,
	endereco_cidade_id bigint,
	forma_pagamento_id bigint not null,
	restaurante_id bigint not null,
    produto_id bigint not null,

	primary key (id)
);

create table item_pedido (
    id bigserial not null,
    observacao varchar(100),
    preco_total numeric(38,2),
    preco_unitario numeric(38,2),
    quantidade integer,
    pedido_id bigint not null,

    primary key (id)
);

alter table if exists pedido add constraint fk_forma_pagamento_id foreign key (forma_pagamento_id) references forma_pagamento;
alter table if exists pedido add constraint fk_restaurante_id foreign key (restaurante_id) references restaurante;
alter table if exists pedido add constraint fk_usuario_cliente_id foreign key (usuario_cliente_id) references usuario;
alter table if exists pedido add constraint fk_produto_id foreign key (produto_id) references produto;

alter table if exists item_pedido add constraint fk_pedido_id foreign key (pedido_id) references pedido;
