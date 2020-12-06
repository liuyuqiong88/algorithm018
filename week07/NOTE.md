

字典树 ( trie树)

字典树,即trie 树,又称单词查找树或键树,是一种树形结构.典型应用是用于统计和排序大量的字符串(但不仅限于字符串),所以经常被搜索引擎系统用于文本词频统计

它的优点是 : 最大限度的减少无谓的

基本性质 : 

节点本身不存完整单词

从根节点到某一结点,路劲上经过的字符连接起来,为该结点对应的字符串

每个结点的所有子结点路径代表的字符都不相同

核心思想 : 

空间换时间

Trie 的实现


    class Trie {
        private boolean isEnd;
        private Trie[] next;
        /** Initialize your data structure here. */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}

# Python 
    class Trie(object):
  
	def __init__(self): 
		self.root = {} 
		self.end_of_word = "#" 
 
	def insert(self, word): 
		node = self.root 
		for char in word: 
			node = node.setdefault(char, {}) 
		node[self.end_of_word] = self.end_of_word 
 
	def search(self, word): 
		node = self.root 
		for char in word: 
			if char not in node: 
				return False 
			node = node[char] 
		return self.end_of_word in node 
 
	def startsWith(self, prefix): 
		node = self.root 
		for char in prefix: 
			if char not in node: 
				return False 
			node = node[char] 
		return True


并查集 

组团、配对问题 

基本操作 

makeSet(s) : 建立一个新的并查集,其中包含s个单元素集合

unionSet(x,y) : 把元素x和元素y所在的集合合并,要求x和y所在的集合不相交,如果相交则不合并

find(x) : 找到元素x所在的集合的代表,该操作也可以用于判断两个元素是否位于同一个集合,只要将他们各自的代表比较一下就可以了

并查集实现代码模板 JAVA

# Java
    class UnionFind { 
        private int count = 0; 
        private int[] parent; 
        public UnionFind(int n) { 
            count = n; 
            parent = new int[n]; 
            for (int i = 0; i < n; i++) { 
                parent[i] = i;
            }
        } 
        public int find(int p) { 
            while (p != parent[p]) { 
                parent[p] = parent[parent[p]]; 
                p = parent[p]; 
            }
            return p; 
        }
        public void union(int p, int q) { 
            int rootP = find(p); 
            int rootQ = find(q); 
            if (rootP == rootQ) return; 
            parent[rootP] = rootQ; 
            count--;
        }
    }

python 模板 

# Python 
    def init(p): 
        # for i = 0 .. n: p[i] = i; 
        p = [i for i in range(n)] 
     
    def union(self, p, i, j): 
        p1 = self.parent(p, i) 
        p2 = self.parent(p, j) 
        p[p1] = p2 
     
    def parent(self, p, i): 
        root = i 
        while p[root] != root: 
            root = p[root] 
        while p[i] != i: # 路径压缩 ?
            x = i; i = p[i]; p[x] = root 
        return root

