import { Route, Routes } from 'react-router-dom';
import { Login } from '../page/login/login';
import { Navbar } from '../../Navbar'
import { GestionarReserva } from '../page/Admin/GestionarReserva';
import { Index } from '../page/user/Index';
import { Registro } from '../page/register/registro';
import { PageNotFound } from '../componentes/PageNotFound';
import { Reserva } from '../page/user/Reserva';
import { GestionarServicios } from '../page/Admin/GestionarServicios';

export const AppRouter = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<Navbar />}>
          <Route index element={<Login />} />
          <Route path="/Login" element={<Login />} />
          <Route path="/Registro" element={<Registro />} />
          <Route path="*" element={<PageNotFound />} />
          <Route element={<Navbar />}>
            <Route path='/GestionarReserva' element={<GestionarReserva />} />
            <Route path='/Index' element={<Index />} />
            <Route path='/Reserva' element={<Reserva />} />
            <Route path='/GestionarServicios' element={<GestionarServicios />} />
          </Route>
        </Route>
      </Routes>
    </>
  );
};