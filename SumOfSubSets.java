import java.util.Scanner;
public class SumOfSubSets
{
int[]w;
int[]x;
int sum;
public void getData()
{
Scanner sc=new Scanner(System.in);
System.out.print("ENTER NUMBER OF ELMENTS:");
int n=sc.nextInt();
w=new int[n+1];
x=new int[n+1];
int total=0;
System.out.println("ENTER "+n+" ELEMENTS:");
for(int i=1;i<n+1;i++)
{
w[i]=sc.nextInt();
total+=w[i];
}
System.out.println("ENTER THE SUM:");
sum=sc.nextInt();
if(total<sum)
{
System.out.println("NOT POSSIBLE TO SUM OF SUBSETS!!!");
System.exit(1);
}
subset(0,1,total);
sc.close();
}
private void subset(int s,int k,int r)
{
int i=0;
x[k]=1;
if(s+w[k]==sum)
{
System.out.println();
for(i=1;i<=k;i++)
{
System.out.print("\t"+x[i]);
}
}
else if((s+w[k]+w[k+1])<=sum)
{
subset(s+w[k],k+1,r-w[k]);
}
if((s+r-w[k])>=sum &&(s+w[k+1])<=sum)
{x[k]=0;
subset(s,k+1,r-w[k]);
}
}
public static void main(String []args)
{
new SumOfSubSets().getData();
}
}