const express = require("express");
const mongoose = require("mongoose")
const app = express()

const {eventRouter} = require('./api/routers/event.router')
const {hallRouter} = require('./api/routers/hall.router');
const {participentRouter} = require('./api/routers/particpent.router');


app.use(express.json());
app.set('content/type' , 'application/json')


// connection to datbase

mongoose.connect("mongodb://localhost:27017/EMS",{ useUnifiedTopology: true ,useNewUrlParser: true})
.then(()=>{
    console.log("DataBase Connected");

  // making server live
    app.listen(300 , ()=>{
        console.log("Server is live on localhost:300");
    })

  }).catch(err=>{
    console.log(err);
});


app.use('/event' , eventRouter)
app.use('/hall' , hallRouter)
app.use('/participent' , participentRouter)
