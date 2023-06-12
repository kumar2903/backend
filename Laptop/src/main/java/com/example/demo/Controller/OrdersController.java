package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Orders;
import com.example.demo.Service.OrdersService;

import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
public class OrdersController {
	@Autowired
	  OrdersService orderService;
	@Tag(name="Post",description="post data")
	  @GetMapping(value="/fetchOrders")
	  public List<Orders> getAllShoe()
	  {
		  List<Orders> shoeList=orderService.getAllShoe();
		  return shoeList;
	  }
	  @PostMapping("/saveOrders")
	  public Orders savePersons(@RequestBody Orders p)
	  {
	  	return orderService.savePersons(p);
	  }
	  
	  @PutMapping(value="/updateOrders")
	  public Orders updateStudent(@RequestBody Orders s)
	  {
	 	 return orderService.updateStudent(s);
	  }
	  @Tag(name="delete",description="delete data")
	  @DeleteMapping(value="/deleteOrder/{id}")
	  public void deleteStudent(@PathVariable("id") long id)
	  {
	 	 orderService.deleteStudent(id);
	  }
	//Jpa Query
		@Tag(name="Get",description="get data")
		  @GetMapping("/fetchOrdersByOrderTrackingNumber/{orderNo}/{status}")
			 public List<Orders>fetchgetOrdersByOrderTrackingNumber(@PathVariable String orderNo,@PathVariable String status)
			 {
				 return orderService.getOrdersByOrderTrackingNumber(orderNo,status);
			 }
		@Tag(name="Delete",description="delete data")
			 @DeleteMapping("/deleteOrdersByStatus/{status}")
			 public String deleteOrdersByStatus(@PathVariable String status)
			 {
			 int result=orderService.deleteOrdersBystatus(status);
			 if(result >0)
			 	return "Order record deleted";
			 else
			 	return "Problem occured while deleting";
			 }

				//DML queries
		@Tag(name="Put",description="put data")
				@PutMapping("/update/{orderTrackingNumber}/{status}")

				public String update(@PathVariable String orderTrackingNumber,@PathVariable String status)

				{

					int result=orderService.update(orderTrackingNumber,status);

					if(result>0)

						return "Updated Successfully";

					else

						return "Problem occur while updating";
					
				}
		//native
	  	//@GetMapping("/getByServing/{total}")
	  	//public List<Orders> fetchRecipeByServing(@PathVariable int total)
	  	//{
	  	//	return orderService.fetchRecipeByServing(total);
	  	//}
//NATIVE QUERY
	@GetMapping("/getByServing/{status}")
	public List<Orders> getOrdersByStatus(@PathVariable String status)
	{
		return orderService.getOrdersByStatus(status);
	}
	
}
