var AuStanApp = angular.module("AuStanApp",["ngRoute"]);

AuStanApp.controller("HomeCtrl", function($scope){
	$scope.message="Hello JWD40";
});


AuStanApp.controller("LinijeCtrl", function($scope, $http, $routeParams, $location){
	
	var url = "/api/linije";
	
	var url = "/api/linije";
	
	$scope.linije = [];
	$scope.linija = {};
	
	var getLinije = function(){
		var promise = $http.get(url);
		promise.then(
			function success(res){
				$scope.linije = res.data;
				
			},
			function error(res){
				alert("Couldn't fetch activities.");
			}
		);
		
	}
	
	getLinije();
	
	
	
	var doEditLin = function(url, linija){
		var promise = $http.put(url, linija);
		promise.then(
			function success(res){
				getLinije();
				console.log(res.data);
				//$location.path("/linije");
			},
			function error(){
				alert("Couldn't save the activity");
			}
		);
	}
	
	
	$scope.getLinija = function(id){
		
		var url = "/api/linije/" + id;
		var promise = $http.get(url);
		promise.then(
			function uspeh(odg){
				$scope.linija = odg.data;
				console.log($scope.linija);
				alert(odg.data.brojMesta);
			},
			function neuspeh(odg){
				alert("Couldn't fetch the activity blablabla.");
			}
		);
	}
	
	
	

	$scope.doRez = function(id){
		
		var url = "/api/linije/" + id;
		var promise = $http.get(url);
		promise.then(
			function uspeh(odg){
				$scope.linija = odg.data;
				doEditLin(url, $scope.linija);
				//getLinije();
				$location.path("/linije");
			},
			function neuspeh(odg){
				alert("Couldn't fetch the activity.");
			}
		);
}
	
	
	
	
	

	
	
	
	
	
	
//	$scope.doRezervacija = function(id){
//		
//		var url = "/api/linije/" + id;
//		
//		getLinija(id);
//		
//		var promise = $http.get(url);
//		promise.then(
//			function success(res){
//				$location.path("/activities");
//			},
//			function error(){
//				alert("Couldn't save the activity");
//			}
//		);
//	}
		
		
	
	
//	$scope.goToEdit = function(id){
//		$location.path("/activities/edit/" + id);
//	}
//	
//	$scope.goToAdd = function(){
//		$location.path("/activities/add");
//	}
//	
//	$scope.doDelete = function(id){
//		var promise = $http.delete(url + "/" + id);
//		promise.then(
//			function success(){
//				getActivities();
//			},
//			function error(){
//				alert("Couldn't delete the activity.");
//			}
//		);
//	}
	
});




AuStanApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/home.html',
			controller: "HomeCtrl"
		})
		.when('/linije', {
			templateUrl : '/app/html/linije.html'
		});
}]);