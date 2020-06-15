drop table if exists GROOVY_SCRIPT;

create table GROOVY_SCRIPT (
    NAME varchar primary key,
    POSSIBLE_METHODS_TO_CALL varchar not null,
    SCRIPT binary(5000) not null
);