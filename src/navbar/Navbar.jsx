import React from 'react'
import { NavLink } from 'react-router-dom'
import { routes } from './routes'

function Navbar() {
    return (
        <nav className="navbar navbar-expand-sm bg-dark" data-bs-theme="dark">
            <div className="container-fluid">
                <a className="navbar-brand" href="/">Banco</a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon text-light"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <NavLink className="nav-link"
                                aria-current="page"
                                to={routes.publicas.TURNERO}>
                                Turnero
                            </NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className="nav-link"
                                to={routes.publicas.TURNOS}>
                                Listado de Turnos
                            </NavLink>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default Navbar