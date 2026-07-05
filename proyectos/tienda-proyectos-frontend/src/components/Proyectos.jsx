import { useEffect, useState } from "react";
import "./../styles/table.css";

function Proyectos() {
  const [proyectos, setProyectos] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (!token) {
      window.location.href = "/";
      return;
    }

    const fetchData = async () => {
      const res = await fetch("http://localhost:8080/api/proyectos", {
        headers: { Authorization: `Bearer ${token}` },
      });
      if (res.ok) {
        const data = await res.json();
        setProyectos(data);
      } else if (res.status === 401) {
        alert("Sesión expirada. Vuelve a iniciar sesión.");
        localStorage.clear();
        window.location.href = "/";
      } else if (res.status === 403) {
        alert("Acceso denegado: No tienes permisos para ver proyectos.");
      } else {
        alert("Error al cargar proyectos");
      }
    };
    fetchData();
  }, []);

  return (
    <div className="table-container">
      <h2>Lista de Proyectos</h2>
      <div className="table-responsive">
        <table>
          <thead>
            <tr>
              <th>ID</th><th>Nombre</th><th>Descripción</th><th>Fecha Inicio</th>
            </tr>
          </thead>
          <tbody>
            {proyectos.map((p) => (
              <tr key={p.id}>
                <td>{p.id}</td>
                <td>{p.nombre}</td>
                <td>{p.descripcion}</td>
                <td>{p.fechaInicio}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default Proyectos;
