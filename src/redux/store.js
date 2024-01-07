import { configureStore } from "@reduxjs/toolkit";
import { TurnosSlice } from "./turnos/turnos";
import { CantidadTurnosSlice } from "./turnos/cantidadTurnos";

export const Banco = configureStore({
    reducer : {
        turnos: TurnosSlice.reducer,
        cantidadTurnos: CantidadTurnosSlice.reducer
    }
});