export default function Consigna() {
	const estiloCentrar = {
		alignItems: "center",
		display: "flex",
		flexDirection: "column",
		width: "100%",
	};

	return (
		<div>
			<h2 style={estiloCentrar}>Ejercicio 6 - Guia 19</h2>
			<h3>Consigna</h3>
			<p>
				Crear un proyecto compuesto de un solo componente y un servicio, quien
				deberá ser capaz de llamar desde el servicio, mediante la funcionalidad
				Fetch, a la API de Rick and Morty (
				https://rickandmortyapi.com/api/character ).
			</p>
			<p>
				Una vez llamado los datos desde el servicio, hacer uso de useEffect en
				el componente creado, deberá mostrar una lista compuesta de los nombres
				de los 20 primeros personajes.
			</p>
			<hr />
		</div>
	);
}
