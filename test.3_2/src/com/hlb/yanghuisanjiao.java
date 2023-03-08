package com.hlb;

public class yanghuisanjiao {
    public static void main(String[] args)
    {
        int[][] arr = new int[10][10];
        int i = 0,j = 0;
        for(i = 0;i < arr.length;i++)
        {
            for(j = 0;j <= i;j++)
            {
                if (i == j || j == 0)
                {
                    arr[i][j] = 1;
                }
                else
                {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        for (i = 0 ;i < arr.length;i++)
        {
            for (int k = 10;k > i ;k--)
            {
                System.out.print(" ");
            }
            for (j = 0 ; j <= i; j++)
            {
                System.out.printf("%3d",arr[i][j]);
            }
            System.out.print("\n");
        }
    }
}
