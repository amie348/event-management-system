const {Router} = require('express');
const { getAllhalls, getSpecifichall, addAhall, updateAhall, deleteAhall } = require('../controllers/hall.controller');
const hallRouter = Router()




hallRouter.get('/' , getAllhalls);
hallRouter.get('/:id' , getSpecifichall);
hallRouter.post('/add' , addAhall);
hallRouter.patch('/update/:id' , updateAhall);
hallRouter.delete('/delete/"id' , deleteAhall)


module.exports = {
    hallRouter
}