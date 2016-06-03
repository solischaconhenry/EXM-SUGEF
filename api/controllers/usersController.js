var usersService = require('../businessLogic/usersService.js'); 

exports.getUsers = function(eRequest, eResponse) {
    usersService.getUsers(function(data){
        eResponse.send(data);
    });
};

exports.getUserById = function(eRequest, eResponse) {
    usersService.getUserById(eRequest.params.id, function(data){
        eResponse.send(data);
    });
};

exports.newUser = function(eRequest, eResponse) {
    usersService.newUser(eRequest.body, function(data){
        eResponse.send(data);
    });
};

