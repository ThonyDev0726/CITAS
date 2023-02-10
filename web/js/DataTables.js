//var table = document.getElementById('example2');
//
//for (var i = 1; i < table.rows.length; i++)
//{
//    table.rows[i].onclick = function ()
//    {
//        //rIndex = this.rowIndex;
//        document.getElementById("idProductor-add-a").value = this.cells[0].innerHTML ;
////        document.getElementById("lname").value = this.cells[1].innerHTML;
////        var tIdProductor = this.cells[0].innerHTML.split();
//        
//        var tNombre =this.cells[2].innerHTML.split();
//        var tApellido =this.cells[3].innerHTML.split();
//        
//        document.getElementById("proNombre-addchacra-a").value = tNombre;
//        document.getElementById("proApellido-addchacra-a").value = tApellido;
////        document.getElementById("proNombre-addchacra-a").value = this.cells[2].innerHTML;
//        eliminaEspacio();
//    };
//}
function eliminaEspacio() {

    $('input').val(function (_, value) {
        return $.trim(value);
    });

}//end function eliminaEspacio

var table = document.getElementById('example2');

for (var i = 1; i < table.rows.length; i++)
{
    table.rows[i].onclick = function ()
    {
        document.getElementById("idUsuario").value = this.cells[0].innerHTML;
        document.getElementById("lecNombres").value = this.cells[1].innerHTML;
        document.getElementById("lecApellidos").value = this.cells[2].innerHTML;
        document.getElementById("lecCedula").value = this.cells[3].innerHTML;
         eliminaEspacio();
    };
}