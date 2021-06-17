const Hall = require('../models/hall.model')

const getAllhalls = async (req,res)=>{

    const allHalls = await Hall.find();

    if (!allHalls)
    {
     res.status(400).json({
         hasError : true
     })    
    }

    res.status(200).json({
        hasError : false,
        halls : allHalls
    })

}

const getSpecifichall = async (req,res)=>{

    const id = req.params.id

    const hall = await Hall.findOne({_id : id});

    if(!hall)
    {
        res.status(405).json({
            hasError : true,
            message : "Hall not found" 
        })
    }

    res.status(200).json({
        hasError :false,
        hall
    })

}

const addAhall = async(req,res)=>{

    const hall = req.body


    const result = await Hall.create(hall)

    if(!result){
        res.status(400)
    }
    

    res.status(200).json({
        hasError : false,
        message : "hall has been updated"
    })
}

const updateAhall = async (req,res)=>{
    const hall = req.body
    const id = req.params.id

    const result = await Hall.updateOne({_id : id} , hall , {new : true})

    if(!result)
    {
     return   res.status(400).json({
            hasError : true,
            message : "failed to update"
        })
    }


    res.status(200).json({
        hasError : false,
        message : "Hall has been updated successfully"
    })
}

const deleteAhall = async(req,res)=>{
    const id = req.params.id

    const result = await Hall.deleteOne({_id , id})

    if(!result){
      res.status(400).json({
        hasError : true,
        message : "failed tp delete the hall"
      })
    }

    res.status(200).json({
        hasError : false ,
        mesage :"hall deleted successsfully"
    })
}

module.exports = {
    getSpecifichall,
    getAllhalls,
    deleteAhall,
    updateAhall,
    addAhall
}