import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Navbar from './navbar/Navbar'
import { routes } from './navbar/routes'
import Turnero from './turnos/ui/Turnero'
import ListadoTurnos from './turnos/ui/ListadoTurnos'

export default function AppRouter() {
    return (
        <>
            <BrowserRouter>
                <Navbar />
                <Routes>
                    <Route path={routes.publicas.TURNERO} element={<Turnero />} />
                    <Route path={routes.publicas.TURNOS} element={<ListadoTurnos />} />
                </Routes>
            </BrowserRouter>
        </>
    )
}
