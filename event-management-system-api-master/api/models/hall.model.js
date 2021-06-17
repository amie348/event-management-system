const mongoose = require('mongoose');

const hallSchema = mongoose.Schema({
    name :{
        type : String,
        required : true
    },
    location : {
        type : String,
        required : true
    },
    floors : {
        type : String,
        required:true
    },
    rent : {
        type : String,
        required : true
    },
    Capacity : {
        type : String,
        required : true
    },
    
})

module.exports = mongoose.model('hall' , hallSchema)
