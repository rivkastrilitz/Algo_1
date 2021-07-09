import java.lang.reflect.Array;
import java.util.Arrays;

public class secretaryProblem {

    public double getAverage(int treatment_time[]){
        Arrays.sort(treatment_time);
        double ev=0;
        int n=treatment_time.length-1;
        for (int i = 0; i <n ; i++) {
            ev=ev+ev+treatment_time[i];//(t1)+(t1+t2)+..(t1+t2+..+tn)

        }
        ev=ev/n;


      return ev;
    }



}
