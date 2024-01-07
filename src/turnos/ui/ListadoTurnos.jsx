import { useDispatch, useSelector } from 'react-redux';
import { modifyTurno } from '../../redux/turnos/turnos';
import { useRef } from 'react';
import { atenderTurno, finalizarTurno } from '../domain/turnos-domain';

function ListadoTurnos() {
  const dispatcher = useDispatch();
  const turnos = useSelector(store => store.turnos);
  const fechaFinalizacionRef = useRef();

  const atender = (turno) => {
    let turnoNuevo = atenderTurno(turno);
    dispatcher(modifyTurno({ [turno.id]: turnoNuevo }))
  }

  const finalizar = (e, turno) => {
    e.preventDefault();
    let turnoFinalizado = finalizarTurno(turno, fechaFinalizacionRef.current.value);
    dispatcher(modifyTurno({ [turno.id]: turnoFinalizado }))
  }

  return (
    <div className="m-2 p-2 d-flex gap-5">
      <div className="p-2 container bg-light">
        <h2 className="text-center">En espera</h2>
        <div className="d-flex flex-column gap-2">
          {turnos && Object.values(turnos).map((turno) => (
            turno && turno.estado.includes('Turno Programado.') &&
            <div key={turno.id} className="d-flex gap-3 align-items-center fs-5 border border-secondary p-2">
              <p className="m-0">T{turno.id} - {turno.tipoTurno}</p>
              <button onClick={() => atender(turno)}>Atender</button>
            </div>
          ))}
        </div>
      </div>
      <div className="p-2 container bg-light">
        <h2 className="text-center">Atendido</h2>
        <div className="d-flex flex-column gap-2">
          {turnos && Object.values(turnos).map((turno) => (
            turno && turno.estado.includes('Turno Atendido.') &&
            <div key={turno.id} className="mb-2 p-2 border fs-5">
              <p>Turno: {turno.id}</p>
              <p>Sector: {turno.tipoTurno}</p>
              <p>Motivo: {turno.motivo}</p>
              <form onSubmit={(e) => finalizar(e, turno)}>
                <div className="col-12 d-flex align-items-center">
                  <label htmlFor="inputFechaHoraFinalizacion" className="form-label">Fecha Finalización: </label>
                  <input type="datetime-local" className="form-control mb-2 ms-2 w-50 " id="inputFechaHoraFinalizacion" ref={fechaFinalizacionRef} required />
                </div>
                <button type="submit">Finalizar</button>
              </form>
            </div>
          ))}
        </div>

      </div>
    </div>
  );
}

export default ListadoTurnos