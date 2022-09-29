package Write;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class writeExercise {
    public static void wExercise(String[] f) throws Exception {
        String path = "src/main/resources/Exercises.txt";
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path, true)));
        for(int i=0;i<f.length;i++)
        {
            out.write(i+1 + "." + (f[i]) +"\n");
        }
        out.write("\n");
        out.close();
    }
}
