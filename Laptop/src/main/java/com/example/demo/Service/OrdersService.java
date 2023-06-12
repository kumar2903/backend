package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Orders;
import com.example.demo.Repository.OrdersRepository;

import jakarta.transaction.Transactional;
@Service
public class OrdersService {
	@Autowired
	OrdersRepository orderRepository;
	public List<Orders>getAllShoe()
	{
		List<Orders> shoeList=orderRepository.findAll();
		return shoeList;
	}
	public Orders savePersons(Orders p)
	{
		return orderRepository.save(p);
	}
	 public Orders updateStudent(Orders s)
	 {
		Orders obj=orderRepository.save(s);
		 return obj;
		 //return studRepository.save(s);
	 }
	 public void deleteStudent(long id)
	 {
		 orderRepository.deleteById(id);
	 }
	public List<Orders> getOrdersByOrderTrackingNumber(String orderNo, String status) 
	{
		return orderRepository.getOrdersByOrderTrackingNumber(orderNo, status);
	}
	
	@Transactional
	
	public int deleteOrdersBystatus(String status) {
	return orderRepository.deleteOrdersBystatus(status);
	}
	@Transactional

	 public int update(String username,String userid)

	 {

		 return orderRepository.UpdateOrdersByStatus(username,userid);

	 }
	//native
			//public List<Orders> fetchRecipeByServing(int total_quantity)
			//{
				//return orderRepository.fetchRecipeByServing(total_quantity);
			//}
	//native
		public List<Orders> getOrdersByStatus(String status)
		{
			return orderRepository.getOrdersByStatus(status);
		}
			

}
