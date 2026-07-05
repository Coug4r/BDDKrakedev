import { useState } from "react";
import "./../styles/form.css";

function CrearProyecto() {
  const [nombre, setNombre] = useState("");
  const [descripcion, setDescripcion] = useState("");
  const [fechaInicio, setFechaInicio] = useState("");

  const rol = localStorage.getItem("rol");

  // Bloquear vista si no es ADMIN
  if (rol !== "ADMIN") {
    return (
      <div className="form-container">
        <h2 style={{ color: "red" }}>Acceso denegado</h2>
        <p>Solo los usuarios con rol ADMIN pueden crear proyectos.</p>
      </div>
    );
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem("token");

    const res = await fetch("http://localhost:8080/api/proyectos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({ nombre, descripcion, fechaInicio }),
    });

    if (res.ok) {
      alert("Proyecto creado exitosamente");
      setNombre("");
      setDescripcion("");
      setFechaInicio("");
    } else if (res.status === 403) {
      alert("Acceso denegado: No tienes permisos para crear proyectos");
    } else {
      alert("Error al crear proyecto");
    }
  };

  return (
    <div className="form-container">
      <h2>Crear Proyecto</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Nombre"
          value={nombre}
          onChange={(e) => setNombre(e.target.value)}
        />
        <input
          type="text"
          placeholder="Descripción"
          value={descripcion}
          onChange={(e) => setDescripcion(e.target.value)}
        />
        <input
          type="date"
          value={fechaInicio}
          onChange={(e) => setFechaInicio(e.target.value)}
        />
        <button type="submit">Guardar</button>
      </form>
    </div>
  );
}

export default CrearProyecto;
