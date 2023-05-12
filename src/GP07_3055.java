import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
ESCAPE
 */
public class GP07_3055 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int R, C;
    static String[] A;
    static int[][] dir = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    static int[][] dist_water, dist_hedgehog;
    static boolean[][] visit;
    static void readInput(){
        R = sc.nextInt();
        C = sc.nextInt();
        A = new String[R];
        for(int i = 0; i < R; i++) A[i] = sc.next();
        dist_hedgehog = new int[R][C];
        dist_water = new int[R][C];
        visit = new boolean[R][C];
    }

    static void bfs_water(){
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 0; i < R; i++){
            for(int j = 0 ; j < C; j++){
                dist_water[i][j] = -1;
                visit[i][j] = false;
                if(A[i].charAt(j) == '*'){
                    Q.add(i);
                    Q.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        while(!Q.isEmpty()){
            int x = Q.poll(), y = Q.poll();
            for(int k = 0 ; k < 4 ; k++){
                int nx = x + dir[k][0], ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(A[nx].charAt(ny) != '.') continue;
                if(visit[nx][ny]) continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;

            }
        }
    }
    static void bfs_hedgehog(){
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 0 ; i < R; i++){
            for(int j = 0 ; j < C; j++){
                dist_hedgehog[i][j] = -1;
                visit[i][j] = false;
                if(A[i].charAt(j) == 'S'){
                    Q.add(i);
                    Q.add(j);
                    dist_hedgehog[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        while(!Q.isEmpty()){
            int x = Q.poll(), y = Q.poll();
            for(int k = 0 ; k < 4; k++){
                int nx = x + dir[k][0], ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(A[nx].charAt(ny) != '.'  && A[nx].charAt(ny) != 'D') continue;
                if(dist_water[nx][ny] !=-1 && dist_water[nx][ny] <= dist_hedgehog[x][y] + 1) continue;
                if(visit[nx][ny]) continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
            }
        }
    }

    static void calcOutput(){
        bfs_water();

        bfs_hedgehog();

        for(int i = 0; i < R; i++){
            for(int j = 0 ; j < C;j++){
                if(A[i].charAt(j) == 'D'){
                    if(dist_hedgehog[i][j] == -1) System.out.println("KAKTUS");
                    else System.out.println(dist_hedgehog[i][j]);

                }
            }
        }
    }

    public static void main(String[] args){
        readInput();

        calcOutput();
    }

}

