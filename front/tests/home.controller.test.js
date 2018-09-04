describe("Teste do HomeController", function () {
    var $controller;

    var alertasMock = [
        {pontoDeVenda: 'Namekusei', flTipo: 1},
        {pontoDeVenda: 'Westeros', flTipo: 2},
        {pontoDeVenda: 'Vila da chuva', flTipo: 1},
        {pontoDeVenda: 'Konoha', flTipo: 4},
        {pontoDeVenda: 'Digimundo', flTipo: 5},
    ];

    beforeEach(module("app"));

    beforeEach(function () {
        inject(function (_$controller_) {
            $controller = _$controller_;
        });
    });

    it("Deve gerar uma lista com ponto de vendas de alertas'", function () {
        var $scope = {};
        var controller = $controller("HomeController", { $scope: $scope });

        var mapAlertas = $scope.getPontosDeVenda(alertasMock);

        expect(mapAlertas[0]).toEqual('Namekusei');
        expect(mapAlertas[1]).toEqual('Westeros');
    });

    it("Deve retornar a lista filtrada por alertas de rupturas'", function () {
        var $scope = {};
        var controller = $controller("HomeController", { $scope: $scope });

        $scope.alertas = alertasMock;
        var flTipo = 1;

        var alertas = $scope.getAlertas(flTipo);

        expect(alertas.length).toBe(2);
        expect(alertas[0]).toEqual({pontoDeVenda: 'Namekusei', flTipo: 1});
        expect(alertas[1]).toEqual({pontoDeVenda: 'Vila da chuva', flTipo: 1});
    });

    it("Deve retornar a lista filtrada por alertas de rupturas e pontos de venda'", function () {
        var $scope = {};
        var controller = $controller("HomeController", { $scope: $scope });

        $scope.alertas = alertasMock;
        var flTipo = 1;

        var alertas = $scope.getAlertas(flTipo, 'Namekusei');

        expect(alertas.length).toBe(1);
        expect(alertas[0]).toEqual({pontoDeVenda: 'Namekusei', flTipo: 1});
    });

    it("Deve retornar a lista com todos'", function () {
        var $scope = {};
        var controller = $controller("HomeController", { $scope: $scope });

        $scope.alertas = alertasMock;

        var alertas = $scope.getAlertas();

        expect(alertas.length).toBe(alertasMock.length);
    });

});