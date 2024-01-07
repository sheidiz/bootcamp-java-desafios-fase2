import { useRef } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { modifyTurno } from '../../redux/turnos/turnos';
import { setCantidadTurnos } from '../../redux/turnos/cantidadTurnos';
import { crearTurno, crearTurnoOficial } from '../domain/turnos-domain';

export default function CrearTurno({ visible, onClose, tipoTurno }) {
    const cantidad = useSelector(store => store.cantidadTurnos)
    const dispatcher = useDispatch();

    const fechaTurnoRef = useRef();
    const motivoRef = useRef();
    const nombreOficialRef = useRef();
    const apellidoOficialRef = useRef();

    if (!visible) return null;

    const cargarTurno = (e) => {
        e.preventDefault();

        let nuevoTurno = crearTurno(cantidad + 1, 'Turno Programado.', fechaTurnoRef.current.value, tipoTurno, motivoRef.current.value);

        if (tipoTurno === 'Oficial') {
            nuevoTurno = crearTurnoOficial(nuevoTurno, nombreOficialRef.current.value, apellidoOficialRef.current.value)
        }

        dispatcher(modifyTurno({ [cantidad + 1]: nuevoTurno }));
        dispatcher(setCantidadTurnos(cantidad + 1));

        if (fechaTurnoRef.current) fechaTurnoRef.current.value = '';
        if (motivoRef.current) motivoRef.current.value = '';
        if (nombreOficialRef.current) nombreOficialRef.current.value = '';
        if (apellidoOficialRef.current) apellidoOficialRef.current.value = '';
    }
    
    return (
        <div className="m-2 p-4 container border">
            <form className="mb-3 row g-2" onSubmit={(e) => cargarTurno(e)}>
                <div className="col-12 col-md-6">
                    <label htmlFor="inputFechaTurno" className="form-label">Fecha Turno</label>
                    <input type={tipoTurno == "Online" ? 'datetime-local' : 'date'} className="form-control" id="inputFechaTurno" ref={fechaTurnoRef} required />
                </div>
                <div className="col-12 col-md-6">
                    <label htmlFor="inputMotivo" className="form-label">Motivo</label>
                    <input type="text" className="form-control" id="inputMotivo" placeholder='Baja de cuenta, Retiro de productos, etc.' ref={motivoRef} required />
                </div>

                {tipoTurno === 'Oficial' &&
                    <>
                        <div className="col-12 col-md-6">
                            <label htmlFor="inputNombreOficial" className="form-label">Nombre del oficial</label>
                            <input type="text" className="form-control" id="inputNombreOficial" placeholder="Juan" ref={nombreOficialRef} required />
                        </div>
                        <div className="col-12 col-md-6">
                            <label htmlFor="inputApellidoOficial" className="form-label">Apellido del oficial</label>
                            <input type="text" className="form-control" id="inputApellidoOficial" placeholder="Perez" ref={apellidoOficialRef} required />
                        </div>
                    </>
                }
                <div className="col-12 d-flex gap-2">
                    <button type="submit" className="btn btn-success">Solicitar turno</button>
                    <button className='btn btn-dark' onClick={() => onClose()}>Cerrar</button>
                </div>
            </form>
        </div>
    )
}
