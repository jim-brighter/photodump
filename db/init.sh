#!/bin/bash

set -e

psql -v ON_ERROR_STOP=1 -U postgres <<-EOSQL
    SELECT pg_terminate_backend(pg_stat_activity.pid)
        FROM pg_stat_activity
        WHERE pg_stat_activity.datname = 'imagedb';
    DROP DATABASE IF EXISTS imagedb;
    CREATE DATABASE IMAGEDB OWNER postgres;
EOSQL

psql -v ON_ERROR_STOP=1 -d imagedb -U postgres <<-EOSQL    
    CREATE TABLE IMAGES (
        IMG_ID bigint,
        IMG_TITLE varchar(255),
        IMG_URL varchar(255),
        IMG_SUBMITTER varchar(255),
        CONSTRAINT IMG_ID_PK PRIMARY KEY(IMG_ID)
    );
    CREATE TABLE CREDENTIALS (
        CREDS_ID bigint,
        CREDS_USERNAME varchar(255),
        CREDS_PW_HASH varchar(255),
        CREDS_ROLE varchar(255),
        CONSTRAINT CREDS_ID PRIMARY KEY(CREDS_ID)
    );
    
    CREATE SEQUENCE creds_seq START 1;
    CREATE SEQUENCE image_seq START 1;
    
    INSERT INTO CREDENTIALS (CREDS_ID, CREDS_USERNAME, CREDS_PW_HASH, CREDS_ROLE) VALUES (1, 'admin', '\$2a\$10\$w7ss9iVHYuyH.o25uXwD5uVAzs/Bmc9Ersv0OR0w1MeD77IA7vjyu', 'ADMIN');
EOSQL