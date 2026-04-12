public abstract class ExportApp {

    public void runExport() {
        Export export = createExport();
        export.export();
    }

    protected abstract Export createExport();
}
