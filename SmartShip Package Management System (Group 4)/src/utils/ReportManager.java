package utils;

import model.Report;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class ReportManager {

    private Connection conn;

    public ReportManager(Connection c) {
        this.conn = c;
    }

  //---------------------  daily reporyt ---------------------
    public Report getDailyReport() throws SQLException {

        LocalDate today = LocalDate.now();

        Report r = new Report();
        r.type = "Daily Shipment Report";
        r.period = today.toString();

        PreparedStatement ps = conn.prepareStatement("""
            SELECT status, COUNT(*) AS total
            FROM shipments
            WHERE DATE(created_at) = ?
            GROUP BY status
        """);

        ps.setDate(1, Date.valueOf(today));
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String s = rs.getString("status").toLowerCase();
            int c = rs.getInt("total");

            if (s.equals("delivered")) r.delivered = c;
            if (s.equals("delayed")) r.delayed = c;
            if (s.equals("pending")) r.pending = c;
            if (s.equals("in transit")) r.inTransit = c;
        }

        r.totalShipments = r.delivered + r.delayed + r.pending + r.inTransit;

        return r;
    }

  //--------------------- weekly report ---------------------

    public Report getWeeklyReport() throws SQLException {

        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(7);

        Report r = new Report();
        r.type = "Weekly Shipment Report";
        r.period = start + " to " + end;

        PreparedStatement ps = conn.prepareStatement("""
            SELECT status, COUNT(*) AS total
            FROM shipments
            WHERE DATE(created_at) BETWEEN ? AND ?
            GROUP BY status
        """);

        ps.setDate(1, Date.valueOf(start));
        ps.setDate(2, Date.valueOf(end));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String s = rs.getString("status").toLowerCase();
            int c = rs.getInt("total");

            if (s.equals("delivered")) r.delivered = c;
            if (s.equals("delayed")) r.delayed = c;
            if (s.equals("pending")) r.pending = c;
            if (s.equals("in transit")) r.inTransit = c;
        }

        r.totalShipments = r.delivered + r.delayed + r.pending + r.inTransit;

        return r;
    }

  //--------------------- monthly report ---------------------

    public Report getMonthlyReport() throws SQLException {
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(30);

        Report r = new Report();
        r.type = "Monthly Shipment Report";
        r.period = start + " to " + end;

        PreparedStatement ps = conn.prepareStatement("""
            SELECT status, COUNT(*) AS total
            FROM shipments
            WHERE DATE(created_at) BETWEEN ? AND ?
            GROUP BY status
        """);

        ps.setDate(1, Date.valueOf(start));
        ps.setDate(2, Date.valueOf(end));

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String s = rs.getString("status").toLowerCase();
            int c = rs.getInt("total");

            if (s.equals("delivered")) r.delivered = c;
            if (s.equals("delayed")) r.delayed = c;
            if (s.equals("pending")) r.pending = c;
            if (s.equals("in transit")) r.inTransit = c;
        }

        r.totalShipments = r.delivered + r.delayed + r.pending + r.inTransit;

        return r;
    }

  //--------------------- revenue report ---------------------

    public Report getRevenueReport(LocalDate start, LocalDate end) throws SQLException {

        Report r = new Report();
        r.type = "Revenue Report";
        r.period = start + " to " + end;

        PreparedStatement ps = conn.prepareStatement("""
            SELECT SUM(final_amount) AS total
            FROM invoices
            WHERE DATE(date_issued) BETWEEN ? AND ?
        """);

        ps.setDate(1, Date.valueOf(start));
        ps.setDate(2, Date.valueOf(end));

        ResultSet rs = ps.executeQuery();

        if (rs.next()) r.totalRevenue = rs.getDouble("total");

        return r;
    }

  //--------------------- vehivle utilization ---------------------

    public Report getVehicleUtilizationReport() throws SQLException {

        Report r = new Report();
        r.type = "Vehicle Utilization Report";
        r.period = "All Time";

        PreparedStatement ps = conn.prepareStatement("""
            SELECT SUM(s.weight) AS load, v.capacityWeight
            FROM vehicles v
            LEFT JOIN shipments s ON v.vehicleId = s.assignedVehicleId
            GROUP BY v.vehicleId
        """);

        ResultSet rs = ps.executeQuery();

        double totalUsed = 0;
        double totalCapacity = 0;

        while (rs.next()) {
            totalUsed += rs.getDouble("load");
            totalCapacity += rs.getDouble("capacityWeight");
        }

        if (totalCapacity > 0) {
            r.vehicleUtilizationPercent = (totalUsed / totalCapacity) * 100;
        }

        return r;
    }

 
  //--------------------- pdf generator from apache (pdfbox and fontbox) ---------------------

    public void exportToPDF(Report r, String filePath) {
        try (PDDocument doc = new PDDocument()) {

            PDPage page = new PDPage();
            doc.addPage(page);

            PDPageContentStream c = new PDPageContentStream(doc, page);
            PDType0Font font = PDType0Font.load(doc,
                    ReportManager.class.getResourceAsStream("/fonts/Roboto-Regular.ttf"));

            c.beginText();
            c.setFont(font, 14);
            c.newLineAtOffset(50, 700);

            c.showText(r.type);
            c.newLineAtOffset(0, -20);
            c.showText("Period: " + r.period);
            c.newLineAtOffset(0, -20);

            c.setFont(font, 12);
            if (r.totalShipments > 0) {
                c.showText("Total Shipments: " + r.totalShipments); c.newLineAtOffset(0,-15);
                c.showText("Delivered: " + r.delivered); c.newLineAtOffset(0,-15);
                c.showText("Delayed: " + r.delayed); c.newLineAtOffset(0,-15);
                c.showText("Pending: " + r.pending); c.newLineAtOffset(0,-15);
                c.showText("In Transit: " + r.inTransit); c.newLineAtOffset(0,-15);
            }

            if (r.totalRevenue > 0) {
                c.showText("Total Revenue: $" + r.totalRevenue); c.newLineAtOffset(0,-15);
            }

            if (r.vehicleUtilizationPercent > 0) {
                c.showText("Vehicle Utilization: " + r.vehicleUtilizationPercent + "%"); c.newLineAtOffset(0,-15);
            }

            if (r.totalInvoices > 0) {
                c.showText("Total Invoices: " + r.totalInvoices); c.newLineAtOffset(0,-15);
                c.showText("Paid: " + r.paidInvoices); c.newLineAtOffset(0,-15);
                c.showText("Unpaid: " + r.unpaidInvoices); c.newLineAtOffset(0,-15);
            }

            c.endText();
            c.close();
            doc.save(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
