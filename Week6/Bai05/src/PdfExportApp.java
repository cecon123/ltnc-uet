public class PdfExportApp extends ExportApp {

    @Override
    protected Export createExport() {
        return new PdfExport();
    }
}
