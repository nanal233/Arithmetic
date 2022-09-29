import Write.writeAnswer;
import Write.writeExercise;
import Write.writeGrade;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Generate {
    public static String s;
    public static int problems, max, type;
    public static String s1 = "", s2 = "";
    public static int x1, x2;    //x1,x2是参与整数运算的两数
    public static int x3,x4,x5,x6;      //参与分数运算的四个数字，两两分别作为分子分母
    public static void generate() {
        do {
            System.out.println("请输入您要进行的操作：\n-n设置生成题目数 / -r设置题目中的数值\n-c设置生成题目类型 / -e设置完成");
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            if (s.equals("-n")) {
                System.out.println("请输入您要生成的题目数量：");
                problems = sc.nextInt();
                System.out.println("成功获得您要生成的题目数：" + problems);
            }
            if (s.equals("-r")) {
                System.out.println("请输入您设置的题目内容数值：");
                max = sc.nextInt();
                System.out.println("成功获得您要设置的题目内容数值信息：" + max);
            }
            if (s.equals("-c")) {
                System.out.println("请输入你你要设置的题目类型（1为整数，2为分数）：");
                type = sc.nextInt();
                if (type == 1) System.out.println("成功获得您要设置的题目类型：整数");
                if (type == 2) System.out.println("成功获得您要设置的题目类型：分数");
            }
        } while (!s.equals("-e"));
    }


    public static String getOperate(int k) {    //数字对应运算符
        String str = "";
        switch (k) {
            case 1:
                str = "+";
                break;
            case 2:
                str = "-";
                break;
            case 3:
                str = "×";
                break;
            case 4:
                str = "÷";
                break;
        }
        return str;
    }


    public static void main(String[] args) {
        Generate.generate();
        Operate op = new Operate();
        writeExercise wE = new writeExercise();
        writeAnswer wA = new writeAnswer();
        writeGrade wG = new writeGrade();
        Random r = new Random();
        boolean isAnswer = true;//是否答题
        String[] strings1 = new String[problems];  //整数运算的题目
        String[] strings2 = new String[problems];  //整数运算的答案
        String[] strings3 = new String[problems];  //分数运算的题目
        String[] strings4 = new String[problems];  //分数运算的答案
        ArrayList<String> strings5 = new ArrayList<>();  //对的题目序号
        ArrayList<String> strings6 = new ArrayList<>();  //错的题目序号
        int[] numbers = new int[max];
        for (int j = 1; j <= max; j++) {
            numbers[j - 1] = j;
        }
        switch (type) {
            case (1):  ///////////////////////////////////整数/////////////////////////////////////
                System.out.println("是否需要答题\n"+"1.需要 2.不需要");
                Scanner input  = new Scanner(System.in);
                if(input.nextInt()==1)
                {
                    isAnswer = true;
                }else isAnswer = false;

                String[] ch1 = new String[problems * 3];        //算式内容填入数组

                for (int i = 0; i < problems; i++) {
                    x1 = numbers[r.nextInt(max)];          //x1与x2进行四则运算
                    x2 = numbers[r.nextInt(max)];
                    s2 = getOperate(r.nextInt(4) + 1);

                    if (x2 == 0 && s2.equals("÷")) {    //控制除法分母不为0
                        do x2 = numbers[r.nextInt(max)];
                        while (x2 == 0);
                    }
                    if ((x1 < x2) && s2.equals("-")) {   //控制减法前数不能小于后数
                        int o;
                        o = x1;
                        x1 = x2;
                        x2 = o;
                    }

                    Duplicate_Checking.zsDC(i, x1, x2, max, s2, ch1, numbers);      //防止算式重复

                    s1 = x1 + s2 + x2 + "=";
                    strings1[i] = s1;
                    strings2[i] = op.zsCalculation(x1, x2, s2);

                    if(isAnswer){
                        System.out.println(strings1[i]);
                        if (Grade.Equals(strings2[i])){strings5.add( String.valueOf(i+1)) ;}
                        else {strings6.add(String.valueOf(i+1));}
                    }//存入题目的序号

                    //存入数组的时候，加法乘法统一将大的数放在前面
                    if (((x1 < x2) && s2.equals("+")) || ((x1 < x2) && s2.equals("×"))) {
                        int o1;
                        o1 = x1;
                        x1 = x2;
                        x2 = o1;
                    }
                    ch1[i * 3] = String.valueOf(x1);
                    ch1[i * 3 + 2] = String.valueOf(x2);
                    ch1[i * 3 + 1] = s2;
                }

                try {
                    wE.wExercise(strings1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    wA.wAnswer(strings2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    wG.wGradeRight(strings5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    wG.wGradeWrong(strings6);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case (2):  ///////////////////////////////////分数/////////////////////////////////////
                System.out.println("是否需要答题\n"+"1.需要 2.不需要");
                Scanner input2  = new Scanner(System.in);
                if(input2.nextInt()==1)
                {
                    isAnswer = true;
                }else isAnswer = false;
                String[] ch2 = new String[problems*5];        //算式内容填入数组
                for (int i = 0; i < problems; i++) {
                    x3 = numbers[r.nextInt(max)];            //x3/x4与x5/x6进行四则运算
                    x4 = numbers[r.nextInt(max)];
                    x5 = numbers[r.nextInt(max)];
                    x6 = numbers[r.nextInt(max)];
                    s2 = getOperate(r.nextInt(4) + 1);
                    float j = x3 ,k = x4 ,l = x5 ,m = x6;
                    if((x4 == 0)||(x6 == 0)){                //控制分母不为0
                        do{
                            x4 = numbers[r.nextInt(max)];
                            x6 = numbers[r.nextInt(max)];
                        }while(x4 == 0||x6 == 0);
                    }
                    k = x4 ;m = x6;
                    if((j/k) < (l/m) && s2.equals("-")){        //控制减法计算中前数大于后数
                        int x,z;
                        x=x3;z=x4;x3=x5;x4=x6;x5=x;x6=z;
                    }

                    Duplicate_Checking.fsDC(i , x3 ,x4 ,x5, x6, max , s2 , ch2 , numbers);

                    s1 = x3 + "/" + x4 + s2 + x5 + "/" + x6 + "=";
                    strings3[i] = s1;
                    strings4[i] = op.fsCalculation(x3, x4, x5, x6, s2);
                    if(isAnswer){
                        System.out.println(strings3[i]);
                        if (Grade.Equals(strings4[i])){strings5.add( String.valueOf(i+1)) ;}
                        else {strings6.add(String.valueOf(i+1));}
                    }//存入题目的序号

                    //存入数组的时候，加法乘法统一将大的数放在前面
                    if( (((j/k) < (l/m)) && s2.equals("+")) || ((j/k) < (l/m) && s2.equals("×")) ){
                        int o2,o3;
                        o2 = x3;
                        o3 = x4;
                        x3 = x5;
                        x4 = x6;
                        x5 = o2;
                        x6 = o3;
                    }
                    ch2[i*5] = String.valueOf(x3);
                    ch2[i*5+1] = String.valueOf(x4);
                    ch2[i*5+2] = s2;
                    ch2[i*5+3] = String.valueOf(x5);
                    ch2[i*5+4] = String.valueOf(x6);
                }

                try {
                    wE.wExercise(strings3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    wA.wAnswer(strings4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    wG.wGradeRight(strings5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    wG.wGradeWrong(strings6);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}