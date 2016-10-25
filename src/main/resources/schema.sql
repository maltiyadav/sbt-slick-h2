CREATE TABLE IF NOT EXISTS users (
    id BIGINT,
    name CHARACTER VARYING,
    email CHARACTER VARYING,
    created_ts TIMESTAMP,
    last_updated_time TIMESTAMP,
    enabled BOOLEAN,
    phone_num BIGSERIAL,
    dob TIMESTAMP
);
