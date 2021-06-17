const {Router} = require('express');
const { getAllparticipents, getSpecificparticipent, addParticipent, updateParticipent, deleteParticipent } = require('../controllers/participent.controller');
const participentRouter = Router()




participentRouter.get('/' , getAllparticipents);
participentRouter.get('/:id' , getSpecificparticipent);
participentRouter.post('/add' , addParticipent);
participentRouter.patch('/update/:id' , updateParticipent);
participentRouter.delete('/delete/:id' , deleteParticipent)


module.exports = {
    participentRouter
}