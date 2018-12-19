public class IntList{

	public int first;
	public IntList next;

	public IntList(int f, IntList n){
		first = f;
		next = n;
	}

	/** recursion method preferred*/
	// public int size(){
	// 	if(next == null){
	// 		return 1;
	// 	}
	// 	return 1 + next.size();
	// }

	/** iterative method 
	 * size() do not have 0 edge case, or else call size() on null(which means IntList's size is zero) will cause NullPointerException
	 * you can start off by change condition p => p.rest, which result should be instantiated as 1, work the same
	 * you can not change this object, which is a java keyword always points to the current object
	*/
	public int size(){
		int result =0;
		IntList p = this;
		while(p != null){
			p  = p.next;
			result = result + 1;

		}
		return result;
	}

	public int get(int index){
		IntList p = this;

		if(index == 0){
			return p.first;
		}
		
		p = p.next;
		
		return get(index - 1);
	}

	public static void main(String[] args){

    /** code will work even without constructor */
		// IntList a = new IntList();
		// a.first = 4;
		// a.next = new IntList();
		// a.next.first = 5;
		// a.next.next = new IntList();

		IntList a = new IntList(4,null);
		a = new IntList(5, a);
		a = new IntList(7, a);
		System.out.println(a.size());

	}
}