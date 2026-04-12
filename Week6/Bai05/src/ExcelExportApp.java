public class ExcelExportApp extends ExportApp {

    @Override
    protected Export createExport() {
        return new ExcelExport();
    }
}
