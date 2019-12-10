--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`id`, `aforo`, `descripcion`, `fecha`, `nombre`) VALUES
(1, 500, 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-01-31', 'Moto GP'),
(2, 500, 'Valencia Open 500 es un torneo de tenis que se disputa en el Ágora y que atrae la atención de multitud de medios y espectadores.', '2020-03-11', 'Valencia Open 500'),
(3, 500, 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-04-22', 'XX Rallye Ciudad de València'),
(4, 500, 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-08-05', 'Maratón 2020 10k'),
(5, 500, 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-07-14', 'Maratón 2020 20k'),
(6, 500, 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-09-18', 'Maratón 2020 30k'),
(7, 500, 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-02-20', 'CicloCross ciudad de Valencia'),
(8, 500, 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-02-13', 'Atletismo en pista cubierta'),
(9, 500, 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-06-06', 'Miniolimpiadas'),
(10, 500, 'Valencia se convierte en capital del motociclismo con la celebración del campeonato de Moto GP', '2020-07-28', 'Multiaventura en familia');

--
-- Volcado de datos para la tabla `registros`
--

INSERT INTO `registros` (`id`, `evento_id`, `usuario_id`) VALUES
(1, 9, 1),
(2, 2, 2),
(3, 9, 3),
(4, 5, 4),
(5, 4, 5);

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `apellidos`, `email`, `nombre`, `evento_id`) VALUES
(1, 'Gil', 'asdf@asdf.com', 'María', 9),
(2, 'Ramos', 'asdf@asdf.com', 'Nicolás', 2),
(3, 'Ruiz', 'asdf@asdf.com', 'Dolores', 9),
(4, 'García', 'asdf@asdf.com', 'Toni', 5),
(5, 'Martín', 'asdf@asdf.com', 'Josema', 4);