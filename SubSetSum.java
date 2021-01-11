import java.util.Scanner;
public class SubSetSum
{
public static void main(String [] args)
{
Scanner sc=new Scanner(System.in);
System.out.print("ENTER NUMBER OF ELEMENTS:");
int n=sc.nextInt();
int []input=new int[n+1];
int total=0;
System.out.println("ENTER "+n+" ELEMENTS:");
for(int i=1;i<n+1;i++)
{
input[i]=sc.nextInt();
total+=input[i];
}
System.out.println("ENTER THE SUM:");
int targetSum=sc.nextInt();
if(total<targetSum)
{
System.out.println("NOT POSSIBLE TO SUM OF SUBSETS!!!");
System.exit(1);
}
SubSetSum subSetSum=new SubSetSum();
subSetSum.findSubSets(input,targetSum);
sc.close();
}
private int[]set;
private int[]SelectedElements;
private int targetSum;
private int numOfElements;
public void findSubSets(int[]set,int targetSum)
{
this.set=set;
this.numOfElements=set.length;
this.targetSum=targetSum;
SelectedElements=new int[numOfElements];
int sumOfAllElements=0;
for(int element:set)
{
sumOfAllElements+=element;
}
findSubSets(0,0,sumOfAllElements);
}
private void findSubSets(int sumTillNow,int index,int sumOfRemaining)
{
SelectedElements[index]=1;
if(targetSum==set[index]+sumTillNow)
{
print();
}
if((index+1<numOfElements)&&(sumTillNow+set[index]+set[index+1]<=targetSum))
{
findSubSets(sumTillNow+set[index],index+1,sumOfRemaining-set[index]);
}
SelectedElements[index]=0;
if((index+1<numOfElements)&&(sumTillNow+set[index+1]<=targetSum)&&(sumTillNow+sumOfRemaining-set[index]>=targetSum))
{
findSubSets(sumTillNow,index+1,sumOfRemaining-set[index]);
}
}
private void print()
{
for(int i=0;i<numOfElements;i++)
{
if(SelectedElements[i]==1)
{
System.out.print(set[i]+" ");
}
}
System.out.println();
}
}
