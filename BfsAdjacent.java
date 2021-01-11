import java.util.LinkedList;
import java.util.Queue;
public class BfsAdjacent
{
int[][] adjMatrix;
int rootNode=0;
int NNodes;
boolean[] visited;
BfsAdjacent(int[][] mat)
{
int i,j;
NNodes=mat.length;
adjMatrix=new int[NNodes][NNodes];
visited=new boolean[NNodes];
for(i=0;i<NNodes;i++)
for(j=0;j<NNodes;j++)
adjMatrix[i][j]=mat[i][j];
}
public void BFS()
{
Queue<Integer>q=new LinkedList<Integer>();
clearVisited();
q.add(0);
while(!q.isEmpty())
{
int nextNode;
int i;
nextNode=q.remove();
if(!visited[nextNode])
{
visited[nextNode]=true;
System.out.print(" "+nextNode+" ");
for(i=0;i<NNodes;i++)
if(adjMatrix[nextNode][i]>0 && !visited[i])
q.add(i);
}
}
}
/*int UnvisitedChildNode(int n)
{
int j;
for(j=0;j<NNodes;j++)
{
if(adjMatrix[n][j]>0)
{
if(!visited[j])
return (j);
}
}
return (-1);
}*/
void clearVisited()
{
int i;
for(i=0;i<visited.length;i++)
visited[i]=false;
}
void printNode(int n)
{
System.out.println(n);
}
public static void main(String[] args)
{
int[][] conn={ {0,1,0,1,0,0,0,0,1},
               {1,0,0,0,0,0,0,1,0},
               {0,0,0,1,0,1,0,1,0},
               {1,0,1,0,1,0,0,0,0}, 
               {0,0,0,1,0,0,0,0,1},
               {0,0,1,0,0,0,1,0,0},
               {0,0,0,0,0,1,0,0,0},
               {0,1,1,0,0,0,0,0,0},
               {1,0,0,0,1,0,0,0,0}};
BfsAdjacent G=new BfsAdjacent(conn);
G.BFS();
}
}