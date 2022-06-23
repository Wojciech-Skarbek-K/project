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
  res.render('addEmployee', {
    departments: await employeeData.getDepartments()
  }
  ); 
});

router.post('/addEmployee/submit', async (req, res) => {
  res.render('addEmployee', {
    departments: await employeeData.getDepartments()
  }
  ); 
});


module.exports = router
