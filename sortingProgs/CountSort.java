package sortingProgs;

import java.util.Arrays;

class CountSort{
	int a[];
	int count[];
	int max;
	CountSort(int a[]){
		this.a=a;
		max = Arrays.stream(this.a).max().getAsInt();
		count=new int[max+1];
	}
	void sort() {
		for(int i=0;i<a.length;i++) {
			count[a[i]]++;
		}
		int i=0, j=0;
		while(i<max+1) {
			if(count[i]>0) {
				a[j++]=i;
				count[i]--;
			}
			else
				i++;
		}
	}
	void disp() {
		for(int i=0;i<a.length;i++)
				System.out.println(a[i]);
	}
}
