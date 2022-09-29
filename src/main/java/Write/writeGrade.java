package Write;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class writeGrade {
    public static void wGradeRight(ArrayList<String> f) throws Exception {
        String path = "src/main/resources/Grade.txt";
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path, true)));
        out.write("Correct:"+"(");
        for(int i=0;i<f.size();i++)
        {
            if(i!=0)out.write(",");
            out.write((f.get(i))  );
        }
        out.write(")"+"\n");
        out.close();
    }
    public static void wGradeWrong(ArrayList<String> f) throws Exception {
        String path = "src/main/resources/Grade.txt";
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path, true)));
        out.write("Wrong:"+"(");
        for(int i=0;i<f.size();i++)
        {
            if(i!=0)out.write(",");
            out.write((f.get(i))  );
        }
        out.write(")"+"\n\n");
        out.close();
    }
}