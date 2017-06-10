var photosApp = angular.module("photosApp", []);

photosApp.constant("mainUrl", {
	"path": "http://67.205.153.26:8080"
	//"path": "http://localhost:8080"
});

photosApp.controller("mainCtrl", ["$scope", "$http", "mainUrl", function($scope, $http, mainUrl) {
	$scope.mainUrlPath = mainUrl.path;

	$scope.getImages = function() {
		$http.get(mainUrl.path + "/images").success(function(data) {
			$scope.images = data;
		});
	}

	$scope.sendImage = function(title, url, submitter) {
		var data = {
			title: title,
			url: url,
			submitter: submitter
		};
		$http.post(mainUrl.path + "/images", data).success(function(result) {
			$scope.title = "";
			$scope.url = "";
			$scope.submitter = "";
			$scope.getImages();
		}).error(function(err) {
			alert("submit failed!");
		});
	}
}]);

photosApp.directive("imgZoomer", [
	function() {
		return {
			restrict: "A",
			link: function(scope, element, attrs) {
				var big = false;
				element.on("click", function(e) {
					element.toggleClass("zoomed");
					if (!big) {
						element.animate({"width": "750px"});
						big = !big;
					} else {
						element.animate({"width": "200px"});
						big = !big;
					}
				});
			}
		};
	}
]);
