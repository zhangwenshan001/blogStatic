type numHeap []int

func (h numHeap) Len() int {
	return len(h)
}

func (h numHeap) Less(i, j int) bool {
	return h[i] < h[j]
}

func (h numHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *numHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *numHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0:n-1]
	return x
}

type SmallestInfiniteSet struct {
    CurNum int
    Heap *numHeap
    Marked []bool
    N int
}


func Constructor() SmallestInfiniteSet {
    h := &numHeap{}
    return SmallestInfiniteSet{CurNum: 1, Heap: h, Marked: make([]bool, 1000), N:0,}
}


func (this *SmallestInfiniteSet) PopSmallest() int {
    if this.N > 0 {
        num := heap.Pop(this.Heap).(int)
        this.Marked[num] = false
        this.N = this.N - 1 
        return num
    }
    
    this.CurNum = this.CurNum + 1
    return this.CurNum-1
}


func (this *SmallestInfiniteSet) AddBack(num int)  {
    if num >= this.CurNum || this.Marked[num] { //already exists
        return
    }
    this.Marked[num] = true
    heap.Push(this.Heap, num)
    this.N = this.N + 1
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.PopSmallest();
 * obj.AddBack(num);
 */