CREATE TABLE public.lookup_type
(
    id uuid NOT NULL,
    date_created timestamp without time zone,
    date_modified timestamp without time zone,
    type_description character varying(255) COLLATE pg_catalog."default",
    type_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT lookup_type_pkey PRIMARY KEY (id)
);

CREATE TABLE public.lookup_data
(
    id uuid NOT NULL,
    date_created timestamp without time zone,
    date_modified timestamp without time zone,
    data_description character varying(255) COLLATE pg_catalog."default",
    data_name character varying(255) COLLATE pg_catalog."default",
    lookup_type_id uuid NOT NULL,
    CONSTRAINT lookup_data_pkey PRIMARY KEY (id),
    CONSTRAINT fk40uhsgejsou7g93p9jvs08a5 FOREIGN KEY (lookup_type_id)
        REFERENCES public.lookup_type (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.menu_item
(
    id uuid NOT NULL,
    date_created timestamp without time zone,
    date_modified timestamp without time zone,
    action character varying(255) COLLATE pg_catalog."default",
    path character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT menu_item_pkey PRIMARY KEY (id)
);

CREATE TABLE public.product
(
    id uuid NOT NULL,
    date_created timestamp without time zone,
    date_modified timestamp without time zone,
    image_source character varying(255) COLLATE pg_catalog."default",
    product_id character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    url character varying(255) COLLATE pg_catalog."default",
    product_type_id uuid,
    site_id uuid,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT fk6m5ut0v3xmldpsik4e45hxpck FOREIGN KEY (product_type_id)
        REFERENCES public.lookup_data (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkhbgtdgm1cpv8e4rnmd1guutdu FOREIGN KEY (site_id)
        REFERENCES public.lookup_data (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.wishlist
(
    id uuid NOT NULL,
    date_created timestamp without time zone,
    date_modified timestamp without time zone,
    CONSTRAINT wishlist_pkey PRIMARY KEY (id)
);

CREATE TABLE public.wishlist_item
(
    id uuid NOT NULL,
    date_created timestamp without time zone,
    date_modified timestamp without time zone,
    display_order integer NOT NULL,
    product_id uuid NOT NULL,
    wishlist_id uuid,
    CONSTRAINT wishlist_item_pkey PRIMARY KEY (id),
    CONSTRAINT fk5iw5sajivrxnt4qjxqlgo8yb1 FOREIGN KEY (wishlist_id)
        REFERENCES public.wishlist (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk5s5jxai41c8tqklyy111ngqh7 FOREIGN KEY (product_id)
        REFERENCES public.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.app_user
(
    id uuid NOT NULL,
    date_created timestamp without time zone,
    date_modified timestamp without time zone,
    email character varying(255) COLLATE pg_catalog."default",
    enabled boolean NOT NULL,
    password character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    wishlist_id uuid,
    CONSTRAINT app_user_pkey PRIMARY KEY (id),
    CONSTRAINT fkpnuqwnarcdgtp0i5fhptjhyii FOREIGN KEY (wishlist_id)
        REFERENCES public.wishlist (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

