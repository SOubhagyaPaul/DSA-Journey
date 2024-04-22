package sortingProgs;

class HeapSort{
	int a[];
	HeapSort(int a[]){
		this.a=a;
	}
	
	void maxheapify(int a[], int n, int i)
	{
	    int temp;
	    int largest = i;
	    int l = (2 * i);
	    int r = (2 * i) + 1;
	    if (l <= n && a[l] > a[largest])
	        largest = l;
	    if (r <= n && a[r] > a[largest])
	        largest = r;
	    if (largest != i)
	    {
	        temp = a[i];
	        a[i] = a[largest];
	        a[largest] = temp;
	        maxheapify(a, n, largest);
	    }
	}
	

	void sort(int a[], int n)
	{
		int temp;
		for (int i = (n / 2)-1; i >= 1; i--)
		{
			maxheapify(a, n, i);
		}
		for (int i = n; i >= 0; i--)
		{
			temp = a[1];
			a[1] = a[i];
			a[i] = temp;
			maxheapify(a, i-1, 1);
		}
	}
	void disp() {
		for(int i=0;i<a.length;i++)
				System.out.println(a[i]);
	}

}
