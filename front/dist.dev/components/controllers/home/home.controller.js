angular.module('app').controller('HomeController', ['$scope', 'AlertasService', function($scope, AlertasService) {

    $scope.alertas = [];
    $scope.pontosDeVenda = [];
    $scope.pontoSelecionado = "todos";
    $scope.flTipo = "todos";

    $scope.filterBy = (flTipo) => {
        $scope.flTipo = flTipo;
    };

    $scope.getAlertas = (flTipo = 'todos', pontoSelecionado = 'todos') => $scope.alertas.filter(alerta => {
        return (alerta.flTipo == flTipo || flTipo === 'todos') 
            && (alerta.pontoDeVenda == pontoSelecionado || pontoSelecionado == 'todos');
    });

    $scope.getPontosDeVenda = (alertas = []) => {
        const alertasMap = alertas.map(alerta => alerta.pontoDeVenda);
        const pontosDeVenda = [];

        alertasMap.forEach(pontoDeVenda => {
            if (!pontosDeVenda.includes(pontoDeVenda))
                pontosDeVenda.push(pontoDeVenda);
        });

        return pontosDeVenda;
    };

    const init = () => {
        AlertasService.getAlertas().then(result => {
            $scope.alertas = result.data;
            $scope.pontosDeVenda = $scope.getPontosDeVenda($scope.alertas);
        });
    };
    
    init();

}]);