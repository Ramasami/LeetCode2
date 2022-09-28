public class DesignSQL {

    Map<String, Table> tableMap;

    public SQL(List<String> names, List<Integer> columns) {
            tableMap = new HashMap<>();
            for(int i=0;i<names.size();i++) {
                tableMap.put(names.get(i), new Table(columns.get(i)));
            }
        }

    public void insertRow(String name, List<String> row) {
        tableMap.get(name).insertRow(row);
    }

    public void deleteRow(String name, int rowId) {
        tableMap.get(name).deleteRow(rowId);
    }

    public String selectCell(String name, int rowId, int columnId) {
        return tableMap.get(name).fetchCell(rowId, columnId);

    }
}

class Table {
    private int rowCount;
    private int colCount;
    Map<Integer, List<String>> rows;

    public Table(int colCount) {
        this.rowCount = 1;
        this.colCount = colCount;
        this.rows = new HashMap<>();
    }

    public void insertRow(List<String> row) {
        rows.put(rowCount, row);
        rowCount++;
    }

    public void deleteRow(int rowId) {
        rows.remove(rowId);
    }

    public String fetchCell(int rowId, int columnId) {
        return rows.get(rowId).get(columnId - 1);
    }
}