const mysql = require('mysql'); 
const util = require ('util')
const axios = require('axios')

exports.getEmployees = async () => { 
    let employees = []  
      try {  
        const employeeResponse = await axios.get('http://localhost:8080/api/employees')
        employees = employeeResponse.data
      } catch (e) {
         return new Error('Could not get employees')

      }
      return employees;
  }


  exports.getSales = async () => { 
    let sales = []  
      try {  
        const salesResponse = await axios.get('http://localhost:8080/api/salesEmployees')
        sales = salesResponse.data
      } catch (e) {
         return new Error('Could not get sales employees')

      }
      return sales;
  }

  exports.getDepartments = async () => { 
    let departments = []  
      try {  
        const departmentsResponse = await axios.get('http://localhost:8080/api/departments')
        departments = departmentsResponse.data
      } catch (e) {
         return new Error('Could not get employees')

      }
      return departments;
  }

  exports.addEmployee = async (newEmployee) => {
    let results = await axios.post("http://localhost:8080/api/employees", newEmployee)
    return results.insertId; 
  }
  
exports.getHighestSalesEmployee= async () => { 
    try {  
      const employeeResponse = await axios.get('http://localhost:8080/api/highestSalesEmployee')
      return employeeResponse.data;
    } catch (e) {
       return new Error('Could not get employees')
    }
}
