package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Long id;

	    @Column(name="order_tracking_number")
	    private String orderTrackingNumber;

	    @Column(name="total_quantity")
	    private int totalQuantity;

	    @Column(name="total_price")
	    private float totalPrice;

	    @Column(name="status")
	    private String status;

	    // Unidirectional
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
	    private Address billingAddress;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getOrderTrackingNumber() {
			return orderTrackingNumber;
		}

		public void setOrderTrackingNumber(String orderTrackingNumber) {
			this.orderTrackingNumber = orderTrackingNumber;
		}

		public int getTotalQuantity() {
			return totalQuantity;
		}

		public void setTotalQuantity(int totalQuantity) {
			this.totalQuantity = totalQuantity;
		}

		public float getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(float totalPrice) {
			this.totalPrice = totalPrice;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Address getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(Address billingAddress) {
			this.billingAddress = billingAddress;
		}

		@Override
		public String toString() {
			return "Orders [id=" + id + ", orderTrackingNumber=" + orderTrackingNumber + ", totalQuantity="
					+ totalQuantity + ", totalPrice=" + totalPrice + ", status=" + status + ", billingAddress="
					+ billingAddress + "]";
		}
	   
}
