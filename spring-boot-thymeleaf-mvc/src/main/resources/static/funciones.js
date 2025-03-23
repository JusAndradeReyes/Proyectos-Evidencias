function eliminar(id){
	swal({
	  title: "¿Realmente desea eliminar el registro?",
	  text: "Si elimina el registro no podrá recuperarlo!",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((OK) => {
	  if (OK) {
		$.ajax({
			url:"/eliminar/"+id,
			success:function(res){
				console.log(res);
			}
		})
	    swal("Poof! Your imaginary file has been deleted!", {
	      icon: "success",
	    }).then((ok)=>{
			if(ok){
				location.href="/listar";
			}
		});
	  } else {
	    swal("No se realizó ningun cambio!"),{
	  };
	  }
	});
}