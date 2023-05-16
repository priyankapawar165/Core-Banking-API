
-- Table: public.bank_account

-- DROP TABLE public.bank_account;

CREATE TABLE IF NOT EXISTS bank_account
(
    bank_account_id integer NOT NULL DEFAULT nextval('bank_account_serial'::regclass),
    account_type character varying(255) COLLATE pg_catalog."default",
    account_no bigint NOT NULL,
    customer_id integer NOT NULL,
    account_balance numeric(5,2) NOT NULL,
    CONSTRAINT pk_bank_account PRIMARY KEY (bank_account_id),
    CONSTRAINT fk_bank_account FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)



-- Table: public.customer

-- DROP TABLE public.customer;

CREATE TABLE IF NOT EXISTS customer
(
    customer_id integer NOT NULL DEFAULT nextval('customer_serial'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT pk_customer PRIMARY KEY (customer_id)
)

-- Table: public.transaction

-- DROP TABLE public.transaction;

CREATE TABLE IF NOT EXISTS transaction
(
    transaction_no integer NOT NULL DEFAULT nextval('transaction_serial'::regclass),
    bank_account_id integer NOT NULL,
    amount numeric(7,4),
    transaction_type character varying(255) COLLATE pg_catalog."default",
    created_date date NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (transaction_no),
    CONSTRAINT fk_transaction FOREIGN KEY (bank_account_id)
        REFERENCES public.bank_account (bank_account_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


