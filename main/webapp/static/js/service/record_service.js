'use strict';

angular.module('myApp').factory('RecordService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/RandomSequenceSorter/records/';

    var factory = {
        fetchAllRecords: fetchAllRecords,
        createRecord: createRecord
     //   updateRecord:updateRecord
    };

    return factory;

    function fetchAllRecords() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Records');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createRecord(records) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, records)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Record');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateRecord(record, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, record)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Record');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    

}]);
