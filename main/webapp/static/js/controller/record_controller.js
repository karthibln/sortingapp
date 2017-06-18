'use strict';

angular.module('myApp').controller('RecordController', ['$scope', 'RecordService', function($scope, RecordService) {
	
    $scope.numericalArr=[];
    $scope.sortArr=[];
    var storedArr=[];
    self.submit = submit;
    var d = new Date();
   


    fetchAllRecords();


    $scope.generateRandomNumber = function() {   
    	var randomArr=[];
    for (var i = 0; i <=5; i++) { 
       	var temp=Math.floor((Math.random() * 100) + 1);
    	randomArr.push(temp);
    }
   Array.prototype.push.apply(storedArr, randomArr);
        $scope.numericalArr=storedArr;
    };
    
    
    $scope.sort=function(){
    	 var start = d.getMilliseconds();
        $scope.sortRequested=true;
        $scope.numericalArr.sort(function(a, b){return a-b});
        $scope.count=$scope.numericalArr.length;
    $scope.sortArr=$scope.numericalArr;
    createRecord($scope.sortArr);
    
    var end = d.getMilliseconds();
    $scope.timeinMillis=end-start;
    }


    function fetchAllRecords(){
    	RecordService.fetchAllRecords()
            .then(
            function(d) {
            	 storedArr = d;
            },
            function(errResponse){
                console.error('Error while fetching Records');
            }
        );
    }

    function createRecord(records){
    	RecordService.createRecord(records)
            .then(
            fetchAllRecords,
            function(errResponse){
                console.error('Error while creating Record');
            }
        );
    }

    
  /*  function updateRecord(records, id){
        RecordService.updateRecord(records, id)
            .then(
            fetchAllRecords,
            function(errResponse){
                console.error('Error while updating Record');
            }
        );
    }*/

    function submit() {
            console.log('Saving New Record', $scope.sortArr);
            createRecord($scope.sortArr);
    }

   

}]);
