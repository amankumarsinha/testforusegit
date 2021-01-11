import java.util.Scanner;
public class MergeSort
{
 static void mergesort(int[] arr, int low, int high)
{
int mid;
if(low<high)
{
mid=(low+high)/2;
mergesort(arr,low,mid);
mergesort(arr,mid+1,high);
combine(arr,low,mid,high);
}
}
static void combine(int arr[], int low, int mid, int high)
{
int i,j,k;
int[] temp = new int[10];
k=low; i=low; j=mid+1;
while(i<=mid&&j<=high)
{
if(arr[i]<=arr[j])
{
 temp[k]=arr[i]; i++; k++; 
}
else
{
 temp[k]=arr[j]; j++; k++; 
}
}
while(i<=mid)
{
 temp[k]=arr[i]; i++; k++; 
}
while(j<=high)
{
 temp[k]=arr[j]; j++; k++; 
}
for(k=low;k<=high;k++)
arr[k]=temp[k];
}
static void printArray(int arr[])
{
int n = arr.length;
for (int i=0; i<n; ++i)
System.out.print(arr[i]+" ");
System.out.println();
}
public static void main(String[] args)
{
Scanner s = new Scanner(System.in );
int n, i;
System.out.println("***********MERGE SORT**********:");
System.out.println("ENTER SIZE Of ARRAY:"); 
n = s.nextInt();
int arr[] = new int[ n ];
System.out.println("\nENTER "+ n +" ELEMENTS"); 
for (i = 0; i <n; i++)
arr[i] = s.nextInt();
mergesort(arr, 0, arr.length-1); 
System.out.println("SORTED ARRAY::"); 
printArray(arr);
s.close();
}
}