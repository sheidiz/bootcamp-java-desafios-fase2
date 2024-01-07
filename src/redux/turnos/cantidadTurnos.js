import { createSlice } from "@reduxjs/toolkit";

const CantidadTurnosInitialState = 0;

export const CantidadTurnosSlice = createSlice({
    name: 'cantidadTurnos',
    initialState: CantidadTurnosInitialState,
    reducers: {
        setCantidadTurnos: (state, action) => {
            return action.payload;
        },
        modifyCantidadTurnos: (state, action) => {
            return { ...state, ...action.payload };
        },
        resetCantidadTurnos: () => {
            return CantidadTurnosInitialState;
        }
    }
})

export const { setCantidadTurnos, modifyCantidadTurnos, resetCantidadTurnos } = CantidadTurnosSlice.actions;