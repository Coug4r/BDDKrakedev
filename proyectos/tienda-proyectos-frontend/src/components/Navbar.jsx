import { Link } from "react-router-dom";
import "./../styles/navbar.css";

function Navbar() {
  const rol = localStorage.getItem("rol");

  const logout = async () => {
    const token = localStorage.getItem("token");
    await fetch("http://localhost:8080/api/auth/logout", {
      method: "POST",
      headers: { Authorization: `Bearer ${token}` },
    });
    localStorage.clear();
    window.location.href = "/";
  };

  return (
    <nav className="navbar">
      <h3>Tienda Proyectos</h3>
      <ul>
        {rol === "USER" && (
          <li><Link to="/proyectos">Ver Proyectos</Link></li>
        )}
        {rol === "ADMIN" && (
          <>
            <li><Link to="/proyectos">Gestionar Proyectos</Link></li>
            <li><Link to="/crear-proyecto">Crear Proyecto</Link></li>
            <li><Link to="/tareas">Crear Tareas</Link></li>
          </>
        )}
        {rol && (
          <li><button className="logout-btn" onClick={logout}>Logout</button></li>
        )}
      </ul>
    </nav>
  );
}

export default Navbar;
