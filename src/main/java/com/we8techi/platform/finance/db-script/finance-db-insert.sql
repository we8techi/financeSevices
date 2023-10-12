-- Roles data insert

INSERT INTO financedb.roles
(id, role_name, details, active, created, created_by, updated, updated_by)
VALUES(1, 'ADMIN', 'ADMIN role', true, '2023-09-22 18:26:47.073', 'System', NULL, NULL);
INSERT INTO financedb.roles
(id, role_name, details, active, created, created_by, updated, updated_by)
VALUES(2, 'User', 'User role', true, '2023-09-22 18:30:31.005', 'System', NULL, NULL);
INSERT INTO financedb.roles
(id, role_name, details, active, created, created_by, updated, updated_by)
VALUES(3, 'SUPER_ADMIN', 'Super ADMIN role', true, '2023-10-05 10:45:33.733', 'System', NULL, NULL);

---- Users data insert

INSERT INTO financedb.users
(id, email, username, pwd, active, created, created_by, updated, updated_by, company_id)
VALUES(2, 'dhiraj.jadhav@gmail.com', 'dhirajj', 'dhiraj#123', true, '2023-09-22 19:25:05.794', 'System', '2023-09-22 19:25:06.483', 'System', 1);
INSERT INTO financedb.users
(id, email, username, pwd, active, created, created_by, updated, updated_by, company_id)
VALUES(3, 'vikas.bharati@gmail.com', 'vikasb', 'vikas#123', true, '2023-09-22 19:41:28.749', 'System', '2023-09-22 19:41:28.749', 'System', 1);
INSERT INTO financedb.users
(id, email, username, pwd, active, created, created_by, updated, updated_by, company_id)
VALUES(5, 'balaji.m@gmail.com', 'balaji', 'balaji#123', true, '2023-09-25 17:56:36.966', 'System', '2023-09-25 17:56:36.966', 'System', 1);
INSERT INTO financedb.users
(id, email, username, pwd, active, created, created_by, updated, updated_by, company_id)
VALUES(6, 'sushant.s@gmail.com', 'Sushant', 'sushant#123', true, '2023-09-25 22:06:03.595', 'System', '2023-09-25 22:06:03.595', 'System', 1);
INSERT INTO financedb.users
(id, email, username, pwd, active, created, created_by, updated, updated_by, company_id)
VALUES(7, 'shekhar.s@gmail.com', 'Shekhars', 'shekhar#123', true, '2023-09-25 22:51:50.537', 'System', '2023-09-25 22:51:50.537', 'System', 1);
INSERT INTO financedb.users
(id, email, username, pwd, active, created, created_by, updated, updated_by, company_id)
VALUES(8, 'shekhar.s@gmail.com', 'Shekhars111', 'shekhar#12344', true, '2023-10-04 23:06:02.670', 'System', '2023-10-04 23:06:02.670', 'System', 1);

---- user_roles data insert

INSERT INTO financedb.user_roles
(id, users_id, active, created, created_by, updated, updated_by, role_id)
VALUES(2, 3, true, '2023-09-22 19:41:29.444', 'System', '2023-09-22 19:41:29.444', 'System', 2);
INSERT INTO financedb.user_roles
(id, users_id, active, created, created_by, updated, updated_by, role_id)
VALUES(4, 5, true, '2023-09-25 17:56:37.932', 'System', '2023-09-25 17:56:37.932', 'System', 2);
INSERT INTO financedb.user_roles
(id, users_id, active, created, created_by, updated, updated_by, role_id)
VALUES(5, 6, true, '2023-09-25 22:06:04.751', 'System', '2023-09-25 22:06:04.751', 'System', 2);
INSERT INTO financedb.user_roles
(id, users_id, active, created, created_by, updated, updated_by, role_id)
VALUES(6, 7, true, '2023-09-25 22:51:51.078', 'System', '2023-09-25 22:51:51.078', 'System', 2);
INSERT INTO financedb.user_roles
(id, users_id, active, created, created_by, updated, updated_by, role_id)
VALUES(7, 8, true, '2023-10-04 23:06:03.243', 'System', '2023-10-04 23:06:03.243', 'System', 2);
INSERT INTO financedb.user_roles
(id, users_id, active, created, created_by, updated, updated_by, role_id)
VALUES(1, 2, true, '2023-09-22 19:25:10.677', 'System', '2023-09-22 19:25:11.160', 'System', 3);

------------ privilege data insert

INSERT INTO financedb.privilege
(id, "name", active, created, created_by, updated, updated_by)
VALUES(1, 'LOAN', true, '2023-10-02 20:27:48.631', 'System', NULL, NULL);
INSERT INTO financedb.privilege
(id, "name", active, created, created_by, updated, updated_by)
VALUES(2, 'PIGMI', true, '2023-10-02 20:28:12.153', 'System', NULL, NULL);
INSERT INTO financedb.privilege
(id, "name", active, created, created_by, updated, updated_by)
VALUES(3, 'ADMIN', true, '2023-10-02 20:28:30.652', 'System', NULL, NULL);

----- roles_privileges data insert

