import java.util.*;
public class QUICKSORT1 
{
public static void quickSort(int arr[], int low, int high)
{
int i = low, j = high;
int temp;
int pivot = arr[low];
while (i <= j)
{
while (arr[i] < pivot)
i++;
while (arr[j] > pivot)
j--;
if (i <= j)
{
temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
i++;
j--;
}
}
if (low < j) 
quickSort(arr, low, j);
if (i < high) 
quickSort(arr, i, high);
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
System.out.println("***********QUICK SORT**********:");
System.out.println("ENTER SIZE Of ARRAY:");
n = s.nextInt();
int arr[] = new int[ n ]; 
System.out.println("\nENTER "+ n +" ELEMENTS"); 
for (i = 0; i <n; i++)
arr[i] = s.nextInt();
quickSort(arr, 0, arr.length - 1); 
System.out.println("SORTED ARRAY::");
printArray(arr);
s.close();
}
}