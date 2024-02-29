$(document).ready(function () {
	moment.locale('pt-BR');
    var table = $('#table-anoCrud').DataTable({
		
		"language": { "url": "//cdn.datatables.net/plug-ins/1.13.2/i18n/pt-BR.json" },
    	searching: true,
    	order: [[ 1, "asc" ]],
    	lengthMenu: [5, 10, 20, 50],
        processing: true,
        serverSide: true,
        responsive: true,
        ajax: {
            url: '/anos/datatables/server',
            data: 'data'
        },
        columns: [
			
            {data: 'id'},
            {data: 'ano'},      
            
            {orderable: false, 
             data: 'id',
                "render": function(id) {
                    return '<a class="btn btn-success btn-sm btn-block" href="/anos/editar/'+ 
                    	id +'" role="button"><i class="fas fa-edit"></i></a>';
                }
            },
            {orderable: false,
             data: 'id',
                "render": function(id) {
                    return '<a class="btn btn-danger btn-sm btn-block" href="/anos/excluir/'+ 
                    	id +'" role="button" data-toggle="modal" data-target="#confirm-modal"><i class="fas fa-times-circle"></i></a>';
                }               
            }
        ]
    });
});    
