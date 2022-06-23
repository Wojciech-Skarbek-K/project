const express = require('express')
const router = express.Router()
const employeeData = require('./employeeData.js')

router.get('/employees', async (req, res) => {

  res.render('employeesView', {
    employees: await employeeData.getEmployees()
  }
  ); 

});



router.get('/salary-report', async (req, res) => {
  let empData = await employeeData.getEmployees();
  let salesData = await employeeData.getSales();
  for(let emp of empData){
    if(emp.dep_id === 2){
      for(let sal of salesData){
        if(emp.emp_id === sal.emp_id){
          let totalSalary = emp.salary + (sal.com_rate * sal.sal_rate);
          emp.salary = totalSalary;
        }
        
      }
    } 
  }
  res.render('salaryReport', {
    employees: empData
  }
  ); 

});
module.exports = router
