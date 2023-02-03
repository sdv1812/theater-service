create database theater;

CREATE TABLE booking
(
    id            BIGINT PRIMARY KEY,
    customer_name VARCHAR,
    seat          BIGINT not null,
    performance   bigint not null
);

create table performance
(
    id    bigint primary key,
    title varchar
);

create table seat
(
    id          bigint primary key,
    row_num     char(1),
    num         integer,
    price       numeric(38, 2),
    description varchar
);

ALTER TABLE booking
    ADD CONSTRAINT fk_seat_id FOREIGN KEY (seat) REFERENCES seat (id);

ALTER TABLE booking
    ADD CONSTRAINT fk_performance_id FOREIGN KEY (performance) REFERENCES performance (id);