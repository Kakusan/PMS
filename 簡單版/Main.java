
import com.PMS.PatientMonitorSystem;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            PatientMonitorSystem patientMonitorSystem = new PatientMonitorSystem();
            patientMonitorSystem.work(args[0]);
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
    }

}
