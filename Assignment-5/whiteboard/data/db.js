const mongoose = require('mongoose');
const databaseName = 'white-board';
//let connectionString = 'mongodb://127.0.0.1:27017/' + databaseName;

let connectionString = 'mongodb://heroku_5qkbhc6n:ck0074e84dle74taj9m1iseqeg@ds061651.mlab.com:61651/heroku_5qkbhc6n'; //+ databaseName;


function connectToDatabase(callback) {
    mongoose.connect(connectionString, {useNewUrlParser: true, useUnifiedTopology: true}).then(() => {
        console.log("connected to database established successfully");
    }).then(() => {callback()}).catch(err => {
        console.error('Error occurred while starting database:', err.stack);
        process.exit(1);
    });
}

function dropConnection(callback) {
    mongoose.connection.close().then(() =>{
        console.log('connection  to database closed successfully')
    }).then(() => callback()).catch(err => {
        console.error('Error occurred while closing database:', err.stack);
        process.exit(1);
    });
}

module.exports = {connectToDatabase, dropConnection};



