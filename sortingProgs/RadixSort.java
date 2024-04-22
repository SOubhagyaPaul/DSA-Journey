package sortingProgs;

import java.util.Arrays;

class RadixSort{
	int a[];
	int count[];
	int max;
	int nPass;
	int size,divisor,r;
	int bucket_count[];
	int bucket[][];
	RadixSort(int a[]){
		this.a=a;
		size=10;
		max = Arrays.stream(this.a).max().getAsInt();
		nPass=countDigits(max); 
		//nPass=(int)(Math.log10(max))+1;
		bucket_count=new int[size];
		bucket=new int [size][size];
		divisor=1;
	}
	void sort() {
		for(int pass=0;pass<nPass;pass++) {
			for(int i=0;i<size;i++)
				bucket_count[i]=0;
		for(int i=0;i<a.length;i++) {
			r=(a[i]/divisor)%size;
			bucket[r][bucket_count[r]]=a[i];
			bucket_count[r]+=1;
		}
		int i=0;
		for(int k=0;k<size;k++) {
			for(int j=0;j<bucket_count[k];j++) {
				a[i]=bucket[k][j];
				i++;
			}
		}
		
		divisor*=size;	
		}
	}
	void disp() {
		for(int i=0;i<a.length;i++)
				System.out.println(a[i]);
	}
	int countDigits(int x){
	    int count = 0;
	    while (x != 0){
	        x = x / 10;
	        count++;
	    }
	    return count;
	}
	int getBinIndex(int x, int idx){
	    return (int)(x / Math.pow(10, idx)) % 10;
	}

}
