# Desafío 3, Desarrollar una aplicación que permite listar los turnos de los cliente de un banco.

Crear una rama con el nombre feature/desafio-react-3,

-Considerar qué hay diferentes tipos de turnos :
- turnos para caja
- turnos para oficial
- turnos online

-Cada turno tiene mínimo la siguiente información:
- fecha_turno
- tipo_turno
- motivo: una descripción del motivo de turno: ej "baja de cuenta", "retiro de productos”,  etc.

-Luego cada turno puede tener sus particularidades.

-si es un turno de oficial deberá tener:

- el nombre y apellido del oficial

-En el caso de ser online:

- fecha y hora programada del turno

- fecha y hora de finalización.

Nota: El componente que liste los turnos deberá permitir atender un turno: y cuando esto suceda se deberá dejar constancia de la fecha de atención.

-Cuando finalice la atención dejar marcar una fecha de finalización.

-Usar una barra de navegación

-Usar un componente para crear los turnos (CrearTurno.jsx)

-Usar un componente para listar los turnos (ListadoTurnos.jsx)

-El manejo de estados puede ser por redux o rxjs
