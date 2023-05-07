import java.util.Arrays;
import java.util.Scanner;

/*
  primitive vs Object
 */
public class Sort01{


    static class Elem implements Comparable<Elem>{

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
           if(korean != other.korean) return other.korean - korean; // descending
           if(english != other.english) return english - other.english; // ascending//
           if(math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }
    static int N;
    static Elem[] elems;
    static StringBuilder sb = new StringBuilder();
    static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        elems = new Elem[N];
        for(int i = 0; i < N; i++){
            elems[i] = new Elem();
            elems[i].name = sc.next();
            elems[i].korean = sc.nextInt();
            elems[i].english = sc.nextInt();
            elems[i].math = sc.nextInt();
        }
    }

    static void resultView(){
        Arrays.sort(elems);
        for(int i = 0 ; i < N ; i++){
            sb.append(elems[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        input();
        resultView();
    }


}
