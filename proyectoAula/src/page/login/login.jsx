import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './login.css';
import axios from 'axios';
import { BackGraund } from '../../componentes/BackGraund'
import { useNavigate } from 'react-router-dom';

export const Login = () => {
    const navigate = useNavigate();
    const [email, setEmail] = useState('');
    const [clave, setClave] = useState('');
    const [rememberMe, setRememberMe] = useState(false);

    useEffect(() => {
        const verUsuario = async () => {
            const response = await axios.get('http://localhost:8080/api/usuario/get');
            console.log(response.data)
        }

        verUsuario();
        const storedUsername = localStorage.getItem('username');
        const storedPassword = localStorage.getItem('password');

        if (storedUsername && storedPassword) {
            setEmail(storedUsername);
            setClave(storedPassword);
            setRememberMe(true);
        }
    }, []);

    const onLogin = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/api/usuario/login', {
                email,
                clave,
            });
            console.log(response)
            if (response.status === 200) {
                const responseData = response.data;
                const roleId = responseData.rol.id;

            if(responseData.email===email){
                if (roleId === 1) {
                    localStorage.setItem('username', email);
                    localStorage.setItem('password', clave);
                    navigate('/Index', {
                        replace: true,
                        state: {
                            logged: true,
                            email,
                        }
                    });
                } else if (roleId === 2) {
                    localStorage.setItem('username', email);
                    localStorage.setItem('password', clave);
                    navigate('/GestionarReserva', {
                        replace: true,
                        state: {
                            logged: true,
                            email,
                        }
                    });
                } }

            } else {
                alert('Credenciales incorrectas');
            }
        } catch (error) {
            console.error('Error al obtener los datos de la base de datos:', error);
            alert('Usuario y/o Contraseña Incorrectos');
        }

        if (rememberMe) {
            localStorage.setItem('username', email);
            localStorage.setItem('password', clave);
        }
    };

    return (


        <div className="Trab">

            <div className="col">

                <h2 className="fw-bold text-center py-5">¡¡Bienvenido!!</h2>

                <form onSubmit={onLogin}>
                    <div className="mb-4">
                        <label htmlFor="email" className="form-label">Correo electrónico</label>
                        <input
                            type="email"
                            className="form-control"
                            name="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                    </div>
                    <div className="mb-4">
                        <label htmlFor="password" className="form-label">Password</label>
                        <input
                            type="password"
                            className="form-control"
                            name="password"
                            value={clave}
                            onChange={(e) => setClave(e.target.value)}
                        />
                    </div>
                    <div className="mb-4 form-check">
                        <input
                            type="checkbox"
                            name="connected"
                            className="form-check-input"
                            checked={rememberMe}
                            onChange={(e) => setRememberMe(e.target.checked)}
                        />
                        <label htmlFor="connected" className="form-check-label">Mantenerme conectado</label>
                    </div>

                    <div className="d-grid">
                        <button type="submit" className="btn btn-primary">Iniciar Sesión</button>
                    </div>
                    <div className="my-3">
                        <span>No tienes cuenta? <a href="/Registro">Regístrate</a></span> <br />
                        <span><a href="#">Recuperar Password</a></span>
                    </div>
                </form>

                <div className="container w-100 my-5">
                    <div className="row text-center">
                        <div className="col-12">Iniciar Sesión con:</div>
                    </div>
                    <div className="row">
                        <div className="col">
                            <button className="btn btn-outline-primary w-100 my-1">
                                <div className="row align-items-center">
                                    <div className="col-2 d-none d-md-block">
                                        <img src="images/pngwing.com.png" width="32" alt="" />
                                    </div>
                                    <div className="col-12 col-md-10 text-center">Facebook</div>
                                </div>
                            </button>
                        </div>
                        <div className="col">
                            <button className="btn btn-outline-danger w-100 my-1">
                                <div className="row align-items-center">
                                    <div className="col-2 d-none d-md-block">
                                        <img src='images/google (2).png' width="32" alt="" />
                                    </div>
                                    <div className="col-12 col-md-10 text-center">Google</div>
                                </div>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    );
};