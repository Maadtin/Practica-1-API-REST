let app = angular.module('atletasAPP', []);

app.controller('atletasController', function ($scope, $http) {


	$http.get("http://localhost:8080/atletas")
		 .then(response => {console.log(response.data);
		 	$scope.atletas = response.data});

	$scope.addAtleta = function (form) {
		$scope.newAtleta = {
			nombre: $scope.nombre,
			apellido: $scope.apellido,
			nacionalidad: $scope.nacionalidad,
			fecha_nacimiento: $scope.nacimiento
		};

		$http.post("http://localhost:8080/atletas/add", $scope.newAtleta)
			 .then(data => {
				 $scope.atletas.push(data.data);
				 $scope.nombre = '';
				 $scope.apellido = '';
				 $scope.nacionalidad = '';
				 $scope.nacimiento = '';
				 form.addAtletaForm.$setPristine();
				 form.addAtletaForm.$setUntouched();
			 });

	};

	$scope.removeAtleta = function (atleta) {
		$http.delete(`http://localhost:8080/atletas/delete/${atleta.id}`)
			 .then(data => $scope.atletas.splice($scope.atletas.indexOf(atleta), 1))
	};

			$scope.fillAtletaForm = function (atleta) {

				$scope.showEditForm = !$scope.showEditForm;

				$scope.newNombre = atleta.nombre;
				$scope.newApellido = atleta.apellido;
				$scope.newNacionalidad = atleta.nacionalidad;
				$scope.newNacimiento = atleta.nacimiento;

				$scope.updateAtleta = function () {
					let updatedAtleta = {
						id: atleta.id,
						nombre: $scope.newNombre,
						apellido: $scope.newApellido,
						nacionalidad: $scope.newNacionalidad,
						fecha_nacimiento: $scope.newNacimiento
					};
					$http.put(`http://localhost:8080/atletas/update`, updatedAtleta)
						 .then(() => {
							 $scope.atletas[$scope.atletas.indexOf(atleta)] = updatedAtleta;
							 $scope.showEditForm = false;
						 });

				};




			}


});