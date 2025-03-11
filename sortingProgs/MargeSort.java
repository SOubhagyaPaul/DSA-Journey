package sortingProgs;

class MargeSort{
	void merge(int [] a,int lb,int mid,int ub) {
		int n1=mid-lb+1;
		int n2=ub-mid;
		int leftsub[]=new int[n1];
		int rightsub[]=new int [n2];
		for(int i=0;i<n1;i++)
			leftsub[i]=a[lb+i];
		for(int j=0;j<n2;j++)
			rightsub[j]=a[mid+1+j];
		int i=0,j=0,k=lb;
		while(i<n1 && j<n2) {
			if(leftsub[i]<=rightsub[j]) {
				a[k]=leftsub[i];
				i++;
			}
			else {
				a[k]=rightsub[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			a[k]=leftsub[i];
			i++;
			k++;
		}
		while(j<n2) {
			a[k]=rightsub[j];
			j++;
			k++;
		}
	}
	void sort(int a[],int lb,int ub){
		if(lb<ub) {
			int mid=(int) Math.floor((lb+ub)/2);
			sort(a,lb,mid);
			sort(a,mid+1,ub);
			merge(a,lb,mid,ub);
		}
	}
	void disp(int a[]) {
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
