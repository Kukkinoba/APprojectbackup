package model;

public class Report {

	//-----------------------Main Attributes-----------------------
    public String type; 
    public String period; 

    // Shipment
    public int totalShipments;
    public int delivered;
    public int delayed;
    public int pending;
    public int inTransit;

    // Revenue
    public double totalRevenue;

    // Vehicle
    public double vehicleUtilizationPercent;

    // Invoice 
    public int totalInvoices;
    public int paidInvoices;
    public int unpaidInvoices;
    
  //-------------------------Constructors-------------------------
	public Report() {
		type = "";
		period = "";
		totalShipments = 0;
		delivered = 0;
		delayed = 0;
		pending = 0;
		inTransit = 0;
		totalRevenue = 0.0;
		vehicleUtilizationPercent = 0.0;
		totalInvoices = 0;
		paidInvoices = 0;
		unpaidInvoices = 0;
	}


	public Report(String type, String period, int totalShipments, int delivered, int delayed, int pending,
			int inTransit, double totalRevenue, double vehicleUtilizationPercent, int totalInvoices, int paidInvoices,
			int unpaidInvoices) {
		super();
		this.type = type;
		this.period = period;
		this.totalShipments = totalShipments;
		this.delivered = delivered;
		this.delayed = delayed;
		this.pending = pending;
		this.inTransit = inTransit;
		this.totalRevenue = totalRevenue;
		this.vehicleUtilizationPercent = vehicleUtilizationPercent;
		this.totalInvoices = totalInvoices;
		this.paidInvoices = paidInvoices;
		this.unpaidInvoices = unpaidInvoices;
	}

	//---------------------Getters and Setters---------------------
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPeriod() {
		return period;
	}


	public void setPeriod(String period) {
		this.period = period;
	}


	public int getTotalShipments() {
		return totalShipments;
	}


	public void setTotalShipments(int totalShipments) {
		this.totalShipments = totalShipments;
	}


	public int getDelivered() {
		return delivered;
	}


	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}


	public int getDelayed() {
		return delayed;
	}


	public void setDelayed(int delayed) {
		this.delayed = delayed;
	}


	public int getPending() {
		return pending;
	}


	public void setPending(int pending) {
		this.pending = pending;
	}


	public int getInTransit() {
		return inTransit;
	}


	public void setInTransit(int inTransit) {
		this.inTransit = inTransit;
	}


	public double getTotalRevenue() {
		return totalRevenue;
	}


	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}


	public double getVehicleUtilizationPercent() {
		return vehicleUtilizationPercent;
	}


	public void setVehicleUtilizationPercent(double vehicleUtilizationPercent) {
		this.vehicleUtilizationPercent = vehicleUtilizationPercent;
	}


	public int getTotalInvoices() {
		return totalInvoices;
	}


	public void setTotalInvoices(int totalInvoices) {
		this.totalInvoices = totalInvoices;
	}


	public int getPaidInvoices() {
		return paidInvoices;
	}


	public void setPaidInvoices(int paidInvoices) {
		this.paidInvoices = paidInvoices;
	}


	public int getUnpaidInvoices() {
		return unpaidInvoices;
	}


	public void setUnpaidInvoices(int unpaidInvoices) {
		this.unpaidInvoices = unpaidInvoices;
	}


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(type).append("\n");
        sb.append("Period: ").append(period).append("\n\n");

        if (totalShipments > 0) {
            sb.append("Total Shipments: ").append(totalShipments).append("\n");
            sb.append("Delivered: ").append(delivered).append("\n");
            sb.append("Delayed: ").append(delayed).append("\n");
            sb.append("Pending: ").append(pending).append("\n");
            sb.append("In Transit: ").append(inTransit).append("\n\n");
        }

        if (totalRevenue > 0) {
            sb.append("Total Revenue: $").append(totalRevenue).append("\n\n");
        }

        if (vehicleUtilizationPercent > 0) {
            sb.append("Vehicle Utilization: ")
              .append(vehicleUtilizationPercent).append("%\n\n");
        }

        if (totalInvoices > 0) {
            sb.append("Invoices: ").append(totalInvoices).append("\n");
            sb.append("Paid: ").append(paidInvoices).append("\n");
            sb.append("Unpaid: ").append(unpaidInvoices).append("\n");
        }

        return sb.toString();
    }
}
