const express = require('express')
const router = express.Router()
const employeeData = require('./employeeData.js')

router.get('/employees', async (req, res) => {

  res.render('employeesView', {
    employees: await employeeData.getEmployees()
  }
  ); 

});


router.get('/addEmployee', async (req, res) => {
  res.render('addEmployee', { departments: await employeeData.getDepartments()}
  ); 
  
});

router.post('/addEmployee/submit', async (req, res) => {
  try{
    let insertedKey = await employeeData.addEmployee(req.body ); 
    res.redirect('addEmployee') 
  } catch(e){
    console.log(e);
    res.locals.errormessage = "Could not craete employee";
    res.render("addEmployee", req.body);
  }
  
});


module.exports = router
