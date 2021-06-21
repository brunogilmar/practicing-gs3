INSERT INTO TB_USUARIO(cd_seq_usuario, no_usuario, ds_usuario, ds_senha)
    VALUES(1, 'Bruno Abreu', 'admin', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO TB_USUARIO(cd_seq_usuario, no_usuario, ds_usuario, ds_senha)
    VALUES(2, 'Abreu Bruno', 'comum', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO TB_PERFIL(cd_seq_perfil, no_perfil)
    VALUES(1, 'ROLE_ADMIN');
INSERT INTO TB_PERFIL(cd_seq_perfil, no_perfil)
    VALUES(2, 'ROLE_COMUM');

INSERT INTO TB_USUARIO_PERFIL(fk_usuario, fk_perfil)
    VALUES(1, 1);
INSERT INTO TB_USUARIO_PERFIL(fk_usuario, fk_perfil)
    VALUES(2, 2);

INSERT INTO TD_TIPO_TELEFONE(cd_tipo_telefone, ds_tipo_telefone, st_ativo)
    VALUES(1, 'Residencial', true);
INSERT INTO TD_TIPO_TELEFONE(cd_tipo_telefone, ds_tipo_telefone, st_ativo)
    VALUES(2, 'Comercial', true);
INSERT INTO TD_TIPO_TELEFONE(cd_tipo_telefone, ds_tipo_telefone, st_ativo)
    VALUES(3, 'Celular', true);
/*
INSERT INTO TB_ENDERECO(cd_seq_endereco, nu_cep, ds_logradouro, ds_bairro, ds_cidade, sg_uf, ds_complemento)
    VALUES(1, '73350105', 'Quadra 01 Conjunto E', 'SRL', 'Planaltina', 'DF', 'LOTE');

INSERT INTO TB_CLIENTE(cd_seq_cliente, no_cliente, nu_cpf, fk_endereco, st_ativo, usuario, dh_inclusao, dh_alteracao)
    VALUES(1, 'Bruno Abreu', '02883011109', 1, true, 'admin', '2021-06-14 22:31:44', null);

INSERT INTO TB_TELEFONE(cd_seq_telefone, fk_tp_telefone, nu_telefone, fk_cliente)
    VALUES(1, 1, '6133889098', 1);
INSERT INTO TB_TELEFONE(cd_seq_telefone, fk_tp_telefone, nu_telefone, fk_cliente)
    VALUES(2, 3, '61989987665', 1);

INSERT INTO TB_EMAIL(cd_seq_email, ds_email, fk_cliente)
    VALUES(1, 'brunogilmar@gmail.com', 1);
INSERT INTO TB_EMAIL(cd_seq_email, ds_email, fk_cliente)
    VALUES(2, 'bruno.abreu@sonda.com.br', 1);
*/