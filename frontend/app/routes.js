const express = require('express')
const router = express.Router()
const testData = require('./testData.js')
const employeeData = require('./employeeData.js')
const userData = require('./userData.js')

// Add your routes here - above the module.exports line
// router.get('/employees', async (req, res) => {

//   res.render('employeesView', {
//     employees: await employeeData.getEmployees()
//   }
//   ); 

// });

router.get('/employees', function(req, res){ 
  res.render('employeesView', { employees: testData.getEmployees() } ); 
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

module.exports = router
