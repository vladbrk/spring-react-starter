create schema ministry;

create table ministry.contractor (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255)
);

create table ministry.contract (
id BIGSERIAL PRIMARY KEY,
title VARCHAR(255),
start_date TIMESTAMP,
closure_date TIMESTAMP,
head_contractor_id BIGINT,
FOREIGN KEY (head_contractor_id) REFERENCES ministry.contractor(id)
);

create table ministry.act (
id BIGSERIAL PRIMARY KEY,
acceptance_date TIMESTAMP,
contract_id BIGINT,
FOREIGN KEY (contract_id) REFERENCES ministry.contract(id)
);

create table ministry.payment (
id BIGSERIAL PRIMARY KEY,
transfer_date TIMESTAMP,
act_id BIGINT,
from_contractor_id BIGINT,
to_contractor_id BIGINT,
amount BIGINT,
FOREIGN KEY (act_id) REFERENCES ministry.act(id),
FOREIGN KEY (from_contractor_id) REFERENCES ministry.contractor(id),
FOREIGN KEY (to_contractor_id) REFERENCES ministry.contractor(id)
);