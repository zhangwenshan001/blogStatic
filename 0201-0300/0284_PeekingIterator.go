/*   Below is the interface for Iterator, which is already defined for you.
 *
 *   type Iterator struct {
 *       
 *   }
 *
 *   func (this *Iterator) hasNext() bool {
 *		// Returns true if the iteration has more elements.
 *   }
 *
 *   func (this *Iterator) next() int {
 *		// Returns the next element in the iteration.
 *   }
 */

type PeekingIterator struct {
    Iter *Iterator
    Last int
}

func Constructor(iter *Iterator) *PeekingIterator {
    var first int
    if iter.hasNext() {
        first = iter.next()
       
    } else {
        first = 0
    }
    return &PeekingIterator{Iter:iter, Last: first}
}

func (this *PeekingIterator) hasNext() bool {
    return this.Last != 0
}

func (this *PeekingIterator) next() int {
    last := this.Last
    if (this.Iter.hasNext()) {
        this.Last = this.Iter.next()
    } else {
        this.Last = 0
    }
    
    return last
}

func (this *PeekingIterator) peek() int {
    return this.Last
}