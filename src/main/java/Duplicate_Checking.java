import java.util.Random;
public class Duplicate_Checking {

    //整数查重
    public static void zsDC( int a , int b , int c , int d , String k , String[] ch , int[] num){
        if(a == 0)return;
        Random r1 = new Random();
        int m1 = Generate.x1; int m2 = Generate.x2;
        for(int i = 0;i<a;i++){
            if(((m1<m2) && k.equals("+"))||((m1<m2) && k.equals("×"))){
                int n=m1;
                m1=m2;
                m2=n;
            }
            if( ((String.valueOf(m1).equals(ch[i * 3]))
                    && (String.valueOf(m2).equals(ch[i * 3 + 2]))
                    && (k.equals(ch[i * 3 + 1]))) )
            {
                do{
                    Generate.x1 = num[r1.nextInt(d)];
                    Generate.x2 = num[r1.nextInt(d)];
                    Generate.s2 = Generate.getOperate(r1.nextInt(4) + 1);
                    m1 = Generate.x1;
                    m2 = Generate.x2;
                    if(((m1<m2) && k.equals("+"))||((m1<m2) && k.equals("×"))){
                        int n=m1;
                        m1=m2;
                        m2=n;
                    }
                    i = 0;
                }while ( ((String.valueOf(m1).equals(ch[i * 3]))
                        && (String.valueOf(m2).equals(ch[i * 3 + 2]))
                        && (k.equals(ch[i * 3 + 1]))) ) ;
            }
        }
    }

    //分数查重
    public static void fsDC( int a , int b , int c , int d , int e , int f , String k , String[] ch , int[] num){
        if(a == 0)return;
        Random r2 = new Random();
        float m,n,l,p,u1,u2;
        m=b;n=c;l=d;p=e;
        for(int i=0;i<a;i++){
            if((((m/n)<(l/p))&&k.equals("+")) || ((((m/n)<(l/p))&&k.equals("×")))){
                u1 = m;
                u2 = n;
                m = l;
                n = p;
                l = u1;
                p = u2;
            }
            if( (String.valueOf(m) == ch[i*5])
                    && (String.valueOf(n) == ch[i*5+1])
                    && (k == ch[i*5+2])
                    && (String.valueOf(l) == ch[i*5+3])
                    && (String.valueOf(p) == ch[i*5+4]) ){
                do{
                    Generate.x3 = num[r2.nextInt(f)];
                    Generate.x4 = num[r2.nextInt(f)];
                    Generate.x5 = num[r2.nextInt(f)];
                    Generate.x6 = num[r2.nextInt(f)];
                    Generate.s2 = Generate.getOperate(r2.nextInt(4) + 1);
                    m=Generate.x3;n=Generate.x4;l=Generate.x5;p=Generate.x6;
                    if((((m/n)<(l/p))&&k.equals("+")) || ((((m/n)<(l/p))&&k.equals("×")))){
                        u1 = m;
                        u2 = n;
                        m = l;
                        n = p;
                        l = u1;
                        p = u2;
                    }
                    i = 0;
                } while ( (String.valueOf(m) == ch[i*5])
                        && (String.valueOf(n) == ch[i*5+1])
                        && (k.equals(ch[i * 5 + 2]))
                        && (String.valueOf(l) == ch[i*5+3])
                        && (String.valueOf(p) == ch[i*5+4]) );
            }
        }
    }
}
