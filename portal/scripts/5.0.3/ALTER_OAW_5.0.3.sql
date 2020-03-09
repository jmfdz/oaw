ALTER TABLE ambitos_lista ADD descripcion VARCHAR(1024) NULL;

UPDATE ambitos_lista SET descripcion = 'Administración General del Estado' WHERE id_ambito = 1;
UPDATE ambitos_lista SET descripcion = 'Comunidades Autónomas' WHERE id_ambito = 2;
UPDATE ambitos_lista SET descripcion = 'Entidades Locales' WHERE id_ambito = 3;
UPDATE ambitos_lista SET descripcion = 'Otros' WHERE id_ambito = 4;

CREATE INDEX tanalisis_cod_rastreo ON tanalisis (cod_rastreo);


ALTER TABLE ambitos_lista ROW_FORMAT=COMPRESSED;
ALTER TABLE basic_service ROW_FORMAT=COMPRESSED;
ALTER TABLE cartucho ROW_FORMAT=COMPRESSED;
ALTER TABLE cartucho_rastreo ROW_FORMAT=COMPRESSED;
ALTER TABLE categoria ROW_FORMAT=COMPRESSED;
ALTER TABLE categorias_lista ROW_FORMAT=COMPRESSED;
ALTER TABLE categoria_termino ROW_FORMAT=COMPRESSED;
ALTER TABLE clasificacion_etiqueta ROW_FORMAT=COMPRESSED;
ALTER TABLE complejidades_lista ROW_FORMAT=COMPRESSED;
ALTER TABLE cuenta_cliente ROW_FORMAT=COMPRESSED;
ALTER TABLE cuenta_cliente_cartucho ROW_FORMAT=COMPRESSED;
ALTER TABLE cuenta_cliente_usuario ROW_FORMAT=COMPRESSED;
ALTER TABLE dependencia ROW_FORMAT=COMPRESSED;
ALTER TABLE enlaces_rotos ROW_FORMAT=COMPRESSED;
ALTER TABLE etiqueta ROW_FORMAT=COMPRESSED;
ALTER TABLE export_aspect_score ROW_FORMAT=COMPRESSED;
ALTER TABLE export_category ROW_FORMAT=COMPRESSED;
ALTER TABLE export_observatory ROW_FORMAT=COMPRESSED;
ALTER TABLE export_page ROW_FORMAT=COMPRESSED;
ALTER TABLE export_site ROW_FORMAT=COMPRESSED;
ALTER TABLE export_verification_modality ROW_FORMAT=COMPRESSED;
ALTER TABLE export_verification_page ROW_FORMAT=COMPRESSED;
ALTER TABLE export_verification_score ROW_FORMAT=COMPRESSED;
ALTER TABLE languages ROW_FORMAT=COMPRESSED;
ALTER TABLE lista ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorios_realizados ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_ambito ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_categoria ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_complejidad ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_estado ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_lista ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_metodologia ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_plantillas ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_proxy ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_tipo ROW_FORMAT=COMPRESSED;
ALTER TABLE observatorio_usuario ROW_FORMAT=COMPRESSED;
ALTER TABLE periodicidad ROW_FORMAT=COMPRESSED;
ALTER TABLE rastreo ROW_FORMAT=COMPRESSED;
ALTER TABLE rastreos_realizados ROW_FORMAT=COMPRESSED;
ALTER TABLE roles ROW_FORMAT=COMPRESSED;
ALTER TABLE semilla_dependencia ROW_FORMAT=COMPRESSED;
ALTER TABLE semilla_etiqueta ROW_FORMAT=COMPRESSED;
ALTER TABLE tanalisis ROW_FORMAT=COMPRESSED;
ALTER TABLE tanalisis_css ROW_FORMAT=COMPRESSED;
ALTER TABLE termino ROW_FORMAT=COMPRESSED;
ALTER TABLE tguidelines ROW_FORMAT=COMPRESSED;
ALTER TABLE tincidencia ROW_FORMAT=COMPRESSED;
ALTER TABLE tipo_lista ROW_FORMAT=COMPRESSED;
ALTER TABLE tipo_rol ROW_FORMAT=COMPRESSED;
ALTER TABLE usuario ROW_FORMAT=COMPRESSED;
ALTER TABLE usuario_cartucho ROW_FORMAT=COMPRESSED;
ALTER TABLE usuario_rol ROW_FORMAT=COMPRESSED;