INSERT INTO financedb.roles_privileges
(id, roles_id, privileges_id)
VALUES(1, 1, 1);
INSERT INTO financedb.roles_privileges
(id, roles_id, privileges_id)
VALUES(2, 1, 2);
INSERT INTO financedb.roles_privileges
(id, roles_id, privileges_id)
VALUES(3, 1, 3);
INSERT INTO financedb.roles_privileges
(id, roles_id, privileges_id)
VALUES(4, 2, 1);
INSERT INTO financedb.roles_privileges
(id, roles_id, privileges_id)
VALUES(5, 2, 2);

-------------------------------------------------------------------------------------------------------------------------------------------- 


-- financedb.customer definition

-- Drop table

-- DROP TABLE financedb.customer;

CREATE TABLE financedb.customer (
	id bigserial NOT NULL,
	company_id int8 NOt NULL,
	age int4 NOT NULL,
	"name" varchar(255) NULL,
	pan_details varchar(255) NULL,
	aadhar_details varchar(255) NULL,
	address_proof varchar(255) NULL,
	active bool NOT NULL,
	created timestamp NOT NULL,
	created_by varchar(255) NOT NULL,
	updated timestamp NOT NULL,
	updated_by varchar(255) NOT NULL
);

-- Drop table

-- DROP TABLE financedb.Loan_account;

CREATE TABLE financedb.Loan_account (
	id bigserial NOT NULL,
	customer_id int8 NOT NULL,
	interest_rate decimal(2,2) NOT NULL,
	principal_amount decimal(12,2) NOT null, -- Loan disburse amount
	total_amount decimal(12,2) NOT null, -- Principle + Intrest rate amount 
	collected_amount decimal(12,2) NOT null, -- Daily collected amount
	payment_details varchar NOT NULL,
	payment_mode varchar NOT NULL, -- CASH / CHECK / BANK transfer
    number_of_days number NOT null, -- 100 days maximum
	loan_type varchar NOT NULL, -- Fixed / variable	
	loan_status varchar NOT NULL, -- Rejected /On hold /Inprogress / Disburse / Approved / Closed
	active bool NOT NULL, 
	created timestamp NOT NULL,
	created_by varchar(255) NOT NULL,
	updated timestamp NOT NULL,
	updated_by varchar(255) NOT NULL
);


-- Drop table

-- DROP TABLE financedb.PIGMI_account;

CREATE TABLE financedb.PIGMI_account (
	id bigserial NOT NULL,
	customer_id int8 NOT NULL,
	interest_rate decimal(2,2) NOT NULL,
	amount decimal(12,2) NOT null,
	payment_details varchar NOT NULL,
	payment_mode varchar NOT NULL, -- CASH / CHECK / BANK transfer
    number_of_days number NOT null, -- 100 days maximum
	pigmi_status varchar NOT NULL, -- Rejected /On hold /Inprogress / Disburse / Approved / Closed
	active bool NOT NULL, 
	created timestamp NOT NULL,
	created_by varchar(255) NOT NULL,
	updated timestamp NOT NULL,
	updated_by varchar(255) NOT NULL
);


-- financedb.capital_transaction definition

-- Drop table

-- DROP TABLE financedb.capital_transaction;

CREATE TABLE financedb.capital_transaction (
	id bigserial NOT NULL,
	customer_id int8 NOT NULL,
	capital_amount decimal(12,2) NOT null,
	credit_amount decimal(12,2) NOT null,
	debit_amount decimal(12,2) NOT null,
	transaction_id varchar,
	transaction_type varchar NOT NULL, -- LOAN / PIGMI  
	capital_type varchar NOT NULL, -- bank / in hand
	transaction_details varchar NOT NULL,
	active bool NOT NULL,
	created timestamp NOT NULL,
	created_by varchar(255) NOT NULL,
	updated timestamp NOT NULL,
	updated_by varchar(255) NOT NULL	
	);

-- financedb.loan_transaction definition

-- Drop table

-- DROP TABLE financedb.loan_transaction;

CREATE TABLE financedb.loan_transaction (
	id bigserial NOT NULL,
	Loan_account_id int8 NOT NULL,
	transaction_id varchar,
	amount decimal(12,2) NOT null,
	payment_details varchar NOT NULL,
	payment_mode varchar NOT NULL, -- CASH / CHECK / BANK transfer
	active bool NOT NULL,
	created timestamp NOT NULL,
	created_by varchar(255) NOT NULL,
	updated timestamp NOT NULL,
	updated_by varchar(255) NOT NULL
)


-- financedb.pigmi_transaction definition

-- Drop table

-- DROP TABLE financedb.pigmi_transaction;

CREATE TABLE financedb.pigmi_transaction (
	id bigserial NOT NULL,
	pigmi_account_id int8 NOT NULL,
	transaction_id varchar,
	amount decimal(12,2) NOT null,
	payment_details varchar NOT NULL,
	payment_mode varchar NOT NULL, -- CASH / CHECK / BANK transfer
	active bool NOT NULL,
	created timestamp NOT NULL,
	created_by varchar(255) NOT NULL,
	updated timestamp NOT NULL,
	updated_by varchar(255) NOT NULL
)



