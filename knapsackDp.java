import java.util.Scanner;
import java.lang.Math;
public class knapsackDp
{
public void solve(int[]wt,int[]val,int W,int N)
{
int i,j;
int [][]sol=new int[N+1][W+1];
for(i=0;i<=N;i++)
{
for(j=0;j<=W;j++)
{
if(i==0||j==0)
sol[i][j]=0;
else if(wt[i]>j)
sol[i][j]=sol[i-1][j];
else
sol[i][j]=Math.max(sol[i-1][j],(sol[i-1][j-wt[i]]+val[i]));
}
}
System.out.println("The optimal solution is "+sol[N][W]);
int[]selected=new int[N+1];
for(i=0;i<N;i++)
selected[i]=0;
i=N;
j=W;
while(i>0&&j>0)
{
if(sol[i][j]!=sol[i-1][j])
{
selected[i]=1;
j=j-wt[i];
}
i--;
}
System.out.println("\n items selected:");
for(i=1;i<N+1;i++)
if(selected[i]==1)
System.out.print(i+" ");
System.out.println();
}
public static void main(String[]args)
{
Scanner scan=new Scanner(System.in);
knapsackDp ks=new knapsackDp();
System.out.println("enter number of elements:");
int n=scan.nextInt();
int []wt=new int[n+1];
int []val=new int[n+1];
System.out.println("\n Enter weight for "+n+"elements");
for(int i=1;i<=n;i++)
wt[i]=scan.nextInt();
System.out.println("\n enter value for "+n+"elements");
for(int i=1;i<=n;i++)
val[i]=scan.nextInt();
System.out.println("\n enter knapsack weights:");
int w=scan.nextInt();
ks.solve(wt,val,w,n);
scan.close();
}
}