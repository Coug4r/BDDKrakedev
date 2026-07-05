import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Login from "./components/Login";
import Proyectos from "./components/Proyectos";
import CrearProyecto from "./components/CrearProyecto";
import Tareas from "./components/Tareas";

// Componente para proteger rutas privadas
const PrivateRoute = ({ element }) => {
  const token = localStorage.getItem("token");
  return token ? element : <Login />;
};

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/proyectos" element={<PrivateRoute element={<Proyectos />} />} />
        <Route path="/crear-proyecto" element={<PrivateRoute element={<CrearProyecto />} />} />
        <Route path="/tareas" element={<PrivateRoute element={<Tareas />} />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
