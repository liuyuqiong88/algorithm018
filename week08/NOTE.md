
位运算

布隆过滤器和LUR缓存


排序算法 

初级排序和高级排序的特性 

1 . 比较类排序 : 

通过比较来决定元素间的相对次序,由于其时间复杂度不能土坡O(nlogb),因此也称为非线性时间比较 

交换排序 : 冒泡排序 ; 快速排序

插入排序 : 简单插入排序 ; 希尔排序 

选择排序 : 简单选择排序 ; 堆排序

归并排序 : 二路归并排序;多路归并排序

2 . 非比较排序 

计数排序

桶排序

基数排序

 

初级排序 - O(n^2) : 

1 . 选择排序 (Selection Sort)

每次找最小值,然后放到待排序数组的起始位置

2 . 插入排序 (Insertion Sort) 

从前到后逐步构建有序序列;对于未排序数据,在已排序序列中从后向前扫描,找到相应位置并插入

3 . 冒泡排序 (Bubble Sort)

嵌套循环,每次查看相邻的元素如果逆序,则交换

高级排序 - O(N * LogN)

快速排序 (Quick Sort)

数组取标杆 pivot , 将小元素放 pivot左边,大元素放右侧,然后依次对右边和右边的子数组继续快排;以达到整个序列有序

代码模板 

# java
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
        return counter;
    }

#Python版本 

    def quick_sort(begin, end, nums):
        if begin >= end:
            return
        pivot_index = partition(begin, end, nums)
        quick_sort(begin, pivot_index-1, nums)
        quick_sort(pivot_index+1, end, nums)
        
    def partition(begin, end, nums):
        pivot = nums[begin]
        mark = begin
        for i in range(begin+1, end+1):
            if nums[i] < pivot:
                mark +=1
                nums[mark], nums[i] = nums[i], nums[mark]
        nums[begin], nums[mark] = nums[mark], nums[begin]
        return mark

归并排序 (Merge Sort ) - 分治 

把长度为n的输入序列分为两个长度为 n / 2 的子序列;

对着两个子序列分别采用归并排序;

将两个排序好的子序列合并成一个最终的排序序列

代码模板

#java
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1; // (left + right) / 2
    
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }
    
    public static void merge(int[] arr, int left, int mid, int right) {
            int[] temp = new int[right - left + 1]; // 中间数组
            int i = left, j = mid + 1, k = 0;
    
            while (i <= mid && j <= right) {
                temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            }
    
            while (i <= mid)   temp[k++] = arr[i++];
            while (j <= right) temp[k++] = arr[j++];
    
            for (int p = 0; p < temp.length; p++) {
                arr[left + p] = temp[p];
            }
            // 也可以用 System.arraycopy(a, start1, b, start2, length)
        }

#python 版本 

    def mergesort(nums, left, right):
        if right <= left:
            return
        mid = (left+right) >> 1
        mergesort(nums, left, mid)
        mergesort(nums, mid+1, right)
        merge(nums, left, mid, right)
    
    def merge(nums, left, mid, right):
        temp = []
        i = left
        j = mid+1
        while i <= mid and j <= right:
            if nums[i] <= nums[j]:
                temp.append(nums[i])
                i +=1
            else:
                temp.append(nums[j])
                j +=1
        while i<=mid:
            temp.append(nums[i])
            i +=1
        while j<=right:
            temp.append(nums[j])
            j +=1
        nums[left:right+1] = temp

归并 和 快排具有相似性,但步骤顺序相反 

归并 : 先排序左右子数组,然后合并两个有序子数组 

快排 : 先调配出左右子数组,然后对于左右子数组进行排序

堆排序 (Heap Sort ) - 堆插入 O(logN),取最大/小值 O(1)

1 . 数组元素一次建立小项堆 

2 . 一次取堆顶元素,并删除

JAVA 模板 

#
    static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2；
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
            heapify(array, length, largest);
        }
    }
    public static void heapSort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2-1; i >= 0; i-) 
            heapify(array, length, i);
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0]; array[0] = array[i]; array[i] = temp;
            heapify(array, i, 0);
        }
    }

python 模板 

#
    def mergesort(nums, left, right):
        if right <= left:
            return
        mid = (left+right) >> 1
        mergesort(nums, left, mid)
        mergesort(nums, mid+1, right)
        merge(nums, left, mid, right)
    
    def merge(nums, left, mid, right):
        temp = []
        i = left
        j = mid+1
        while i <= mid and j <= right:
            if nums[i] <= nums[j]:
                temp.append(nums[i])
                i +=1
            else:
                temp.append(nums[j])
                j +=1
        while i<=mid:
            temp.append(nums[i])
            i +=1
        while j<=right:
            temp.append(nums[j])
            j +=1
        nums[left:right+1] = temp

