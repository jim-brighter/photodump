var consoleApp = angular.module("console", []);

consoleApp.controller("consoleCtrl", function($scope, $http) {
	
	$scope.toDelete = [];
	$scope.changes = [];
	
	$http.get("/images").success(function(data) {
		$scope.data = data;
	}).error(function(err){
		console.log(err);
	});
	
	$scope.toggleItem = function(img) {
		if ($scope.toDelete.indexOf(img) > -1) {
			$scope.toDelete.splice($scope.toDelete.indexOf(img), 1);
		} else {
			$scope.toDelete.push(img);
		}
	};
	
	$scope.deleteImages = function(toDelete) {
		$http.post("/admin/delete", toDelete).success(function(data) {
			$http.get("/images").success(function(data) {
				$scope.data = data;
			}).error(function(err) {
				console.log(err);
			});
			$scope.toDelete = [];
		}).error(function(err) {
			console.log(err);
		});
	};
	
});