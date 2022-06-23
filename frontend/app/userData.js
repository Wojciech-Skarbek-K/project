const mysql = require('mysql'); 
const axios = require('axios'); 
const dbconfig = require('./dbconfig.json'); 
const util = require ('util');
const CryptoJS = require('crypto-js');
const { concat } = require('lodash');

const db = wrapDB(dbconfig)

 function wrapDB (dbconfig) { 
    const pool = mysql.createPool(dbconfig) 
    return { 
        query(sql, args) { 
            console.log("in query in wrapper") 
            return util.promisify( pool.query ) 
            .call(pool, sql, args) 
        }, 
        release () { 
            return util.promisify( pool.releaseConnection ) 
            .call( pool ) 
        } 
    } 
}


  exports.addUser = async (newUser) => { 

    newUser.password = CryptoJS.AES.encrypt(newUser.password, "Secret Passphrase");
    //newUser.password = CryptoJS.AES.decrypt(newUser.password, "Secret Passphrase");


    let results = await db.query('INSERT INTO User SET ?', newUser) 
    return results.insertId; 
}

exports.getUsersPlease = async (username) => { 
    try {  

        const euserResponse = await axios.post('http://localhost:8080/hr/user', {"name": username}) 

        return euserResponse.data
      } catch (e) { 
        return new Error('Could not get cities') 
      } 
  }

  /*
  exports.getUsers = async () => { 
    let users = []  
      try {  
        const euserResponse = await axios.get('http://localhost:8080/hr/user') 
        for (let data of euserResponse.data) { 
            users.push(data) 
        } 
      } catch (e) { 
        console.log(e)
         return new Error('Could not get cities') 
      } 
      return users; 
  } */

  exports.checkUser = async (myUser) => { 
    //let flag = false;
    const loggedUser = {flag: false, role: "Role"}

    const localPass = myUser.password
    myUser.password = CryptoJS.AES.encrypt(myUser.password, "Secret Passphrase");

    try {  
      const link = 'http://localhost:8080/api/users/'
      const euserResponse = await axios.get(link.concat(myUser.username)) 
      const sqlPass = CryptoJS.AES.encrypt(euserResponse.data.password, "Secret Passphrase");
      const sqlPassDecrypt = CryptoJS.AES.decrypt(euserResponse.data.password, "Secret Passphrase").toString(CryptoJS.enc.Utf8);
      if (localPass == sqlPassDecrypt) {
        loggedUser.flag = true;
        loggedUser.role = euserResponse.data.role;
      } else {
        loggedUser.flag = false;
      }
      

    } catch (e) { 
      console.log(e)
       return new Error('Could not get cities') 
    } 
    return loggedUser;


}

