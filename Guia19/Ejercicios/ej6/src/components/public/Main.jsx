import React, { createElement, useEffect, useState } from "react";
import RAMservices from "../services/RAMservices";

export default function Main() {
  const [personajes, setPersonajes] = useState([]);

  const containerColumnas = {
    display: "flex",
    justifyContents: "space-between",
  };
  const estiloColumna = {
    flex: 1,
    padding: "10px",
    alignItems: "center",
  };

  const estiloCentrar = {
    alignItems: "center",
    display: "flex",
    flexDirection: "column",
    width: "100%",
  };

  useEffect(() => {
    RAMservices.obtenerPesonajes()
      .then((datos) => setPersonajes(datos.results))
      .catch((error) => console.log("error: " + error));
  }, [personajes]);

  const nombres1 = personajes.map((p) => {
    if (p.id % 2 != 0)
      return createElement(
        "h2",
        { key: `${p.id}` },
        `ID: ${p.id} || Nombre: ${p.name}.`
      );
  });

  const nombres2 = personajes.map((p) => {
    if (p.id % 2 === 0)
      return createElement(
        "h2",
        { key: `${p.id}` },
        `ID: ${p.id} || Nombre: ${p.name}.`
      );
  });

  return (
    <div>
      <h2 style={estiloCentrar}> Resolucion de ejercicio </h2>
      <div style={containerColumnas}>
        <div style={estiloColumna}>{nombres1}</div>
        <div style={estiloColumna}>{nombres2}</div>
      </div>
    </div>
  );
}
