const mongoose = require('mongoose');

const participentSchema = mongoose.Schema({
    firstName :{
        type : String,
        required : true
    },
    lastName : {
        type : String,
        required : true
    },
    age : {
        type : String,
        required:true
    },
    event : {
        type : String,
        required : true
    },
    cnic : {
        type : String,
        required : true
    },
    
})

module.exports = mongoose.model('participent' , participentSchema)
