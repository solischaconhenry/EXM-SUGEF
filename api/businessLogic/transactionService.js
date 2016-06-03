/**
 * Created by usuario on 3/6/2016.
 */
var repository = require('../dataAccess/repository.js');


exports.getTransaction = function(callback) {
    var params = {
        query: {},
        collection: 'transactions'
    };
    repository.getCollection(params, function(data){
        callback(data);
    });
};

exports.getTransactionById = function(idTransaction, callback) {
    var params = {
        query: {_id: idTransaction},
        collection: 'transactions'
    };
    repository.getDocument(params, function(data){
        callback(data);
    });
};
exports.newTransaction = function(doc, callback) {
    var params = {
        query: doc,
        collection: 'transactions'
    };
    repository.addDocument(params, function(res) {
        callback(res);
    });
}

exports.editTransaction = function(idTransaction, doc, callback) {
    var params = {
        query: {_id: idTransaction},
        updateQuery: {$set: doc},
        collection: 'transactions'
    };
    console.log(doc);
    repository.updateDocument(params, function(res) {
        callback(res);
    });
}

exports.deleteTransaction = function(idTransaction, callback) {
    var params = {
        query: {_id: idTransaction},
        collection: 'transactions'
    };
    repository.deleteDocument(params, function(res) {
        callback(res);
    });
}

exports.disableTransaction = function(data, callback) {
    var params = {
        query: {_id: data.idTransaction},
        updateQuery: {$set: {estado: data.estado}},
        collection: 'usuarios'
    };

    repository.updateDocument(params, function(res) {
        callback(res);
    });
};

