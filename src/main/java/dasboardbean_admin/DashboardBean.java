package dasboardbean_admin;

import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "dashboardBean") // para acceder desde el xhtml
@ViewScoped
public class DashboardBean implements Serializable {

    private String chartLabels;
    private String chartData;

    //constructor
    public DashboardBean() {
        loadChartData();
    }

    private void loadChartData() {
        StringBuilder labels = new StringBuilder("[");
        StringBuilder data = new StringBuilder("[");

        try {
            String url = "jdbc:mysql://127.0.0.1:3306/sbr";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            String query = "SELECT rol, COUNT(*) AS cantidad FROM usuarios GROUP BY rol";
            ResultSet rs = stmt.executeQuery(query);

            boolean first = true;
            while (rs.next()) {
                if (!first) {
                    labels.append(",");
                    data.append(",");
                }
                labels.append("'").append(rs.getString("rol")).append("'");
                data.append(rs.getInt("cantidad"));
                first = false;
            }
            labels.append("]");
            data.append("]");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            // el Default fallback
            labels = new StringBuilder("['Error']");
            data = new StringBuilder("[0]");
        }

        this.chartLabels = labels.toString();
        this.chartData = data.toString();

        System.out.println("Labels generados: " + chartLabels);
        System.out.println("Datos generados: " + chartData);

    }

    public String getChartLabels() {
        return chartLabels;
    }

    public String getChartData() {
        return chartData;
    }
}
