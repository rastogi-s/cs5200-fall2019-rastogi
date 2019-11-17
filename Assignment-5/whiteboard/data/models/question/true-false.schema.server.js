const mongoose = require('mongoose');
const trueFalseSchema = mongoose.Schema({
    isTrue: Boolean
}, {_id: false});
module.exports = trueFalseSchema;
