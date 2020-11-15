深度优先搜索 DFS

python递归代码模板

visited = set()
def DFS(root,visited):
  if root in visited : # terminator
    # already visited
    return
  
  visited.add(root)
  
  # process current node here. 
  for node in root.children:
    if node not in visited:
      DFS(node,visited)
  

JAVA 递归模板

 public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }

PYTHON非递归写法 

def DFS(tree):
	if tree.root is None :
    return []
  
 visited , stack = [] , [tree.root]
	while stack :
    node = stack.pop()
    visited.add(node)

    process(node)
    nodes = generate_related_nodes(node)
  
  # other processing work 

广度优先搜索  BFS


def BFS(tree):
  queue = []
  visited = set()
  queue.add(tree)
  
  while(queue):
    node = queue.pop()
 
    visited.add(node)
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
  
  # other processing work 

JAVA 版本 

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}



使用贪心算法的两个条件 : 

通过贪心算法是可以得到最优解的

贪心的切入时机,可能是从后往前贪心,也可能是从某一个局部切入进行贪心


二分查找的前提 ：

1.目标函数单调性(单调递增或者递减)

2.存在上下界(bounded)

3.能够通过索引访问 ( index accessible )

代码模板 : 

left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1

刷题理解 : 二分查找是一种思路,是不断分区夹逼的过程,这个切分区域可能不是简单的 比较大小 , 还可能是其他的更多的条件 ( 题目 : 搜索旋转排序数组)



