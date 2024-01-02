import React, { useRef, useState } from 'react';
import { toFecha } from '../utils/ValidacionFechas';
import Mensaje from './Mensaje';

function FechaValidaComponent() {

    const fechaRef = useRef(null);
    const [mensaje, setMensaje] = useState("");

    const handleFormSubmit = (e) => {
        e.preventDefault();

        const fecha = fechaRef.current.value;

        const fechaValidada = toFecha(fecha);

        if (fechaValidada) {
            setMensaje("Fecha Correcta \n" + "[ " + "Día: " + fechaValidada.dia + " | Mes: " + fechaValidada.mes + " | Año: " + fechaValidada.anio + " ]");
        } else {
            setMensaje("Fecha inválida.");
        }
    }

    return (
        <div className="mt-5 d-flex flex-column align-items-center gap-1">
            <h1>Ingrese una fecha:</h1>
            <form className="d-flex gap-2 justify-content-center" onSubmit={handleFormSubmit}>
                <input type="text" id="fecha" ref={fechaRef} placeholder="dd/mm/aaaa" />
                <button type="submit">Validar Fecha</button>
            </form>
            {mensaje && <Mensaje>{mensaje}</Mensaje>}
        </div>
    )
}

export default FechaValidaComponent