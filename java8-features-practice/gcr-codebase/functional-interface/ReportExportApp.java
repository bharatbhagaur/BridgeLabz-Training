package functionalinterface;

interface DataExporter {

    void exportToCSV();
    void exportToPDF();

    // Default method added later without breaking existing implementations
    default void exportToJSON() {
        System.out.println("Exporting data in JSON format using default implementation");
    }
}

class SalesReportExporter implements DataExporter {

    public void exportToCSV() {
        System.out.println("Sales report exported to CSV format");
    }

    public void exportToPDF() {
        System.out.println("Sales report exported to PDF format");
    }
}

class InventoryReportExporter implements DataExporter {

    public void exportToCSV() {
        System.out.println("Inventory report exported to CSV format");
    }

    public void exportToPDF() {
        System.out.println("Inventory report exported to PDF format");
    }
}

public class ReportExportApp {

    public static void main(String[] args) {

        DataExporter salesExporter = new SalesReportExporter();
        DataExporter inventoryExporter = new InventoryReportExporter();

        salesExporter.exportToCSV();
        salesExporter.exportToPDF();
        salesExporter.exportToJSON();

        inventoryExporter.exportToCSV();
        inventoryExporter.exportToPDF();
        inventoryExporter.exportToJSON();
    }
}
