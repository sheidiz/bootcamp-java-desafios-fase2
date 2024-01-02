import React from 'react'
import FotoComponent from '../FotoComponent/FotoComponent';
import DatosPersonalesComponent from '../DatosPersonalesComponent/DatosPersonalesComponent';
import MyCVStyle from "./MiCVComponent.module.css";
import ExperienciaLaboralComponent from '../ExperienciaLaboralComponent/ExperienciaLaboralComponent';
import EducacionComponent from '../EducacionComponent/EducacionComponent';

function MiCVComponent() {
    return (
        <div className={`${MyCVStyle.container} d-flex flex-column flex-md-row`}>
            <div className={MyCVStyle.col1}>
                <FotoComponent />
                <DatosPersonalesComponent />
            </div>
            <div className={MyCVStyle.col2}>
                <EducacionComponent />
                <ExperienciaLaboralComponent />
            </div>
        </div>
    )
}

export default MiCVComponent