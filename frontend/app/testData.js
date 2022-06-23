this.employees = [ 
   { 
      emp_id: 457, 
      emp_name: "Maciek", 
      address: "GBR", 
      nin: "4313", 
      bank: "242820" ,
      salary: 2121,
      dep_id: 1
   }, 
   { 
      emp_id: 469, 
      emp_name: "Kaciem", 
      address: "GBR", 
      nin: "4312", 
      bank: "200000" ,
      salary: 14412,
      dep_id: 2
   }, 
   { 
      emp_id: 1447, 
      emp_name: "Ciekam", 
      address: "IRL", 
      nin: "1234", 
      bank: "481000" ,
      salary: 14124,
      dep_id: 3
   } 
];

exports.getEmployees = () => { return this.employees }