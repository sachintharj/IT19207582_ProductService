$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation-------------------
var status = validateProjectForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
//If valid------------------------
var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
 $.ajax(
 {
 url : "SellingProjectsAPI",
 type : type,
 data : $("#formProjects").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
	 onProjectSaveComplete(response.responseText, status);
 }
 });
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
		{
		$("#hidItemIDSave").val($(this).data("prjid"));
		 $("#Proj_type").val($(this).closest("tr").find('td:eq(0)').text());
		 $("#Proj_name").val($(this).closest("tr").find('td:eq(1)').text());
		 $("#Proj_link").val($(this).closest("tr").find('td:eq(2)').text());
		 $("#Proj_Desc").val($(this).closest("tr").find('td:eq(3)').text());
		 $("#Price").val($(this).closest("tr").find('td:eq(4)').text());
		 $("#Submit_date").val($(this).closest("tr").find('td:eq(5)').text());
		
		});

//Delete

$(document).on("click", ".btnRemove", function(event)
		{
		 $.ajax(
		 {
		 url : "SellingProjectsAPI",
		 type : "DELETE",
		 data : "Proj_id=" + $(this).data("prjid"),
		 dataType : "text",
		 complete : function(response, status)
		 {
			 onProjectDeleteComplete(response.responseText, status);
		 }
		 });
		});
// CLIENT-MODEL================================================================
function validateProjectForm()
{
// Proj_type
if ($("#Proj_type").val().trim() == "")
 {
 return "Insert Project Type.";
 }
// Proj_name
if ($("#Proj_name").val().trim() == "")
 {
 return "Insert Project Name.";
 }
//Proj_link
if ($("#Proj_link").val().trim() == "")
 {
 return "Insert Project link.";
 }
//Proj_Desc
if ($("#Proj_Desc").val().trim() == "")
{
return "Insert Project Description.";
}
//PRICE-------------------------------
if ($("#Price").val().trim() == "")
 {
 return "Insert Price.";
 }
// is numerical value
var tmpPrice = $("#Price").val().trim();
if (!$.isNumeric(tmpPrice))
 {
 return "Insert a numerical value for Price.";
 }
// convert to decimal price
 $("#Price").val(parseFloat(tmpPrice).toFixed(2));
// DESCRIPTION------------------------
if ($("#Submit_date").val().trim() == "")
 {
 return "Insert Submit Date.";
 }

return true;
}

function onProjectSaveComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divItemsGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while saving.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while saving..");
 $("#alertError").show();
 } 

$("#hidItemIDSave").val("");
$("#formProjects")[0].reset();
}

function onProjectDeleteComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divItemsGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
}