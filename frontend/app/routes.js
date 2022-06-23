const express = require('express')
const router = express.Router()
const testData = require('./testData.js')
const employeeData = require('./employeeData.js')

router.get('/employees', async (req, res) => {

  res.render('employeesView', {
    employees: await employeeData.getEmployees()
  }
  ); 

});

module.exports = router
