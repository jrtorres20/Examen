CREATE TABLE prestamos
(
id int,
cliente bigint not null,
fecha DATE,
monto float not null default 0,
estado SMALLINT NOT NULL DEFAULT 0
);

CREATE TABLE cuentasdebito
(
cliente bigint not null,
monto float not null default 0,
estado SMALLINT NOT NULL DEFAULT 0
);


insert into prestamos(id, cliente, fecha, monto, estado) values
(1, 00103228,'2021-01-10', 37500.00, 0),
(2, 00103228,'2021-01-19', 725.18, 0),
(3, 00103228,'2021-01-31', 1578.22, 0),
(4, 00103228,'04-02-2021', 380.00, 0),
(1, 70099925,'2021-01-07', 2175.25, 1),
(2, 70099925,'2021-01-13', 499.99, 1),
(3, 70099925,'2021-01-24', 5725.18, 0),
(4, 70099925,'2021-02-07', 876.13, 0),
(1, 00298185,'2021-02-04', 545.55, 0),
(1, 15000125,'2020-12-31', 15220.00, 1);

insert into cuentasdebito(cliente, monto, estado) values
(00103228, 12375.28, 0),
(70099925, 3728.51, -1),
(00298185, 0.00, 1),
(15000125, 235.28, 0);

