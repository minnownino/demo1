/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myFunction() {
    var a = document.getElementById("exampleInputPassword1");
    var b = document.getElementById("exampleInputPassword2");
    var c = document.getElementById("confirmation").innerHTML;
    if(a.value === b.value)
       document.getElementById("confirmation").innerHTML="yes";
    else
       document.getElementById("confirmation").innerHTML="no";
}


