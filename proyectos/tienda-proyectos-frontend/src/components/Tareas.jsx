import { useState } from "react";
import "./../styles/form.css";

function Tareas() {
  const [descripcion, setDescripcion] = useState("");
  const [fechaLimite, setFechaLimite] = useState("");
  const [costoEstimado, setCostoEstimado] = useState("");
  const [prioridad, setPrioridad] = useState("ALTA");
  const [proyectoId, setProyectoId] = useState("");
  const [empleadoId, setEmpleadoId] = useState("");

  const rol = localStorage.getItem("rol");

  // Bloquear vista si no es ADMIN
  if (rol !== "ADMIN") {
    return (
      <div className="form-container">
        <h2 style={{ color: "red" }}>Acceso denegado</h2>
        <p>Solo los usuarios con rol ADMIN pueden crear tareas.</p>
      </div>
    );
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem("token");

    const res = await fetch("http://localhost:8080/api/tareas", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({
        descripcion,
        fechaLimite,
        costoEstimado,
        prioridad,
        proyecto: { id: proyectoId },
        empleados: [{ id: empleadoId }],
      }),
    });

    if (res.ok) {
      alert("Tarea creada exitosamente");
      setDescripcion("");
      setFechaLimite("");
      setCostoEstimado("");
      setPrioridad("ALTA");
      setProyectoId("");
      setEmpleadoId("");
    } else if (res.status === 400) {
      const error = await res.json();
      alert("Error de validación: " + error.error);
    } else if (res.status === 403) {
      alert("Acceso denegado: No tienes permisos para crear tareas");
    } else {
      alert("Error al crear tarea");
    }
  };

  return (
    <div className="form-container">
      <h2>Crear Tarea</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Descripción"
          value={descripcion}
          onChange={(e) => setDescripcion(e.target.value)}
        />
        <input
          type="date"
          value={fechaLimite}
          onChange={(e) => setFechaLimite(e.target.value)}
        />
        <input
          type="number"
          placeholder="Costo Estimado"
          value={costoEstimado}
          onChange={(e) => setCostoEstimado(e.target.value)}
        />
        <select value={prioridad} onChange={(e) => setPrioridad(e.target.value)}>
          <option value="ALTA">ALTA</option>
          <option value="MEDIA">MEDIA</option>
          <option value="BAJA">BAJA</option>
        </select>
        <input
          type="number"
          placeholder="ID Proyecto"
          value={proyectoId}
          onChange={(e) => setProyectoId(e.target.value)}
        />
        <input
          type="number"
          placeholder="ID Empleado"
          value={empleadoId}
          onChange={(e) => setEmpleadoId(e.target.value)}
        />
        <button type="submit">Guardar Tarea</button>
      </form>
    </div>
  );
}

export default Tareas;
