递归   
递归的模板 

public void recur(int level,int param){
  // teminator
	if(level > MAX_LEVEL){
  return;
  }
  //process currentlogic
  process(level,param);
  // drill down
  recur(level:level+1,newParam);
  
  // restore current status
}

 

递归的思维要点

1.不要使用人肉递归
2.找到最简方法,将其拆解成可重复 解决的问题(重复子问题)
3.数学归纳思维


分治和回溯 都是递归的一种

分治的思想 : 分而治之,把一个大的问题分解为多个子问题,然后在找到子问题当中的重复性部分,写成代码

def divide_conquer(problem,param1.param2,...):
  #  recursion terminator  到达叶子节点,一般是到达没有问题需要解决的 时候
  if problem is None:
    print_result
    retuen 
  #  prepare data 处理当前逻辑
  data = prepare_data(problem)
  subproblems = split_problem(problem,data)
  # conquer subproblems 调用函数下探到下一层
  subresult1 = self.divide_conquer(subproblems[0],p1,).)
  subresult2 = self.divide_conquer(subproblems[1],p1,).)
  subresult3 = self.divide_conquer(subproblems[2],p1,).)
	# process and generate the final result 把子问题的结果结合返回答案
  result = process_result(subresule1,subresult2,subresult3)3)
 	 

回溯

回溯法 采用试错的思想,它尝试分步去解决一个问题,在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候,它将取消上一步甚至是上几步的计算,再通过其他的可能的分步解答再次尝试寻找问题的答案

