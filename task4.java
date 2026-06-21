public class ReportDAO {

    private DataSource dataSource;

    public List<ReportEntry> fetchMonthlyReport(String accountId,
                                                  int month, int year)
                                                  throws SQLException {
//Fix: Using try with resources to automatically close the connection and //prepared statment object to avoid connection pool exhaustion
try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(
"SELECT * FROM report_entries " +
"WHERE account_id = ? AND MONTH(entry_date) = ? " +
"AND YEAR(entry_date) = ?"
        )){
        ps.setString(1, accountId);
        ps.setInt(2, month);
        ps.setInt(3, year);

//Fix : using try with resources to close the resultSet object automatically
     
try( ResultSet rs = ps.executeQuery()){
        List<ReportEntry> entries = new ArrayList<>();

        while (rs.next()) {
            entries.add(mapRow(rs));
        }
        return entries;    // conn, ps, rs are never closed
    }
}}
