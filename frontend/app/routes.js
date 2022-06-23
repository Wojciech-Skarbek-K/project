const express = require('express')
const router = express.Router()
const testData = require('./testData.js')
const employeeData = require('./employeeData.js')

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

module.exports = router
