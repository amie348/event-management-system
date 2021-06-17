
const {Router} = require('express');
const { getAllEvents, getSpecificEvent, addAnEvent, updateAnEvent, deleteAnEvent } = require('../controllers/event.cotroller');
const eventRouter = Router()






eventRouter.get('/' , getAllEvents);
eventRouter.get('/:id' , getSpecificEvent);
eventRouter.post('/add' ,addAnEvent )
eventRouter.patch('/update/:id' , updateAnEvent);
eventRouter.delete('/delete/:id' , deleteAnEvent)

module.exports = {
    eventRouter
}
