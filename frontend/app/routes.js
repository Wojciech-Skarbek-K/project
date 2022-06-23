const express = require('express')
const router = express.Router()
const employeeData = require('./employeeData.js')
const userData = require('./userData.js')

router.get('/employees', async (req, res) => {

  res.render('employeesView', {
    employees: await employeeData.getEmployees()
  }
  ); 

});


//add new User
router.get('/registration', async (req, res) => {
  res.render('newUserForm'); 

});

router.post('/registration', async (req, res) => {
  try {
    await userData.addUser(req.body);
    res.redirect('registration'); 
  } catch (e){
    console.log(e)
    res.locals.errormessage = "Could not add user"
    res.render('newUserForm', req.body )
  }

  });

  router.get('/login', async (req, res) => {
    res.render('loginForm'); 
  
  });

  router.post('/login', async (req, res) => {
    try {
      userInfo = await userData.checkUser(req.body);
      if (userInfo.flag == true) {
        if (userInfo.role == 'HR') {
          res.redirect('users');  
        } else if (userInfo.role == 'IDK'){
          res.redirect('employees'); 
        }
      } else {
        res.redirect('loginForm'); 
      }
    } catch (e){
      console.log(e)
      res.locals.errormessage = "Could not create employee"
      res.render('loginForm', req.body )
    }
  
    });

module.exports = router
