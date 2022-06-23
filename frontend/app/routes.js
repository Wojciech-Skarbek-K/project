const express = require('express')
const router = express.Router()
const employeeData = require('./employeeData.js')

router.get('/employees', async (req, res) => {

  res.render('employeesView', {
    employees: await employeeData.getEmployees()
  }
  ); 

});

router.get('/highestSalesEmployee', async (req, res) => {

  res.render('highestSalesView', {
    employee: await employeeData.getHighestSalesEmployee()
  }
  ); 

});



module.exports = router
