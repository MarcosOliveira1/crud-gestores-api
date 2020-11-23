CREATE TABLE public.
(
  id serial NOT NULL,
  data_nascimento date,
  matricula character varying(255),
  nome character varying(255),
  setor character varying(255),
  CONSTRAINT gestor_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.gestor
  OWNER TO postgres;
