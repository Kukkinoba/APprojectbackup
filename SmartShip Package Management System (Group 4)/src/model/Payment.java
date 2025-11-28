package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    //------------------------ Pay Attributes ------------------------
    private int payId;
    private int invoiceId;
    private int userId; 
    private double amountPaid;
    private String payMethod;
    private LocalDateTime payDate;
    private String status;

    //------------------------ Constructors ------------------------
    public Payment() {
    	payId = 0;
        invoiceId = 0;
        userId = 0;
        amountPaid = 0.0;
        payMethod = "";
        payDate = null;
        status = "";
    }

    public Payment(int paymentId, int invoiceId, int userId, double amountPaid,
                   String paymentMethod, LocalDateTime paymentDate, String status) {
        this.payId = paymentId;
        this.invoiceId = invoiceId;
        this.userId = userId;
        this.amountPaid = amountPaid;
        this.payMethod = paymentMethod;
        this.payDate = paymentDate;
        this.status = status;
    }

    //------------------------ Getters & Setters ------------------------
	    public int getPaymentId() {
			return payId;
		}
	
		public void setPaymentId(int paymentId) {
			this.payId = paymentId;
		}
	
		public int getInvoiceId() {
			return invoiceId;
		}
	
		public void setInvoiceId(int invoiceId) {
			this.invoiceId = invoiceId;
		}
	
		public int getUserId() {
			return userId;
		}
	
		public void setUserId(int userId) {
			this.userId = userId;
		}
	
		public double getAmountPaid() {
			return amountPaid;
		}
	
		public void setAmountPaid(double amountPaid) {
			this.amountPaid = amountPaid;
		}
	
		public String getPaymentMethod() {
			return payMethod;
		}
	
		public void setPaymentMethod(String paymentMethod) {
			this.payMethod = paymentMethod;
		}
	
		public LocalDateTime getPaymentDate() {
			return payDate;
		}
	
		public void setPaymentDate(LocalDateTime paymentDate) {
			this.payDate = paymentDate;
		}
	
		public String getStatus() {
			return status;
		}
	
		public void setStatus(String status) {
			this.status = status;
		}
	
		public static long getSerialversionuid() {
			return serialVersionUID;
		}


    //------------------------ Payment functions ------------------------

    public boolean validPayment() {
        return amountPaid > 0 &&
               payMethod != null &&
               !payMethod.trim().isEmpty();
    }

   
    public boolean procPayment() {
        if (!validPayment()) {
            this.status = "Failed";
            return false;
        }

        this.payDate = LocalDateTime.now();
        this.status = "Paid";
        return true;
    }

//recipt display for gui
    public String paySummary() {
        return  "Payment ID: " + payId +
                "\nInvoice ID: " + invoiceId +
                "\nUser ID: " + userId +
                "\nAmount Paid: $" + amountPaid +
                "\nMethod: " + payMethod +
                "\nDate: " + payDate +
                "\nStatus: " + status;
    }

    //------------------------ ToString ------------------------
    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + payId +
                ", invoiceId=" + invoiceId +
                ", userId=" + userId +
                ", amountPaid=" + amountPaid +
                ", method='" + payMethod + '\'' +
                ", date=" + payDate +
                ", status='" + status + '\'' +
                '}';
    }
}
