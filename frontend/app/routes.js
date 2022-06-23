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
    res.redirect('/employees') 
  } catch(e){
    console.log(e);
    res.locals.errormessage = "Could not craete employee";
    res.render("addEmployee", req.body);
  }
  
});

router.get('/highestSalesEmployee', async (req, res) => {



router.get('/salary-report', async (req, res) => {
  let empData = await employeeData.getEmployees();
  let salesData = await employeeData.getSales();
  for(let emp of empData){
    if(emp.dep_id === 2){
      for(let sal of salesData){
        if(emp.emp_id === sal.emp_id){
          let totalSalary = emp.salary + (sal.com_rate * sal.sal_rate);
          emp.salary = totalSalary.toFixed(0);
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
