 $(document).ready(function(){
             var errVal = $('#errorMsg').val();
             if(errVal!==""){
                  $('#register-modal').modal('show');
             }
             var errVal1 = $('#errorMsg1').val();
             if(errVal1!==""){
                  $('#userlogin-modal').modal('show');
             }
             var errVal2 = $('#errorMsg2').val();
             if(errVal2!==""){
                  $('#login-modal').modal('show');
             }
             
         });