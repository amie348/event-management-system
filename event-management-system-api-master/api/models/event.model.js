const mongoose = require('mongoose');

const eventSchema = mongoose.Schema({
    title :{
        type : String,
        required : true
    },
    organizer : {
        type : String,
        required : true
    },
    date : {
        type : String,
        required:true
    },
    hall : {
        type : String,
        required : true
    },
    budget : {
        type : String,
        required: true
    },
    audiance : {
        type : String,
        required : true
    },
    description : {
        type : String , 
        required : true
    }
})

module.exports = mongoose.model('event' , eventSchema)
