var wafepaApp = angular.module("wafepaApp",["ngRoute"]);

wafepaApp.controller("HomeCtrl", function($scope){
	$scope.message="Hello JWD40";
});

wafepaApp.controller("ActivitiesCtrl", function($scope, $http, $location){
	
	var url = "/api/activities";
	
	$scope.activities = [];
	
	var getActivities = function(){
		var promise = $http.get(url);
		promise.then(
			function success(res){
				$scope.activities = res.data;
//				console.log("test1");
//				console.log(res);
			},
			function error(res){
				alert("Couldn't fetch activities.");
			}
		);
//		console.log("test2");
	}
	
	getActivities();
	
	$scope.goToEdit = function(id){
		$location.path("/activities/edit/" + id);
	}
	
	$scope.goToAdd = function(){
		$location.path("/activities/add");
	}
	
	$scope.toDelete = function(id){
		
		var promise = $http.delete("/api/activities/" + id);
		promise.then(
				function uspeh(res){
					getActivities();
				},
				function neuspeh(res){
					alert("Couldn't fetch the activity.");
				}
		)
		
	}
	
});


wafepaApp.controller("EditActivityCtrl", function($scope,$http, $routeParams, $location){
	//console.log($routeParams);
	var url = "/api/activities/" + $routeParams.aid;
	
	$scope.activity = {};
	$scope.activity.name = "";
	
	var getActivity = function(){
		var promise = $http.get(url);
		promise.then(
			function uspeh(odg){
				$scope.activity = odg.data;
				console.log($scope.activity);
				console.log(odg);
			},
			function neuspeh(odg){
				alert("Couldn't fetch the activity.");
			}
		);
	}
	
	getActivity();
	
	
	$scope.doEdit = function(){
		var promise = $http.put(url, $scope.activity);
		console.log( $scope.activity); 
		promise.then(
			function success(res){
				$location.path("/activities");
			},
			function error(){
				alert("Couldn't save the activity");
			}
		);
	}
	
});


wafepaApp.controller("AddActivityCtrl", function($scope, $http, $location){
	
	$scope.activity = {};
	$scope.activity.name = "";
	$scope.disableBtn = true;
	
	
	
	var url = "/api/activities";
	
	console.log(!$scope.activity.name);
	console.log($scope.disableBtn);


	$scope.doAdd = function(){
		$http.post(url, $scope.activity).then(
			function success(){
				$location.path("/activities");
			},
			function error(){
				alert("Couldn't save the activity.");
			}
		);
	}
	
});

wafepaApp.controller("UsersCtrl", function($scope, $http, $location){
	
	var url = "/api/users";
	
	$scope.users = [];
	
	var getUsers = function(){
		var promise = $http.get(url);
		promise.then(
			function success(res){
				$scope.users = res.data;
//				console.log("test1");
//				console.log(res);
			},
			function error(res){
				alert("Couldn't fetch activities.");
			}
		);
//		console.log("test2");
	}
	
	getUsers();
	
	$scope.goToEdit = function(id){
		$location.path("/activities/edit/" + id);
	}
	
	$scope.goToAdd = function(){
		$location.path("/activities/add");
	}
	
	$scope.toDelete = function(id){
		
		var promise = $http.delete("/api/activities/" + id);
		promise.then(
				function uspeh(res){
					getActivities();
				},
				function neuspeh(res){
					alert("Couldn't fetch the activity.");
				}
		)
		
	}
	
});



wafepaApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/home.html',
			controller: "HomeCtrl"
		})
		.when('/activities', {
			templateUrl : '/app/html/activities.html'
		})
		.when('/activities/add', {
			templateUrl : '/app/html/add-activity.html'
		})
		.when('/activities/edit/:aid', {
			templateUrl : '/app/html/edit-activity.html'
		})
		.when('/users', {
			templateUrl : '/app/html/users.html',
			controller: "UsersCtrl"
		})
		.otherwise({
			redirectTo: '/'
		});
}]);