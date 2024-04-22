package sortingProgs;

class QuickSort{
	
	int partition(int a[],int l,int h) {
		int pivot=a[l];
		int i=l;
		int j=h;
		while(i< j ){
			while (a[i]<=pivot && i < h)
			{
				i++;
			} 
			while (a[j]>pivot)
			{
				j--;
			}
			if(i<j)
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}

		}
		int temp=a[l];
		a[l]=a[j];
		a[j]=temp;
		return j;
	}
	
	void quick(int a[],int l,int h) {
		if(l<h) {
			int loc=partition(a,l,h);
			quick(a,l,loc-1);
			quick(a,loc+1,h);
		}
		
	}
	void disp(int a[]) {
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
