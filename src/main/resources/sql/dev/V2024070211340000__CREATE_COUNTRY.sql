-- Table: public.country
 
-- DROP TABLE IF EXISTS public.country;
 
CREATE TABLE IF NOT EXISTS public.country
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT country_pkey PRIMARY KEY (id),
    CONSTRAINT ukllidyp77h6xkeokpbmoy710d4 UNIQUE (name)
)
 
TABLESPACE pg_default;
 
ALTER TABLE IF EXISTS public.country
    OWNER to postgres;


