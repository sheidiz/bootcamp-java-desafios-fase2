import React from "react";
import data from "../../utils/data";
import EducacionItemComponent from "./EducacionItemComponent";

function EducacionComponent() {
    return (
        <div className="d-flex flex-column gap-1 p-4">
            <h3 className="fw-medium fs-2">Educación</h3>
            {
                data.educacion.map((item, index) => {
                    return (
                        <React.Fragment key={index}>
                            <EducacionItemComponent educacion={item} />
                        </React.Fragment>
                    )
                })
            }
        </div>
    )
}

export default EducacionComponent