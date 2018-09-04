angular.module('app').service('AlertasService', ['$http', function($http) {

    this.getAlertas = function() {
        return $http.get('http://localhost:8080/alertas');
    };

}]);