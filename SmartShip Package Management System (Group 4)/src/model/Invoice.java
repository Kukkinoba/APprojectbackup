package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    //------------------------ Main Attributes ------------------------
    private int invoiceId;
    private int shipmentId;
    private int userId;
    private double baseAmount; // its the cost calculated in shipment
    private double discount; 
    private double surcharge; 
    private double total;
    private String status;  
    private LocalDateTime dateIssued;

    //------------------------ Constructors ------------------------
    public Invoice() {
    	invoiceId = 0;
        shipmentId = 0;
        userId = 0;
        baseAmount = 0.0;
        discount = 0.0;
        surcharge = 0.0;
        status = "unpaid";
        dateIssued = null;
        total = calFinAmount();
    }

    public Invoice(int invoiceId, int shipmentId, int userId,
                   double baseAmount, double discount, double surcharge,
                   String status, LocalDateTime dateIssued) {

        this.invoiceId = invoiceId;
        this.shipmentId = shipmentId;
        this.userId = userId;
        this.baseAmount = baseAmount;
        this.discount = discount;
        this.surcharge = surcharge;
        this.status = status;
        this.dateIssued = dateIssued;
        this.total = calFinAmount();
    }

	

    //------------------------ Getters & Setters ------------------------
	    public int getInvoiceId() {
			return invoiceId;
		}
	
		public void setInvoiceId(int invoiceId) {
			this.invoiceId = invoiceId;
		}
	
		public int getShipmentId() {
			return shipmentId;
		}
	
		public void setShipmentId(int shipmentId) {
			this.shipmentId = shipmentId;
		}
	
		public int getUserId() {
			return userId;
		}
	
		public void setUserId(int userId) {
			this.userId = userId;
		}
	
		public double getBaseAmount() {
			return baseAmount;
		}
	
		public void setBaseAmount(double baseAmount) {
			this.baseAmount = baseAmount;
		}
	
		public double getDiscount() {
			return discount;
		}
	
		public void setDiscount(double discount) {
			this.discount = discount;
		}
	
		public double getSurcharge() {
			return surcharge;
		}
	
		public void setSurcharge(double surcharge) {
			this.surcharge = surcharge;
		}
	
		public double getTotal() {
			return total;
		}
	
		public void setTotal(double total) {
			this.total = total;
		}
	
		public String getStatus() {
			return status;
		}
	
		public void setStatus(String status) {
			this.status = status;
		}
	
		public LocalDateTime getDateIssued() {
			return dateIssued;
		}
	
		public void setDateIssued(LocalDateTime dateIssued) {
			this.dateIssued = dateIssued;
		}
	
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
 

    //------------------------ invoice calcs ------------------------
		private double calFinAmount() {
	        double total = baseAmount + surcharge + (baseAmount * discount);
	        if (total < 0) total = 0;
	        return total;
	    }

		public void applyPayment(double amountPaid) {
	        if (amountPaid >= total) {
	            status = "Paid";
	        } else if (amountPaid > 0) {
	            status = "Partially Paid";
	        } else {
	            status = "Unpaid";
	        }
	    }

		
		
    //------------------------ toString ------------------------
		@Override
				public String toString() {
					return "Invoice [invoiceId=" + invoiceId + ", shipmentId=" + shipmentId + ", userId=" + userId
							+ ", baseAmount=" + baseAmount + ", discount=" + discount + ", surcharge=" + surcharge + ", total="
							+ total + ", status=" + status + ", dateIssued=" + dateIssued + "]";
				}
}
