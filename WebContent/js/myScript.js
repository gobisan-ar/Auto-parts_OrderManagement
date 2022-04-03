	$(document).ready(function() {
		 $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
         
                password: "required",
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                 
                password: "Please enter password"
            }
        });
 
	
		$('table .deleteZone').on('click', function(){
			var zid = $(this).parent().find('#zid').val();
			$('#deleteZone #zid').val(zid);
		});
		
		$('table .updateZone').on('click', function(){
			var zid = $(this).parent().find('#zid').val();
			var name = $(this).parent().find('#name').val();
			var area = $(this).parent().find('#area').val();
			var budget = $(this).parent().find('#budget').val();
			
			$('#updateZone #zid').val(zid);
			$('#updateZone #name').val(name);
			$('#updateZone #area').val(area);
			$('#updateZone #budget').val(budget);
		});
	
		$('table .deleteStaff').on('click', function() {
			var sid = $(this).parent().find('#sid').val();
			$('#deleteStaff #sid').val(sid);
		});

		$('table .updateStaff').on('click', function() {
			var sid = $(this).parent().find('#sid').val();
			var fname = $(this).parent().find('#fname').val();
			var lname = $(this).parent().find('#lname').val();
			var email = $(this).parent().find('#email').val();
			var mobile = $(this).parent().find('#mobile').val();
			var nic = $(this).parent().find('#nic').val();
			var status = $(this).parent().find('#status').val();

			$('#updateStaff #sid').val(sid);
			$('#updateStaff #fname').val(fname);
			$('#updateStaff #lname').val(lname);
			$('#updateStaff #email').val(email);
			$('#updateStaff #mobile').val(mobile);
			$('#updateStaff #nic').val(nic);
			$('#updateStaff #status').val(status);
		});
		
		 $.validator.addMethod("validEmail", 
		 
		 	function(value, element){
				return this.optional(element) || /^[a-zA-Z0-9._-]+@(fozti)+\.[lk]{2,100}$/i.test(value);
			});
			
			 $.validator.addMethod("validNIC", 
		 	function(value, element){
				return this.optional(element) || /^[0-9]{9}[x|X|v|V]|[0-9]{12}$/.test(value);
			});
			
			$.validator.addMethod("validMobile", 
		 	function(value, element){
				return this.optional(element) || /^[0-9]{10}$/.test(value);
			});
		
		// front-end validation
		$("form[name='staffForm']").validate({
    		// Specify validation rules
    		rules: {
      			fname: "required",
      			lname: "required",
      			
      			email: {
      				required: true,
      				validEmail: true
      			},
      			
      			nic: {
      				required: true,
      				validNIC: true
      			},
      			
      			mobile: {
      				required: true,
      				validMobile: true
      			},
    		},
    		
    		// Specify validation error messages
    		messages: {
      			fname: "Please enter firstname",
      			lname: "Please enter lastname",
      			
      			email: {
      				required: "Please enter email",
      				validEmail: "Please enter a valid email address."
      			},
      			
      			nic: {
      				required: "Please enter nic number",
      				validNIC: "Please enter a valid nic number."
      			},
      			
      			mobile: {
      				required: "Please enter mobile number",
      				validMobile: "Please enter a valid mobile number."
      			}
      		
      		},
      		      
    		submitHandler: function(form) {
      			form.submit();
    		}
  	});
  	
  	$('table .deleteOrder').on('click', function(){
			var oid = $(this).parent().find('#oid').val();
			$('#deleteOrder #oid').val(oid);
		});
		
		$('table .acceptOrder').on('click', function(){
			var oid = $(this).parent().find('#oid').val();
			$('#acceptOrder #oid').val(oid);
		});
		
		$('table .shipOrder').on('click', function(){
			var oid = $(this).parent().find('#oid').val();
			$('#shipOrder #oid').val(oid);
		});
		
		$('table .holdOrder').on('click', function(){
			var oid = $(this).parent().find('#oid').val();
			$('#holdOrder #oid').val(oid);
		});
  
  
	});
