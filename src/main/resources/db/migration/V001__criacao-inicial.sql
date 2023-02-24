  create table cidade (
  	id bigserial not null,
  	nome varchar(60) not null,
  	estado_id bigint not null,

  	primary key (id)
  );

  create table cozinha (
  	id bigserial not null,
  	nome varchar(80),

  	primary key (id)
  );

  create table estado (
  	id bigserial not null,
  	nome varchar(60) not null,

  	primary key (id));

  create table forma_pagamento (
  	id bigserial not null,
  	descricao varchar(80),

  	primary key (id));

  create table grupo (
  	id bigserial not null,
  	nome varchar(80) not null,

  	primary key (id));

  create table grupo_permissao (
  	grupo_id bigint not null,
  	permissao_id bigint not null
  );

  create table permissao (
  	id bigserial not null,
  	descricao varchar(150) not null,
  	nome varchar(80) not null,

  	primary key (id)
  );

  create table produto (
  	id bigserial not null,
  	ativo boolean not null,
  	descricao varchar(150),
  	nome varchar(80),
  	preco numeric(38,2),
  	restaurante_id bigint not null,

  	primary key (id));

  create table restaurante (
  	id bigserial not null,
  	endereco_bairro varchar(80),
  	endereco_cep varchar(20),
  	endereco_complemento varchar(80),
  	endereco_logradouro varchar(80),
  	endereco_numero varchar(8),
  	nome varchar(255) not null,
  	taxa_frete numeric(38,2) not null,
  	cozinha_id bigint not null,
  	endereco_cidade_id bigint,

  	primary key (id)
  );

  create table restaurante_forma_pagamento (
  	restaurante_id bigint not null,
  	forma_pagamento_id bigint not null
  );

  create table usuario (
  	id bigserial not null,
  	email varchar(40) not null,
  	nome varchar(80) not null,
  	senha varchar(10) not null,

  	primary key (id)
  );

  create table usuario_grupo (
  	usuario_id bigint not null,
  	grupo_id bigint not null
  );

  alter table if exists cidade add constraint fk_cidade_estado_id foreign key (estado_id) references estado;

  alter table if exists grupo_permissao add constraint fk_gp_permissao_id foreign key (permissao_id) references permissao;

  alter table if exists grupo_permissao add constraint fk_gp_grupo_id foreign key (grupo_id) references grupo;

  alter table if exists produto add constraint fk_produto_restaurante_id foreign key (restaurante_id) references restaurante;

  alter table if exists restaurante add constraint fk_restaurante_cozinha_id foreign key (cozinha_id) references cozinha;

  alter table if exists restaurante add constraint fk_restaurante_endereco_cidade_id foreign key (endereco_cidade_id) references cidade;

  alter table if exists restaurante_forma_pagamento add constraint fk_restaurante_fp_forma_pagamento_id foreign key (forma_pagamento_id) references forma_pagamento;

  alter table if exists restaurante_forma_pagamento add constraint fk_restaurante_fp_restaurante_id foreign key (restaurante_id) references restaurante;

  alter table if exists usuario_grupo add constraint fk_ug_grupo_id foreign key (grupo_id) references grupo;

  alter table if exists usuario_grupo add constraint fk_ug_usuario_id foreign key (usuario_id) references usuario;
