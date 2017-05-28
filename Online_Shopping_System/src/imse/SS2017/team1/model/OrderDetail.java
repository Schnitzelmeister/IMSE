package at.ac.ac.univie.imse.SS2017.team1.model;

public class OrderDetail {

	private CustomerOrder orderId;
	private Integer orderDetailId;
	private Integer quantity;
	private Float subTotal;
	private Product product;

	/**
	 * @return the orderId
	 */
	public CustomerOrder getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(CustomerOrder orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the subTotal
	 */
	public Float getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal
	 *            the subTotal to set
	 */
	public void setSubTotal(Float subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @return the orderDetailId
	 */
	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	/**
	 * @param orderDetailId the orderDetailId to set
	 */
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	public Float calculatePrice(Integer quantity, Float unitCost) {
		return unitCost * quantity;

	}
}
