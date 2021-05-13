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
var status = validateItemForm();
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
 url : "SellingItemsAPI",
 type : type,
 data : $("#formItem").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
 onItemSaveComplete(response.responseText, status);
 }
 });
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
		{
		$("#hidItemIDSave").val($(this).data("itemid"));
		 $("#Item_Name").val($(this).closest("tr").find('td:eq(0)').text());
		 $("#Item_Desc").val($(this).closest("tr").find('td:eq(1)').text());
		 $("#Item_price").val($(this).closest("tr").find('td:eq(2)').text());
		 $("#Stock_qty").val($(this).closest("tr").find('td:eq(3)').text());
		});

//Delete

$(document).on("click", ".btnRemove", function(event)
		{
		 $.ajax(
		 {
		 url : "SellingItemsAPI",
		 type : "DELETE",
		 data : "Item_id=" + $(this).data("itemid"),
		 dataType : "text",
		 complete : function(response, status)
		 {
		 onItemDeleteComplete(response.responseText, status);
		 }
		 });
		});
// CLIENT-MODEL================================================================
function validateItemForm()
{
// Name
if ($("#Item_Name").val().trim() == "")
 {
 return "Insert Item Name.";
 }
// Desc
if ($("#Item_Desc").val().trim() == "")
 {
 return "Insert Item Description.";
 }

//PRICE-------------------------------
if ($("#Item_price").val().trim() == "")
 {
 return "Insert Item Price.";
 }
// is numerical value
var tmpPrice = $("#Item_price").val().trim();
if (!$.isNumeric(tmpPrice))
 {
 return "Insert a numerical value for Item Price.";
 }
// convert to decimal price
 $("#Item_price").val(parseFloat(tmpPrice).toFixed(2));
// Stock_qty------------------------
if ($("#Stock_qty").val().trim() == "")
 {
 return "Insert Item Stock_Qty.";
 }
return true;
}

function onItemSaveComplete(response, status)
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
$("#formItem")[0].reset();
}

function onItemDeleteComplete(response, status)
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