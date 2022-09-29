public class Operate {

    public static int way(int m ,int n){  //递归计算用于求分子分母最大公因数
        if (m>n && m%n==0){
            return  n;
        }else {
            return way(n,(m%n));
        }
    }

    public static String zsCalculation(int a , int b , String k){    //控制整数四则运算的基本算法
        String answer = null;
        int m;
        switch (k){
            case "+" : answer = String.valueOf(a+b);
                break;
            case "-" : answer = String.valueOf(a-b);
                break;
            case "×" : answer = String.valueOf(a*b);
                break;
            case "÷" :
                if(a<=b){
                    if(b%a==0){
                        answer = "1/"+ b/a;
                    }
                    else answer = a/way(b,a) + "/" + b/way(b,a);
                }
                else {
                    m=a/b;
                    if(a%b == 0){
                        answer = String.valueOf(a/b);
                    }
                    else if(b%(a%b)==0){
                        answer = m + "‘" + "1/" + b/(a%b);
                    }
                    else {
                        //需要计算最大公因数判断是否可以约分
                        answer = m + "‘" + (a%b)/way(a%b,b) + "/" + b/way(a%b,b);
                    }
                }
                break;
        }
        return answer;
    }


    public static int way1(int m ,int n) {  //求分母最小公倍数
        int max = Math.max(n, m);
        int num = max;
        for (int i = 1; i < n; i++) {
            if (num % m == 0 && num % n == 0) {
                break;
            } else num = max * i;
        }
        return num;
    }


    public static String fsCalculation(int a,int b,int c,int d,String k){         //分数四则运算
        String answer1 = null;
        int g = 0,h = 0,i;
        switch (k){
            case "+": {
                    h = way1(b, d);
                    g = a * ( h / b ) + c * ( h / d );
                    if (g <= h) {
                        if (h % g == 0) {
                            answer1 = "1/" + h / g;
                        } else answer1 = g / way(h , g) + "/" + h / way(h , g);
                    } else {
                        i = g / h;
                        if (g % h == 0) {
                            answer1 = String.valueOf(i);
                        } else if (h % (g % h) == 0) {
                            answer1 = i + "‘" + "1/" + h / (g % h);
                        } else {
                            //需要计算最大公因数判断是否可以约分
                            answer1 = i + "‘" + (g % h) / way(g % h, h) + "/" + h / way(g % h, h);
                        }
                    }
                }
                break;

            case "-": {
                h = way1(b, d);
                g = a * (way1(b, d) / b) - c * (way1(b, d) / d);
                if (g <= h) {
                    if (h % g == 0) {
                        answer1 = "1/" + h / g;
                    } else answer1 = g / way(h , g) + "/" + h / way(h , g);
                } else {
                    i = g / h;
                    if (g % h == 0) {
                        answer1 = String.valueOf(g / h);
                    } else if (h % (g % h) == 0) {
                        answer1 = i + "‘" + "1/" + h / (g % h);
                    } else {
                        //需要计算最大公因数判断是否可以约分
                        answer1 = i + "‘" + (g % h) / way(g % h, h) + "/" + h / way(g % h, h);
                    }
                }
            }
                break;

            case "×":{
                g = a * c;
                h = b * d;
                if (g <= h) {
                    if (h % g == 0) {
                        answer1 = "1/" + h / g;
                    } else answer1 = g / way(h , g) + "/" + h / way(h , g);
                } else {
                    i = g / h;
                    if (g % h == 0) {
                        answer1 = String.valueOf(g / h);
                    } else if (h % (g % h) == 0) {
                        answer1 = i + "‘" + "1/" + h / (g % h);
                    } else {
                        //需要计算最大公因数判断是否可以约分
                        answer1 = i + "‘" + (g % h) / way(g % h, h) + "/" + h / way(g % h, h);
                    }
                }
            }
                break;

            case "÷":{
                g = a * d;
                h = b * c;
                if(g == 0 || h == 0) answer1 = String.valueOf(0);
                else if (g <= h) {
                    if (h % g == 0) {
                        answer1 = "1/" + h / g;
                    } else answer1 = g / way(h , g) + "/" + h / way(h , g);
                } else {
                    i = g / h;
                    if (g % h == 0) {
                        answer1 = String.valueOf(g / h);
                    } else if (h % (g % h) == 0) {
                        answer1 = i + "‘" + "1/" + h / (g % h);
                    } else {
                        //需要计算最大公因数判断是否可以约分
                        answer1 = i + "‘" + (g % h) / way(g % h, h) + "/" + h / way(g % h, h);
                    }
                }
                break;
            }
        }
        if(g == h) answer1 = "1";
        return answer1;
    }
}
