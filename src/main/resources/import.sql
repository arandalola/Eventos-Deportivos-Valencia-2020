INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ( 'Moto GP', 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-01-31', 500);
INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ('Valencia Open 500', 'Valencia Open 500 es un torneo de tenis que se disputa en el Ágora y que atrae la atención de multitud de medios y espectadores.', '2020-03-11', 500);
INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ( 'XX Rallye Ciudad de València', 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-04-22', 500);
INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ( 'Maratón 2020 10k', 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-08-05', 500);
INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ( 'Maratón 2020 20k', 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-07-14', 500);
INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ( 'Maratón 2020 30k', 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-09-18', 500);
INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ( 'CicloCross ciudad de Valencia', 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-02-20', 500);
INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ( 'Atletismo en pista cubierta', 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-02-13', 500);
INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ( 'Miniolimpiadas', 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-06-06', 500);
INSERT INTO eventos (nombre, descripcion, fecha, aforo) VALUES ( 'Multiaventura en familia', 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-07-28', 500);

INSERT INTO usuarios ( nombre, apellidos, email, evento_id) VALUES ( 'María', 'Gil', 'asdf@asdf.com', 9);
INSERT INTO usuarios ( nombre, apellidos, email, evento_id) VALUES ( 'Nicolás', 'Ramos', 'asdf@asdf.com', 2);
INSERT INTO usuarios ( nombre, apellidos, email, evento_id) VALUES ( 'Dolores', 'Ruiz', 'asdf@asdf.com', 9);
INSERT INTO usuarios ( nombre, apellidos, email, evento_id) VALUES ( 'Toni', 'García', 'asdf@asdf.com', 5);
INSERT INTO usuarios ( nombre, apellidos, email, evento_id) VALUES ( 'Josema', 'Martín', 'asdf@asdf.com', 4);

INSERT INTO registros ( usuario_id, evento_id) VALUES (1, 9);
INSERT INTO registros ( usuario_id, evento_id) VALUES (2, 2);
INSERT INTO registros ( usuario_id, evento_id) VALUES (3, 9);
INSERT INTO registros ( usuario_id, evento_id) VALUES (4, 5);
INSERT INTO registros ( usuario_id, evento_id) VALUES (5, 4);

