package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{
	Orders findByOrderTrackingNumber(String orderTrackingNumber);
	@Query("select s from  Orders s where s.orderTrackingNumber=?1 and s.status=?2")
	public List<Orders> getOrdersByOrderTrackingNumber(String orderNo,String status);
	
	//named parameter
	
	//@Query("select s from Orders s where s.status=:status")
	//public List<Orders> getOrdersByStatus(String status);
	

	
	//DML parameter
	@Modifying
	
	@Query("delete from Orders s where s.status=?1")
	public int deleteOrdersBystatus(String status);
	
	@Modifying

	@Query("update Orders e set e.orderTrackingNumber=?1 where e.status=?2")

	public int UpdateOrdersByStatus(String orderTrackingNumber,String status);
	
	//Native
	 	//@Query(value="select * from orders",nativeQuery =true)
	 	//public List<Orders> fetchRecipeByServing(int total_quantity);
	@Query("select s from Orders s where s.status=:status")
	public List<Orders> getOrdersByStatus(String status);
}
