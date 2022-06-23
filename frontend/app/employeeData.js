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

exports.getHighestSalesEmployee= async () => { 
    try {  
      const employeeResponse = await axios.get('http://localhost:8080/api/highestSalesEmployee')
      return employeeResponse.data;
    } catch (e) {
       return new Error('Could not get employees')
    }
}