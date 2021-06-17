const Event = require('../models/event.model')



const getAllEvents = async (req,res)=>{

    const allEvents = await Event.find();

    if (!allEvents)
    {
     res.status(400).json({
         hasError : true
     })    
    }

    res.status(200).json({
        hasError : false,
        events : allEvents
    })

}

const getSpecificEvent = async (req,res)=>{

    const id = req.params.id

    const event = await Event.findOne({_id : id});

    if(!event)
    {
        res.status(405).json({
            hasError : true,
            message : "Event not found" 
        })
    }

    res.status(200).json({
        hasError :false,
        event
    })

}

const addAnEvent = async(req,res)=>{

    const event = req.body


    const result = await Event.create(event)

    if(!result){
        res.status(400)
    }
    

    res.status(200).json({
        hasError : false,
        message : "event has been updated"
    })
}

const updateAnEvent = async (req,res)=>{
    const event = req.body
    const id = req.params.id

    const result = await Event.updateOne({_id : id} , event , {new : true})

    if(!result)
    {
     return   res.status(400).json({
            hasError : true,
            message : "failed to update"
        })
    }


    res.status(200).json({
        hasError : false,
        message : "Event has been updated successfully"
    })
}

const deleteAnEvent = async(req,res)=>{
    const id = req.params.id

    const result = await Event.deleteOne({_id : id})

    if(!result){
      res.status(400).json({
        hasError : true,
        message : "failed tp delete the event"
      })
    }

    res.status(200).json({
        hasError : false ,
        mesage :"event deleted successsfully"
    })
}

module.exports = {
    getSpecificEvent,
    getAllEvents,
    deleteAnEvent,
    updateAnEvent,
    addAnEvent
}