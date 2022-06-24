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
      res.locals.errormessage = "Could not create employee"
      res.render('loginForm', req.body )
    }
  
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
    res.locals.errormessage = "Could not craete employee";
    res.render("addEmployee", req.body);
  }
  
});

router.get('/highestSalesEmployee', async (req, res) => {

  res.render('highestSalesView', {
    employee: await employeeData.getHighestSalesEmployee()
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
