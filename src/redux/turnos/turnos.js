import { createSlice } from "@reduxjs/toolkit";
import {produce} from 'immer';

const TurnosInitialState = {};

export const TurnosSlice = createSlice({
    name: 'turnos',
    initialState: TurnosInitialState,
    reducers: {
        createTurno: (state, action) => {
            return action.payload;
        },
        modifyTurno: (state, action) => {
            return { ...state, ...action.payload };
        },
        deleteTurno: (state, action) => {
            const idABorrar = action.payload;
            return produce(state, draft => {
                delete draft[idABorrar];
            });
        },
        resetTurnos: () => {
            return TurnosInitialState;
        }
    }
})

export const { createTurno, modifyTurno, deleteTurno, resetTurnos } = TurnosSlice.actions;